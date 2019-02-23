# UDP
Este programa se encuentra en las [diapositiva](http://www.lania.mx/lms/maestrias/pluginfile.php/20230/mod_resource/content/2/Unidad%20III%20-%20Comunicación%20interprocesos.pdf) número 15.

UDP cuenta con un envío **sin bloqueo** y una recepción con **bloqueo**.

## Java Client
```java
import java.net.*;
import java.io.*;

public class UDPClient
{
    public static void main(String args[])
    { // args give message contents and server hostname 
        try { 
            DatagramSocket aSocket = new DatagramSocket();
            byte [] m = args[0].getBytes();
            InetAddress aHost = InetAddress.getByName(args[1]);
            int serverPort = 6789;
            DatagramPacket request = new DatagramPacket(m,  args[0].length(), aHost, serverPort);
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
```

## Java Server
```java
import java.net.*;
import java.io.*;
public class UDPServer
{
    public static void main(String args[])
    {
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
```

# TCP
## Client
```java
import java.net.*;

import java.io.*;

public class TCPClient
{
    public static void main (String args[])
    {
        // arguments supply message and hostname of destination
        Socket s = null;
        try
        {
            int serverPort = 7896;
            s = new Socket(args[1], serverPort);
            DataInputStream in = new DataInputStream( s.getInputStream());
            DataOutputStream out = new DataOutputStream( s.getOutputStream());
            out.writeUTF(args[0]);
            // UTF is a string encoding see Sn 4.3
            String data = in.readUTF();
            System.out.println("Received: "+ data) ;
        }catch (UnknownHostException e){ System.out.println("Sock:"+e.getMessage()); }
        catch (EOFException e){System.out.println("EOF:"+e.getMessage()); }
        catch (IOException e){System.out.println("IO:"+e.getMessage());}
        finally 
        {
            if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}
        }
    }
}
```

## Server
```java
import java.net.*;
import java.io.*;

public class TCPServer 
{
    public static void main (String args[]) 
    {
        try
        {
            int serverPort = 7896;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while(true) 
            {
                Socket clientSocket = listenSocket.accept();
                Connection c = new Connection(clientSocket);
            }
        } catch(IOException e) {System.out.println("Listen :"+e.getMessage());}
    }
}

class Connection extends Thread
{
    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    public Connection (Socket aClientSocket)
    {
        try
        {
            clientSocket = aClientSocket;
        in = new DataInputStream( clientSocket.getInputStream());
        out =new DataOutputStream( clientSocket.getOutputStream()); this.start();
        }
        catch(IOException e) {System.out.println("Connection:"+e.getMessage());}
    }

    public void run() 
    {
        try
        { 
            // an echo server
            String data = in.readUTF();
            out.writeUTF(data);
        }
        catch(EOFException e) {System.out.println("EOF:"+e.getMessage()); }
        catch(IOException e) {System.out.println("IO:"+e.getMessage());}
        finally
        {
            try {
                clientSocket.close();
            } catch (IOException e){/*close failed*/}
        }
    }
}
```