/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenring;

import java.util.ArrayList;
import java.util.List;

import Model.Proceso;

/**
 *
 * @author Samuel
 */
public class TokenRing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hola mundo");
        /**
         * La región crítica se inicializa una sóla vez
         * Los demás dispositivos conocerán quién es la rc, pero
         * no la reinicializarán.
         * Cada dispositivo conoce quién es su vecino; cada
         * dispositivo tiene listas diferentes de procesos.
         * 
         * Cada proceso tiene un servidor y cliente que se comunica con su vecino
         */

        List<Proceso> nodos = new ArrayList<Proceso>();
        RegionCritica rc = new RegionCritica("192.168.100.5", 102, 0, "Region critica");

        nodos.add(new Proceso("192.168.100.5", 103, 1, "P1"));
        nodos.add(new Proceso("192.168.100.5", 104, 2, "P2"));
        nodos.add(new Proceso("192.168.100.5", 105, 3, "P3"));

        Anillo anillo = new Anillo(nodos);
    }
    
}
