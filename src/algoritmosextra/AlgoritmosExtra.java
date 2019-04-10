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

import Model.Proceso;

/**
 *
 * @author Samuel
 */
public class AlgoritmosExtra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Proceso coordinador = new Proceso("192.168.100.5", 102, 0, "Coordinador", true);
        coordinador.serve();

        Proceso p1 = new Proceso("192.168.100.5", 103, 1, "P1", coordinador.getIp(), coordinador.getPuerto());
        p1.hacerPeticionRecurso(coordinador, Color.GREEN);
    }
    
}
