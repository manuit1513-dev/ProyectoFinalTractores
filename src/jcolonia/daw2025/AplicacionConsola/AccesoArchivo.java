package jcolonia.daw2025.AplicacionConsola;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;

/**
 * Proporciona herramientas para la lectura y escritura de archivos de texto.
 * 
 * @author manueld.garpra
 * @version 1.0
 */
public class AccesoArchivo {
    
    /**
     * Escribe la lista de cadenas de texto en un archivo en la ruta especificada
     * @param ruta ruta del arhivo de destino
     * @param contenido lista de Strings
     * @throws IOException si ocurre un erro duirante la escritura
     */
    public static void escribir(String ruta, List<String> contenido) throws IOException {
        Files.write(Paths.get(ruta), contenido);
    }

    /**
     * Lee todas las lineas de archivo
     * @param ruta del archivo para leer
     * @return Lista de cadenas de texto con el contenido
     * @throws IOException si el arhivo no existe o no se puede leer
     */
    public static List<String> leer(String ruta) throws IOException {
        return Files.readAllLines(Paths.get(ruta));
    }
}
