package jcolonia.daw2025.AplicacionConsola;

import java.util.List;

public class ControlCatalogo {
	 private FlotaTractores flota;
	    private VistaGeneral vista;

	    public ControlCatalogo() {
	        this.flota = new FlotaTractores();
	        this.vista = new VistaGeneral(this);
	    }

	    public void iniciar() {
	        vista.menuPrincipal();
	    }

	    public void añadirTractor(String marca, String modelo, int cv, String traccion) {
	        flota.agregarTractor(new Tractor(marca, modelo, cv, traccion));
	    }

	    public List<Tractor> obtenerLista() {
	        return flota.getTodos();
	    }

	    public void ejecutarExportacion() throws Exception {
	        AccesoArchivo.escribir("datos_tractores.txt", flota.toListExportar());
	    }
	}
