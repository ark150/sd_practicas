package Model;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.Random;

import UDP.UDPClient;
import UDP.UDPServer;
import java.awt.Color;

/**
 * Proceso
 */
public class Proceso {
    private String ip, nombre;
    private int id, puerto;
    private Proceso vecino;
    private UDPServer udps;
    private UDPClient udpc;
    private Thread server, tokenRunner;
    private boolean generador;
    private String token;
    private static int espera = 5;
    private Color color;

    /**
     * Constructor de definición de proceso
     * 
     * @param ip     Dirección IP del proceso
     * @param puerto Puerto del prceso
     * @param id     Identificador dado al proceso
     * @param nombre Nombre no único por el cual se le pueda llamar al proceso
     */
    public Proceso(String ip, int puerto, int id, String nombre) {
        initialize(ip, puerto, id, nombre, false);
    }

    /**
     * Constructor de definición de proceso
     * 
     * @param ip        Dirección IP del proceso
     * @param puerto    Puerto del prceso
     * @param id        Identificador dado al proceso
     * @param nombre    Nombre no único por el cual se le pueda llamar al proceso
     * @param generador Ve si el proceso es generador de token
     */
    public Proceso(String ip, int puerto, int id, String nombre, boolean generador) {
        initialize(ip, puerto, id, nombre, generador);
        if (generador)
            generarToken();
    }

    private void initialize(String ip, int puerto, int id, String nombre, boolean generador) {
        this.ip = ip;
        this.puerto = puerto;
        this.id = id;
        this.nombre = nombre;
        this.generador = generador;
        this.token = "default";
    }

    /**
     * Instancia un proceso a partir de un proceso definido.
     * 
     * @param proceso
     */
    public Proceso(Proceso proceso, Proceso vecino) {
        try {
            this.id = proceso.getId();
            this.ip = proceso.getIp();
            this.puerto = proceso.getPuerto();
            this.vecino = vecino;
            this.token = proceso.getToken();

            this.udps = new UDPServer();
            // this.server = new Thread(this.udps);
            // this.server.start();
        } catch (NullPointerException npe) {
            System.out.println("Ocurró un error al crear el proceso");
            System.out.println("Agrega los valores correctos al parámetro");
            throw new NullPointerException();
        }

        serve();
        this.tokenRunner = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean val = false;
                do {
                    Peticion p = new Peticion(vecino, token);
                    val = generaPeticion(p);
                    if (val)
                        System.out.println("Permitido");
                    else
                        System.out.println("No");

                    try {
                        Thread.currentThread().sleep(espera * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } while(!val);
                
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        this.tokenRunner.start();
    }

    private void serve() {
        // Servidor
        udps = new UDPServer(this.puerto);
        udps.setInfo(this.ip);
        server = new Thread(udps);
        server.start();

        // Cliente
        udpc = new UDPClient(vecino.getIp(), vecino.getPuerto());
    }

    /**
     * @return the address
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
    public int getId()
    {
        return id;
    }

    public String getToken() { return this.token; }
    public void setToken(String t) { this.token = t; }

    public boolean isGenerador() { return this.generador; }

    /**
     * Genera un nuevo token
     */
    public void generarToken()
    {
        byte[] array = new byte[3];
        new Random().nextBytes(array);
        String g = new String(array, Charset.forName("UTF-8"));
        this.token = "hola";
    }

    public boolean generaPeticion(Peticion peticion)
    {
        udpc.setPeticion(peticion);
        Thread cliente = new Thread(udpc);
        cliente.start();
        try {
            cliente.join();
            return udpc.isDisponible();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
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