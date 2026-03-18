package jcolonia.daw2025.AplicacionConsola;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class FlotaTractoresTest {

    private FlotaTractores flota;

    @BeforeEach
    void setUp() {
        flota = new FlotaTractores();
    }

    @Test
    @DisplayName("Verifica que la flota se inicia vacía")
    void testConstructorYVacio() {
        assertNotNull(flota.getTodos(), "La lista no debe ser null");
        assertTrue(flota.getTodos().isEmpty(), "La lista debe iniciar vacía");
    }

    @Test
    @DisplayName("Prueba agregar un tractor y recuperar la lista")
    void testAgregarYGetTodos() {
        Tractor t = new Tractor("John Deere", "6R", 150, "4WD");
        flota.agregarTractor(t);
        
        List<Tractor> resultado = flota.getTodos();
        
        assertEquals(1, resultado.size(), "Debe haber un tractor en la lista");
        assertEquals(t, resultado.get(0), "El tractor recuperado debe ser el mismo");
        
        // Verificación de encapsulamiento (que getTodos devuelve una copia)
        resultado.clear(); 
        assertEquals(1, flota.getTodos().size(), "La lista interna no debe verse afectada por cambios externos");
    }

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
