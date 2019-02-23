package app.udp;

import java.net.*;
import java.io.*;

/**
 * UDPClient
 */
public class UDPClient {
    public static void main(String args[])
    { 
        System.out.println("UDP Client");
        // args give message contents and server hostname 
        try { 
            DatagramSocket aSocket = new DatagramSocket();
            // byte [] m = args[0].getBytes();
            String message = "Hola mundo";
            byte[] m = message.getBytes();
            // InetAddress aHost = InetAddress.getByName(args[1]);
            InetAddress aHost = InetAddress.getByName("192.168.16.113");
            int serverPort = 6789;
            DatagramPacket request = new DatagramPacket(m,  message.length(), aHost, serverPort);
            aSocket.send(request);
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            aSocket.receive(reply);
            System.out.println("Reply: " + new String(reply.getData()));
            aSocket.close(); 
        }
        catch (SocketException e){System.out.println("Socket: " + e.getMessage()); }
        catch (IOException e){System.out.println("IO: " + e.getMessage());}
    }    
}