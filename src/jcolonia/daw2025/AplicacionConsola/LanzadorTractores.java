package jcolonia.daw2025.AplicacionConsola;


/**
* Clase principal que arranca la aplicación de gestión de tractores.
* @author manueld.garpra
* @version 1.1
*/
public class LanzadorTractores {    
    /**
     * Punto de entrada del programa.
     * Nos muetra un menú con opciones que podemos hacer como
     * dar de alta, mostrar lista, esportar el archivo y salir.
     * 
     * @param args opciones de ejecución.
     */
    public static void main(String[] args) {
        ControlCatalogo miControl = new ControlCatalogo();
        
        miControl.iniciar();
    }
}
