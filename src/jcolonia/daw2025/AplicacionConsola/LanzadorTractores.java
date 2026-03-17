package jcolonia.daw2025.AplicacionConsola;


/**
* Clase principal que arranca la aplicación de gestión de tractores.
* @author [Tu Nombre]
*/
public class LanzadorTractores {	
	public static void main(String[] args) {
	// 1. Creamos el conjunto de datos (Modelo)
	FlotaTractores miFlota = new FlotaTractores();
	        
	// 2. Creamos la interfaz (Vista) y le pasamos la flota
	VistaGeneral vista = new VistaGeneral(miFlota);
	        
	// 3. Arrancamos el menú
	vista.menuPrincipal();
	}
}
