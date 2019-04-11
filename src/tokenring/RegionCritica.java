package tokenring;

import static java.lang.Thread.sleep;

import java.awt.Color;
import Model.Proceso;

/**
 * RegionCritica
 */
public class RegionCritica extends Proceso
{
    private Recurso recurso;
    private boolean change;
    private boolean kill;
    private int segundos;

    /**
     * Inicializa una región crítica.
     * Se establece un mecanismo que permite la 
     * simulación de la espera de un proceso.
     */
    public RegionCritica() {
        super(getMachineIp(), 102, 0, "RegionCritica");
        initialize();
        segundos = 30;
    }

    /**
     * Inicializa una región crítica con un tiempo de espera establecido.
     * Permite la simulación de la espera de un proceso.
     * @param espera Segundos que el proceso simulará la espera de su uso.
     */
    public RegionCritica(int espera) {
        super(getMachineIp(), 102, 0, "RegionCritica");
        initialize();
        segundos = espera;
    }

    private void initialize() {
        recurso = new Recurso();
        change = false;
        this.kill = false;
    }

    /**
     * Hace uso del recurso disponible
     * @param color
     */
    public void asignaRecurso(Color color)
    {
        Thread tr = new Thread(new Runnable() {
            @Override
            public void run()
            {
                change = true;
                System.out.println("Usando recursos");
                try {
                    recurso.accesoRecurso(color);
                    sleep(segundos * 1000);
                    change = false;
                    recurso.accesoRecurso(Recurso.COLOR_ORIGINAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        tr.start();
    }

    public boolean isInUse()
    {
        return this.change;
    }

    public void kill()
    {
        this.kill = true;
    }
}