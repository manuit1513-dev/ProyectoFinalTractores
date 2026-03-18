package jcolonia.daw2025.AplicacionConsola;

import java.util.List;

/**
 * Clase encargada de cargar las altas que ya existan.
 */
public class VistaAltas{
	/**
	 * Carga del archivo ya creado los datos de los tractores que ya tengamos.
	 * @param flota los tractores ya dados de alta
	 */
	public static void cargarDesdeArchivo(FlotaTractores flota) {
	    try {
	        List<String> lineas = AccesoArchivo.leer("datos_tractores.txt");
	        for (String linea : lineas) {
	            String[] partes = linea.split(" # ");
	            if (partes.length == 4) {
	                Tractor t = new Tractor(partes[0], partes[1], 
	                                        Integer.parseInt(partes[2]), partes[3]);
	                flota.agregarTractor(t);
	            }
	        }
	        System.out.println("--> Datos previos cargados correctamente.");
	    } catch (Exception e) {
	        System.out.println("--> Iniciando catálogo vacío.");
	    }
	}
}
