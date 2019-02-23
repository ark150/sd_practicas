package app.tcp;

import java.net.*;
import java.io.*;

/**
 * TCPClient
 */
public class TCPClient {
    public static void main (String args[])
    {
        // arguments supply message and hostname of destination
        Socket s = null;
        System.out.println("TCP Client");
        try
        {
            int serverPort = 7896;
            s = new Socket("192.168.16.113", serverPort);
            DataInputStream in = new DataInputStream( s.getInputStream());
            DataOutputStream out = new DataOutputStream( s.getOutputStream());

            String message = "Hola TCP";
            out.writeUTF(message);
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