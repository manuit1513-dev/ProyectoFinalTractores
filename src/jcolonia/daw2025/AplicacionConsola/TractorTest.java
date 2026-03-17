package jcolonia.daw2025.AplicacionConsola;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TractorTest {
    @Test
    void testCrearTractor() {
        Tractor t = new Tractor("John Deere", "6R", 150, "AutoPower");
        assertEquals("John Deere", t.getMarca());
        assertEquals(150, t.getPotencia());
    }
}
