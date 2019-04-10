package Model;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.net.DatagramSocket;
import java.net.InetAddress;

import UDP.UDPClient;
import UDP.UDPServer;

/**
 * Proceso
 * 
 * @author BaezCrdrm
 */
public class Proceso {
    private String ip, ipCoordinador, nombre;
    private int id, puerto, puertoCoordinador;
    private UDPServer udps;
    private UDPClient udpc;
    private Thread server;
    private boolean coordinador;

    /**
     * Crea un nuevo proceso que será utilizado en el algoritmo
     */
    public Proceso(String ip, int puerto, int id, String nombre) {
        initialize(ip, puerto, id, nombre, false);
    }

    public Proceso(String ip, int puerto, int id, String nombre, boolean coordinador) {
        initialize(ip, puerto, id, nombre, coordinador);
    }

    public Proceso(String ip, int puerto, int id, String nombre, String ipCoordinador, int puertoCoordinador) {
        initialize(ip, puerto, id, nombre, false);
        this.ipCoordinador = ipCoordinador;
        this.puertoCoordinador = puertoCoordinador;
        udpc = new UDPClient(ipCoordinador);
    }

    private void initialize(String ip, int puerto, int id, String nombre, boolean coordinador) {
        this.ip = ip;
        this.puerto = puerto;
        this.id = id;
        this.nombre = nombre;
        this.coordinador = coordinador;
    }

    public void serve() {
        if (this.coordinador) {
            this.udps = new UDPServer();
            this.server = new Thread(this.udps);
            this.server.start();
        }
    }

    public void cambiaCoodinador(boolean coordinador) {
        this.coordinador = coordinador;

        // Detiene el servidor del proceso
        // si es que este proceso deja
        // de ser el coordinador.
        if (coordinador == false) {
            try {
                this.udps.kill();
                this.server.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception ex) {
            }
        } else
            serve();
    }

    /**
     * Verifica si el proceso tiene el rol de coordinador.
     * 
     * @return Verdadero si el proceso es coordinador
     */
    public boolean isCoordinador() {
        return this.coordinador;
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

    public String getNombre() {
        return this.nombre;
    }

    /**
     * Inicia una petición por el cliente
     * 
     * @param coordinador
     * @param uso
     */
    public void hacerPeticionRecurso(Proceso coordinador, Color uso) {
        if (coordinador.isCoordinador()) {
            Peticion pregunta = new Peticion(uso, Peticion.VERIFICAR_DISPONIBILIDAD);
            udpc.setPeticion(pregunta);
            Thread tr = new Thread(udpc);
            tr.start();
            try {
                tr.join();
                if(udpc.isDisponible())
                {
                    udpc.setPeticion(new Peticion(uso, Peticion.ASIGNA_RECURSO));
                    tr = new Thread(udpc);
                    tr.start();

                    try {
                        tr.join();
                    } catch (Exception e) {
                        
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else 
            System.out.println("El proceso " + coordinador.getClass().getName() + 
                " debe estar instanciado como coordinador");
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
