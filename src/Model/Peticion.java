package Model;

import java.awt.Color;
import java.io.Serializable;

/**
 * Peticion
 */
public class Peticion implements Serializable
{
    private Color peticion;
    private int tipo;
    private Proceso padre;
    private String token;
    public static int VERIFICAR_DISPONIBILIDAD = -1;
    public static int ASIGNA_RECURSO = 1;
    public static int ENVIAR_TOKEN = 2;

    /**
     * Crea una nueva petición
     * @param peticion
     * @param tipo
     * @param proceso Proceso al cual se conecta
     */
    public Peticion(Color peticion, int tipo, Proceso proceso)
    {
        this.peticion = peticion;
        this.tipo = tipo;
        this.padre = proceso;
    }

    public Peticion(Proceso proceso, String token)
    {
        this.padre = proceso;
        this.token = token;
    }

    public Peticion(Proceso proceso, String token, int tipo)
    {
        this.padre = proceso;
        this.token = token;
        this.tipo = tipo;
    }

    public Color getPeticion() { return this.peticion; }
    public int getTipo() { return this.tipo; }
    public Proceso getProcesoPadre() { return this.padre; }
    public String getToken() { return this.token; }
    public void setToken(String token) { this.token = token; } 
}