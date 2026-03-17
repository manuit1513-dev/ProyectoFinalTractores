package jcolonia.daw2025.AplicacionConsola;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestión de la colección de tractores.
 * @author manueld.garpra
 * @version 1.0
 */
public class FlotaTractores {
    private List<Tractor> lista;

    public FlotaTractores() {
        this.lista = new ArrayList<>();
    }

    public void agregarTractor(Tractor t) {
        lista.add(t);
    }

    public List<Tractor> getTodos() {
        return new ArrayList<>(lista);
    }

    /**
     * Genera la lista de strings para el proceso de exportación.
     */
    public List<String> toListExportar() {
        List<String> lineas = new ArrayList<>();
        for (Tractor t : lista) {
            lineas.add(t.toString());
        }
        return lineas;
    }
}

