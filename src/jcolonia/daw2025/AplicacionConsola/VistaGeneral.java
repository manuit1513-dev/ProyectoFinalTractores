package jcolonia.daw2025.AplicacionConsola;
import java.util.List;
import java.util.Scanner;

/**
 * Interfaz de usuario por consola para el catálogo de tractores.
 * @author manueld.garpra
 * @version 1.0
 */
public class VistaGeneral {
    private FlotaTractores flota;
    private Scanner teclado;

    public VistaGeneral(FlotaTractores flota) {
        this.flota = flota;
        this.teclado = new Scanner(System.in);
        
        try {
            List<String> lineas = AccesoArchivo.leer("datos_tractores.txt");
            for (String linea : lineas) {
                String[] partes = linea.split(" # ");
                if (partes.length == 4) {
                    Tractor t = new Tractor(partes[0], partes[1], 
                                            Integer.parseInt(partes[2]), partes[3]);
                    this.flota.agregarTractor(t);
                }
            }
            System.out.println("--> Datos previos cargados correctamente.");
        } catch (Exception e) {
            System.out.println("--> Iniciando catálogo vacío (no se encontró archivo previo).");
        }
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
        System.out.println("\n--- NUEVO TRACTOR ---");
        System.out.print("Marca: "); String marca = teclado.nextLine();
        System.out.print("Modelo: "); String modelo = teclado.nextLine();
        System.out.print("Potencia (CV): "); int cv = Integer.parseInt(teclado.nextLine());
        System.out.print("Tracción (2WD/4WD): "); String traccion = teclado.nextLine();
        
        flota.agregarTractor(new Tractor(marca, modelo, cv, traccion));
        System.out.println("Tractor guardado correctamente.");
    }

    private void listarTractores() {
        System.out.println("\n--- LISTADO DE FLOTA ---");
        if (flota.getTodos().isEmpty()) {
            System.out.println("No hay tractores registrados.");
        } else {
            flota.getTodos().forEach(System.out::println);
        }
    }

    private void exportarDatos() {
        try {
            // El nombre del archivo debe ser el que pide el profesor o uno genérico
            AccesoArchivo.escribir("datos_tractores.txt", flota.toListExportar());
            System.out.println("Datos exportados con éxito a 'datos_tractores.txt'");
        } catch (Exception e) {
            System.out.println("Error al exportar: " + e.getMessage());
        }
    }
}
