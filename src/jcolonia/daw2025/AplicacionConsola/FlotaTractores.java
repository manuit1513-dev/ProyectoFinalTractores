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

    /**
     * Crea una instancia e inicializa la listade tractores.
     */
    public FlotaTractores() {
        this.lista = new ArrayList<>();
    }
    
    /**
     * Añade un objeto tractor a lista actual
     * @param t el objeto {@link tractor} que se quiere incorporar
     */
    public void agregarTractor(Tractor t) {
        lista.add(t);
    }

    /**
     * Recupero los datos de los tractores guardados
     * @return la lista de todos los tractores registrados
     */
    public List<Tractor> getTodos() {
        return new ArrayList<>(lista);
    }

    /**
     * Genera la lista de strings para el proceso de exportación.
     * @return lista de cadenas de texto para escribirlas en un archivo
     */
    public List<String> toListExportar() {
        List<String> lineas = new ArrayList<>();
        for (Tractor t : lista) {
            lineas.add(t.toString());
        }
        return lineas;
    }
}

