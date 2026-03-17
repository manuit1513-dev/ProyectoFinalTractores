package jcolonia.daw2025.AplicacionConsola;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class AccesoArchivo {
    
    public static void escribir(String ruta, List<String> contenido) throws IOException {
        Files.write(Paths.get(ruta), contenido);
    }

    public static List<String> leer(String ruta) throws IOException {
        return Files.readAllLines(Paths.get(ruta));
    }
}
