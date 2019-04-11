package Model;

import java.awt.Color;
import java.io.Serializable;

/**
 * Peticion
 */
public class Peticion implements Serializable {
    private Color peticion;
    private int tipo;
    private Proceso padre;
    public static int VERIFICAR_DISPONIBILIDAD = -1;
    public static int ASIGNA_RECURSO = 1;

    public Peticion(Color peticion, int tipo, Proceso proceso)
    {
        this.peticion = peticion;
        this.tipo = tipo;
        this.padre = proceso;
    }

    public Color getPeticion() { return this.peticion; }
    public int getTipo() { return this.tipo; }
    public Proceso getProcesoPadre() { return this.padre; }
}