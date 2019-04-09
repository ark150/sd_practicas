package Model;

import java.util.ArrayList;
import java.util.List;
import java.net.DatagramSocket;
import java.net.InetAddress;

import UDP.UDPServer;

/**
 * Proceso
 * 
 * @author BaezCrdrm
 */
public class Proceso {
    private String ip, nombre;
    private int id, puerto;
    private UDPServer udps;
    private Thread server;

    /**
     * Crea un nuevo proceso que será utilizado en el algoritmo
     */
    public Proceso(String ip, int puerto, int id, String nombre) {
        this.ip = ip;
        this.puerto = puerto;
        this.id = id;
        this.nombre = nombre;

        this.udps = new UDPServer();
        this.server = new Thread(this.udps);
    }

    public void serve()
    {
        this.server.start();
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @return the puerto
     */
    public int getPuerto() {
        return puerto;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Verifica si existen procesos en espera y evalúa si es que pueden ser
     * entregados
     */
    private void verificarMensajesEnEspera() {
        
    }

    /**
     * Enviar un mensaje a un proceso dado
     * 
     * @param msg          Mensaje que se envía
     * @param destinatario Proceso al que se le envía el mensaje
     */
    public void enviarMensaje() 
    {
        
    }

    public static String getMachineIp()
    {
        String ip = "";
        try(final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            ip = socket.getLocalAddress().getHostAddress();
        } catch(Exception ex) {}
        
        return ip;
    }
}
