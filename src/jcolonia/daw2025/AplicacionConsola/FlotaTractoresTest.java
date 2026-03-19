package jcolonia.daw2025.AplicacionConsola;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * Pruebas unitarias para la clase FlotaTractor.
 * Verifica la gestión de la flota 
 */
class FlotaTractoresTest {

    /**
     * La flota de tractores
     */
    private FlotaTractores flota;

    /**
     * Inicializa una flota nueva antes de cada método del test.
     */
    @BeforeEach
    void setUp() {
        flota = new FlotaTractores();
    }

    /**
     * Verifica que el constructor se inicia bien la lista y sin elementos
     */
    @Test
    @DisplayName("Verifica que la flota se inicia vacía")
    void testConstructorYVacio() {
        assertNotNull(flota.getTodos(), "La lista no debe ser null");
        assertTrue(flota.getTodos().isEmpty(), "La lista debe iniciar vacía");
    }

    /**
     * Prueba que el agregar un nuevo tractor no afecta a la lista ya existente.
     */
    @Test
    @DisplayName("Prueba agregar un tractor y recuperar la lista")
    void testAgregarYGetTodos() {
        Tractor t = new Tractor("John Deere", "6R", 150, "4WD");
        flota.agregarTractor(t);
        
        List<Tractor> resultado = flota.getTodos();
        
        assertEquals(1, resultado.size(), "Debe haber un tractor en la lista");
        assertEquals(t, resultado.get(0), "El tractor recuperado debe ser el mismo");
        
        resultado.clear(); 
        assertEquals(1, flota.getTodos().size(), "La lista interna no debe verse afectada por cambios externos");
    }

    /**
     * Verifica que la flota se convierte en una lista de cadenas correctas
     * para exportar y coincide con el formato que se pide.
     */
    @Test
    @DisplayName("Prueba la generación de lista para exportar")
    void testToListExportar() {
        Tractor t1 = new Tractor("Fendt", "724", 240, "Vario");
        flota.agregarTractor(t1);
        
        List<String> exportacion = flota.toListExportar();
        
        assertEquals(1, exportacion.size(), "Debe haber una línea para exportar");
        assertEquals(t1.toString(), exportacion.get(0), "El String debe coincidir con el toString del tractor");
    }
}
