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
public class Proceso
{
    private String ip, nombre;
    private int id, puerto;
    private UDPServer udps;
    private Thread server;
    private boolean coordinador;

    /**
     * Crea un nuevo proceso que será utilizado en el algoritmo
     */
    public Proceso(String ip, int puerto, int id, String nombre)
    {
        initialize(ip, puerto, id, nombre, false);
    }

    public Proceso(String ip, int puerto, int id, String nombre, boolean coordinador)
    {
        initialize(ip, puerto, id, nombre, coordinador);
    }

    private void initialize(String ip, int puerto, int id, String nombre, boolean coordinador)
    {
		this.ip = ip;
        this.puerto = puerto;
        this.id = id;
        this.nombre = nombre;
        this.coordinador = coordinador;
	}

    public void serve()
    {
        if(this.coordinador)
        {
            this.udps = new UDPServer();
            this.server = new Thread(this.udps);
            this.server.start();
        }
    }

    public void setCoodinador(boolean coordinador)
    {
        this.coordinador = coordinador;

        // Detiene el servidor del proceso
        // si es que este proceso deja
        // de ser el coordinador.
        if(coordinador == false)
        {
            try {
                this.udps.kill();
                this.server.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception ex) { }
        } else serve();
    }

    /**
     * Verifica si el proceso tiene el rol
     * de coordinador. 
     * @return Verdadero si el proceso es coordinador
     */
    public boolean isCoordinador() { return this.coordinador; }

    /**
     * @return the ip
     */
    public String getIp() { return ip; }

    /**
     * @return the puerto
     */
    public int getPuerto() { return puerto; }

    /**
     * @return the id
     */
    public int getId() { return id; }

    public String getNombre() { return this.nombre; }

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
