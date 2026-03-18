package jcolonia.daw2025.AplicacionConsola;

import java.util.List;

/**
 * Gestiona la lógica y la conexión entre la vista y los datos 
 * del catálogo de tractores.
 * Es el controlador principal para coordinar las operaciones 
 * 
 * @author manueld.garpra
 * @version 1.0
 */
public class ControlCatalogo {
	 private FlotaTractores flota;
	    private VistaGeneral vista;

	    /**
	     * Inicializa un nuevo controlador con una flota vacía y su vista.
	     */
	    public ControlCatalogo() {
	        this.flota = new FlotaTractores();
	        
	        try {
	            List<String> lineas = AccesoArchivo.leer("datos_tractores.txt");
	            flota.cargarDesdeLista(lineas);
	            System.out.println("Datos cargados correctamente.");
	        } catch (Exception e) {
	            System.err.println("No se han podido cargar datos previos: " + e.getMessage());
	        }
	        
	        this.vista = new VistaGeneral(this);
	        
	        
	    }
	    
	    /**
	     * Inicia la ejecución de la aplicación, muestra el menú principal
	     */
	    public void iniciar() {
	        vista.menuPrincipal();
	    }
	    
	    /**
	     * Crea un nuevo objeto tractor y lo añade a la flota.
	     * 
	     * @param marca Nombre del fabricante
	     * @param modelo Modelo de la marca
	     * @param cv Potencia del motor
	     * @param traccion Tipo de tracción
	     */
	    public void añadirTractor(String marca, String modelo, int cv, String traccion) {
	        flota.agregarTractor(new Tractor(marca, modelo, cv, traccion));
	    }
	    
	    /**
	     * Obtiene la lista de los tractores ya almacenados
	     * @return La lista con todos los objetos {@link Tractor}r de la flota
	     */
	    public List<Tractor> obtenerLista() {
	        return flota.getTodos();
	    }

	    /**
	     * Copia todos los datos de la flota en un archivo de texto
	     * @throws Exception si hay un error en el proceso de escribir o al acceder al archivo
	     */
	    public void ejecutarExportacion() throws Exception {
	        AccesoArchivo.escribir("datos_tractores.txt", flota.toListExportar());
	    }
	    
	    /**
	     * Recupera los datos del archivo de texto y los carga en la flota actual.
	     * Lee el archivo "datos_tractores.txt" y solicita a la flota que 
	     * procese cada línea para reconstruir los objetos Tractor.
	     * 
	     * @throws Exception Si el archivo no existe o los datos tienen un formato incorrecto.
	     */
	    public void ejecutarImportacion() throws Exception {
	        List<String> lineas = AccesoArchivo.leer("datos_tractores.txt");
	        
	        flota.cargarDesdeLista(lineas);
	    }

	}
