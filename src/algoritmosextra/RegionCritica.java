package algoritmosextra;

import java.awt.Color;

import Model.Proceso;
import UDP.UDPServer;

/**
 * RegionCritica
 */
public class RegionCritica extends Proceso implements Runnable {
    private Recurso recurso;
    private boolean change;
    private UDPServer udps;
    private Thread server;

    public RegionCritica() {
        super(getMachineIp(), 102, 0, "RegionCritica");
        recurso = new Recurso();
        change = false;
        this.udps = new UDPServer();
        this.server = new Thread(udps);
        this.server.start();

    }

    public void asignaRecurso(Color color)
    {
        recurso.accesoRecurso(color);
        this.change = true;
    }

    public boolean isInUse()
    {
        return this.change;
    }

    @Override
    public void run() {
        while(true)
        {
            if(this.change == true)
            {
                // Simula el uso de recursos
                System.out.println("Usando recursos");
                int segundos = 30;
                try {
                    Thread.sleep(segundos * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                recurso.setBackground(Color.BLACK);
                this.change = false;
            }
        }
    }
    
}