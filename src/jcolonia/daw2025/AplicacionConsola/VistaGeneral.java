package jcolonia.daw2025.AplicacionConsola;
import java.util.List;
import java.util.Scanner;

/**
 * Interfaz de usuario por consola para el catálogo de tractores.
 * @author manueld.garpra
 * @version 1.0
 */
public class VistaGeneral {
    private ControlCatalogo control;
    private Scanner teclado;

    public VistaGeneral(ControlCatalogo control) {
        this.control = control;
        this.teclado = new Scanner(System.in);
        
    }

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

    private void altaTractor() {
        try {
            System.out.println("\n--- NUEVO TRACTOR ---");
            System.out.print("Marca: "); String marca = teclado.nextLine();
            System.out.print("Modelo: "); String modelo = teclado.nextLine();
            
            System.out.print("Potencia (CV): "); 
            // Usamos .trim() para limpiar espacios accidentales
            int cv = Integer.parseInt(teclado.nextLine().trim());
            
            System.out.print("Tracción: "); String traccion = teclado.nextLine();
            
            control.añadirTractor(marca, modelo, cv, traccion);
            System.out.println("Tractor guardado.");
        } catch (NumberFormatException e) {
            System.out.println("Error en los datos: La potencia debe ser un número.");
        }
    }


    private void listarTractores() {
        System.out.println("\n--- LISTADO DE FLOTA ---");
        if (control.obtenerLista().isEmpty()) {
            System.out.println("No hay tractores registrados.");
        } else {
            control.obtenerLista().forEach(System.out::println);
        }
    }

    private void exportarDatos() {
        try {
            control.ejecutarExportacion();
            System.out.println("Datos exportados con éxito a 'datos_tractores.txt'");
        } catch (Exception e) {
            System.out.println("Error al exportar: " + e.getMessage());
        }
    }
}
