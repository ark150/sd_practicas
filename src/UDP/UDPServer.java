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
 * Servidor UDP que funciona sobre los nodos.
 * @author ark
 */
public class UDPServer implements Runnable {
    private boolean kill;
    private int puerto;
    private String token, ip;
    public static int PUERTO_DEFAULT = 6789;

    public UDPServer()
    {
        this.kill = false;
        this.puerto = UDPServer.PUERTO_DEFAULT;
        this.ip = "";
    }

    public UDPServer(int puerto)
    {
        this.kill = false;
        this.puerto = puerto;
        this.ip = "";
    }

    public void setInfo(String ip)
    {
        this.ip = ip;
    }

    public void kill() {
        this.kill = true;
    }

    public String getToken()
    {
        return this.token;
    }

    public int getPuerto() { return this.puerto; }

    @Override
    public void run()
    {
        try
        {
            System.out.println("Servidor inicializado en " + ip + ":" + puerto);
            DatagramSocket aSocket = new DatagramSocket(puerto);
            byte[] buffer = new byte[1000];
            while (!kill)
            {
                // Datagrama vacío
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                // Se queda bloqueado hasta encontrar un mensaje entrante.
                aSocket.receive(request);

                byte[] data = request.getData();

                ByteArrayInputStream in = new ByteArrayInputStream(data);
                ObjectInputStream is = new ObjectInputStream(in);
                Peticion p;
                byte[] response = null;
                try
                {
                    p = (Peticion) is.readObject();
                    if(p.getTipo() == Peticion.VERIFICAR_DISPONIBILIDAD)
                    {
                        String val = (p.getToken().equals("")) ? "false" : "true";
                        // Hacer lo que ya se hacía
                        response = val.getBytes();
                    } else if(p.getTipo() == Peticion.ENVIAR_TOKEN)
                    {
                        // Proceso recibe Token
                        token = p.getToken();
                    }
                    else response = new byte[1000];
                } catch(Exception ex) { response = new byte[1000]; }

                //token = request.getData().toString();

                // String resp = "Se recibió token " + token + " desde " 
                // //     + request.getAddress() + ":" + request.getPort();
                // String resp = "true";
                // byte[] bresp = resp.getBytes();

                // Datagrama proveniente de request.
                // Se construye la respuesta.
                DatagramPacket reply = new DatagramPacket(
                    response, response.length,
                    request.getAddress(), request.getPort());

                // Se envía la respuesta.
                aSocket.send(reply);
            }
        }
        catch (SocketException e) {System.out.println("Socket: " + e.getMessage()); }
        catch (IOException e) {System.out.println("IO: " + e.getMessage());}
    }

}
