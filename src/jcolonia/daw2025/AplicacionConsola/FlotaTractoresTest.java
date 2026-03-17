package jcolonia.daw2025.AplicacionConsola;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlotaTractoresTest {
    private FlotaTractores flota;

    @BeforeEach
    void setUp() {
        flota = new FlotaTractores();
    }

    @Test
    void testAltaTractor() {
        Tractor t = new Tractor("Fendt", "724", 240, "Vario");
        flota.agregarTractor(t);
        assertEquals(1, flota.getTodos().size());
    }
}
