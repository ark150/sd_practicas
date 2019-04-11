package tokenring;

import java.util.ArrayList;
import java.util.List;

import Model.Proceso;

/**
 * Anillo
 */
public class Anillo {

    private List<Proceso> procesos;

    public Anillo(List<Proceso> procesosDefinidos)
    {
        this.procesos = new ArrayList<Proceso>();
        for (int i = 0; i < procesosDefinidos.size(); i++)
        {
            Proceso vecino;
            try {
                vecino = procesosDefinidos.get(i + 1);
            } catch (Exception e) {
                vecino = procesosDefinidos.get(0);
            }
            
            this.procesos.add(new Proceso(procesosDefinidos.get(i), vecino));
        }
    }
}