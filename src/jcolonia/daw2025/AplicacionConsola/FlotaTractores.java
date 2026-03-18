package jcolonia.daw2025.AplicacionConsola;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestión de la colección de tractores.
 * @author manueld.garpra
 * @version 1.0
 */
public class FlotaTractores {
    /**
     * Lista privada de los tractores.
     */
    private List<Tractor> lista;

    /**
     * Crea una instancia e inicializa la listade tractores.
     */
    public FlotaTractores() {
        this.lista = new ArrayList<>();
    }
    
    /**
     * Añade un objeto tractor a lista actual
     * @param t el objeto {@link Tractor} que se quiere incorporar
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
    
    /**
     * Procesa las líneas de texto recibidas del archivo para reconstruir
     * los objetos Tractor, usando el carácter '#' como delimitador.
     * 
     * @param datos La lista de cadenas de texto leídas del archivo.
     */
    public void cargarDesdeLista(List<String> datos) {
        for (String linea : datos) {
            String[] partes = linea.split("#");
            
            if (partes.length == 4) {
                try {
                    String marca = partes[0].trim();
                    String modelo = partes[1].trim();
                    int cv = Integer.parseInt(partes[2].trim());
                    String traccion = partes[3].trim();
                    
                    this.agregarTractor(new Tractor(marca, modelo, cv, traccion));
                } catch (NumberFormatException e) {
                    System.err.println("Error: No se puede convertir la potencia en la línea: " + linea);
                }
            }
        }
    }

}

