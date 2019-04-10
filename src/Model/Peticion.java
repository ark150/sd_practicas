package Model;

import java.awt.Color;
import java.io.Serializable;

/**
 * Peticion
 */
public class Peticion implements Serializable {
    private Color peticion;
    private int tipo;
    public static int VERIFICAR_DISPONIBILIDAD = -1;
    public static int ASIGNA_RECURSO = 1;

    public Peticion(Color peticion, int tipo)
    {
        this.peticion = peticion;
        this.tipo = tipo;
    }

    public Color getPeticion() { return this.peticion; }
    public int getTipo() { return this.tipo; }
}