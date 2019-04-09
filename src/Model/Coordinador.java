package Model;

/**
 * Coordinador
 */
public class Coordinador extends Proceso 
{
    public Coordinador()
    {
        super(getMachineIp(), 101, 1, "Coordinador");
    }
}