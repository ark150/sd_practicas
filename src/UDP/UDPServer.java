/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UDP;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import Model.Peticion;
import Model.Proceso;
import tokenring.RegionCritica;

/**
 *
 * @author ark
 */
public class UDPServer implements Runnable {
    private boolean kill;
    private RegionCritica region;
    private int puerto;
    public static int PUERTO_DEFAULT = 6789;

    public UDPServer()
    {
        this.kill = false;
        region = new RegionCritica();
        this.puerto = UDPServer.PUERTO_DEFAULT;
    }

    public UDPServer(int puerto)
    {
        this.kill = false;
        region = new RegionCritica();
        this.puerto = puerto;
    }

    public void kill() {
        this.kill = true;
    }

    @Override
    public void run()
    {
        try
        {
            DatagramSocket aSocket = new DatagramSocket(puerto);
            byte[] buffer = new byte[1000];
            while (!kill)
            {
                // Datagrama vacío
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                // Se queda bloqueado hasta encontrar un mensaje entrante.
                aSocket.receive(request);

                // Hacer la petición a la región crítica
                byte[] data = request.getData();

                ByteArrayInputStream in = new ByteArrayInputStream(data);
                ObjectInputStream is = new ObjectInputStream(in);
                Peticion p;

                try
                {
                    p = (Peticion) is.readObject();

                    if(p.getTipo() == Peticion.ASIGNA_RECURSO)
                        region.asignaRecurso(p.getPeticion());
                    else if(p.getTipo() == Peticion.VERIFICAR_DISPONIBILIDAD)
                    {
                        int value = (region.isInUse()) ? 1 : 0;
                        byte[] returnvalue = new byte[1000];
                        returnvalue[0] = (byte)value;

                        DatagramPacket reply = new DatagramPacket(
                            returnvalue, request.getLength(),
                            request.getAddress(), request.getPort());

                        // Se envía la respuesta desde la región crítica
                        // de vuelta al proceso.
                        aSocket.send(reply);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (SocketException e) {System.out.println("Socket: " + e.getMessage()); }
        catch (IOException e) {System.out.println("IO: " + e.getMessage());}
    }
}
