package jcolonia.daw2025.AplicacionConsola;
import java.util.Scanner;

/**
 * Interfaz de usuario por consola para el catálogo de tractores.
 * @author manueld.garpra
 * @version 1.0
 */
public class VistaGeneral {
    private ControlCatalogo control;
    private Scanner teclado;

    /**
     * Construye una nueva vista y la vincula con su controlador 
     * Inicializa el Scanner
     * @param control
     */
    public VistaGeneral(ControlCatalogo control) {
        this.control = control;
        this.teclado = new Scanner(System.in);
        
    }

    /**
     * Muestra el menú principal con un bucle
     * no finaliza hasta que se escoga la opción de salir.
     */
    public void menuPrincipal() {
        int opcion = 0;
        do {
            System.out.println("\n--- CATÁLOGO DE TRACTORES ---");
            System.out.println("1. Alta de Tractor");
            System.out.println("2. Listado de Tractores");
            System.out.println("3. Exportar a TXT (Formato #)");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            try {
                opcion = Integer.parseInt(teclado.nextLine());
                switch (opcion) {
                    case 1 -> altaTractor();
                    case 2 -> listarTractores();
                    case 3 -> exportarDatos();
                    case 4 -> System.out.println("¡Adiós!");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Introduce un número válido.");
            }
        } while (opcion != 4);
    }

    /**
     * Solicita al usuario los datos de un nuevo tractor mediante consola.
     * Recoge la marca, modelo, potencia (CV) y tipo de tracción.
     * Valida que la potencia sea un número entero válido antes de enviarlo
     * 
     * @throws NumberFormatException Si el usuario introduce texto en el campo de potencia.
     */
    private void altaTractor() {
        try {
            System.out.println("\n--- NUEVO TRACTOR ---");
            System.out.print("Marca: "); String marca = teclado.nextLine();
            System.out.print("Modelo: "); String modelo = teclado.nextLine();
            
            System.out.print("Potencia (CV): "); 
            int cv = Integer.parseInt(teclado.nextLine().trim());
            
            System.out.print("Tracción: "); String traccion = teclado.nextLine();
            
            control.añadirTractor(marca, modelo, cv, traccion);
            System.out.println("Tractor guardado.");
        } catch (NumberFormatException e) {
            System.out.println("Error en los datos: La potencia debe ser un número.");
        }
    }

    /**
     * Muestra por pantalla la lista completa de tractores registrados en la flota.
     * Si la lista está vacía, informa al usuario con un mensaje
     * Utiliza el método {@code toString()} de la clase {@link Tractor} para la visualización.
     */
    private void listarTractores() {
        System.out.println("\n--- LISTADO DE FLOTA ---");
        if (control.obtenerLista().isEmpty()) {
            System.out.println("No hay tractores registrados.");
        } else {
            control.obtenerLista().forEach(System.out::println);
        }
    }

    /**
     * Inicia el proceso de llevar los datos a un archivo de texto
     * Muestra un mensaje de confirmación o de error según el resultado de la operación.
     */
    private void exportarDatos() {
        try {
            control.ejecutarExportacion();
            System.out.println("Datos exportados con éxito a 'datos_tractores.txt'");
        } catch (Exception e) {
            System.out.println("Error al exportar: " + e.getMessage());
        }
    }
}
