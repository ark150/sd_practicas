package app.udp;

import java.net.*;
import java.io.*;

/**
 * UDPServer
 */
public class UDPServer {
    public static void main(String args[])
    {
        System.out.println("UDP Server");
        try
        {
            DatagramSocket aSocket = new DatagramSocket(6789);
            byte[] buffer = new byte[1000];
            while(true)
            {
                // Datagrama vacío
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                // Se queda bloqueado hasta encontrar un mensaje entrante.
                aSocket.receive(request);

                // Datagrama proveniente de request.
                // Se construye la respuesta.
                DatagramPacket reply = new DatagramPacket(
                    request.getData(), request.getLength(),
                    request.getAddress(), request.getPort());

                // Se envía la respuesta.
                aSocket.send(reply);
            }
        }
        catch (SocketException e) {System.out.println("Socket: " + e.getMessage()); }
        catch (IOException e) {System.out.println("IO: " + e.getMessage());}
    }    
}