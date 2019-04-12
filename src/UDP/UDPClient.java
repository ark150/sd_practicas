package UDP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Peticion;

/**
 * UDPClient
 */
public class UDPClient implements Runnable
{
    private String ip;
    private int puerto;
    private Peticion peticion;
    private boolean response;

    /**
     * Constructor
     * @param ip Dirección IP del servidor al cual se conectará
     */
    public UDPClient(String ip) 
    {
        initialize(ip, UDPServer.PUERTO_DEFAULT);
    }

    public UDPClient(String ip, int puerto) 
    {
        initialize(ip, puerto);
    }

    public UDPClient(String ip, int puerto, Peticion p) {
        initialize(ip, puerto);
        this.peticion = p;
    }

    private void initialize(String ip, int puerto) {
        this.ip = ip;
        this.puerto = puerto;
    }

    public void setPeticion(Peticion peticion) {
        this.peticion = peticion;
    }

    public Peticion getPeticion() { return this.peticion; }

    public boolean isDisponible() { return this.response; }

    @Override
    public void run() 
    {
        System.out.println("UDP Client");
        // args give message contents and server hostname 
        try 
        { 
            // DatagramSocket aSocket = new DatagramSocket();
            // String message = peticion.getToken();
            // byte[] m = message.getBytes();
            // InetAddress aHost = InetAddress.getByName(ip);
            // int serverPort = puerto;
            // DatagramPacket request = new DatagramPacket(m,  message.length(), aHost, serverPort);
            // aSocket.send(request);
            // byte[] buffer = new byte[1000];
            // DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            // aSocket.receive(reply);
            // String a = new String(reply.getData()).trim();
            // System.out.println("Reply: " + a);
            // if(!a.equals("default"))
            // {
            //     this.response = true;
            // } else this.response = false;
            // aSocket.close(); 



            DatagramSocket aSocket = new DatagramSocket();
            ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(outputstream);

            os.writeObject(this.peticion);

            byte[] data = outputstream.toByteArray();
            InetAddress aHost = InetAddress.getByName(this.ip);
            
            DatagramPacket sendPacket = new DatagramPacket(data, data.length, aHost, this.puerto);
            aSocket.send(sendPacket);

            // Obtiene respuesta
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            // String interpretacion;
            // if (reply.getData()[0] == 0)
            // {
            //     response = true;
            //     interpretacion = "Ok";
            // }
            // else
            // {
            //     response = false;
            //     interpretacion = "Ocupado";
            // }
            // System.out.println("Reply: " + interpretacion);

            String a = new String(reply.getData()).trim();
            System.out.println("Reply: " + a);
            if(!a.equals("false"))
            {
                this.response = true;
            } else this.response = false;

            aSocket.close();
        }
        catch (SocketException e){System.out.println("Socket: " + e.getMessage()); }
        catch (IOException e){System.out.println("IO: " + e.getMessage());} 
    }
}