/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosextra;

import static java.lang.Thread.currentThread;

import java.awt.Color;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Samuel
 */
public class AlgoritmosExtra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // TODO code application logic here
        RegionCritica rc = new RegionCritica();
        // ExecutorService service = Executors.newSingleThreadExecutor();
        // Future<Boolean> f1 = service.submit(rc);
        // System.out.println(f1.get());
        System.out.println(rc.isInUse());

        // rc.serve();
        System.out.println("Cambia a verde");
        rc.asignaRecurso(Color.GREEN);
        System.out.println(rc.isInUse());
        if (!rc.isInUse()) {
            rc.asignaRecurso(Color.RED);
            System.out.println("Está libre");
        } else {
            rc.asignaRecurso(Color.PINK);
            System.out.println("Está ocupado");
        }

        try {
            currentThread().sleep(5500);
            if(!rc.isInUse())
            {
                System.out.println("Se liberó");
                rc.asignaRecurso(Color.YELLOW);
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Ocurrio un error");
            System.out.println(e.getMessage());
        }

        // service.shutdown();
    }
    
}
