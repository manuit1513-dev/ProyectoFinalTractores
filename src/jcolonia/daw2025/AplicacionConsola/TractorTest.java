package jcolonia.daw2025.AplicacionConsola;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la clase Tractor.
 */
class TractorTest {

    @Test
    @DisplayName("Verificar que el constructor y los getters funcionan correctamente")
    void testConstructorYGetters() {
        Tractor t = new Tractor("JohnDeere", "6120M", 120, "4WD");
        
        assertAll("Propiedades del tractor",
            () -> assertEquals("JohnDeere", t.getMarca(), "La marca no coincide"),
            () -> assertEquals("6120M", t.getModelo(), "El modelo no coincide"),
            () -> assertEquals(120, t.getPotencia(), "La potencia no coincide"),
            () -> assertEquals("4WD", t.getTraccion(), "La tracción no coincide")
        );
    }

    @Test
    @DisplayName("Verificar el formato de exportación")
    void testToLineaExportar() {
        Tractor t = new Tractor("Fendt", "724 Vario", 240, "4WD");
        String esperado = "Fendt # 724 Vario # 240 # 4WD";
        assertEquals(esperado, t.toLineaExportar(), "El formato de exportación es incorrecto");
    }

    @Test
    @DisplayName("Verificar que toString() devuelve lo mismo que toLineaExportar()")
    void testToString() {
        Tractor t = new Tractor("New Holland", "T7", 200, "4WD");
        assertEquals(t.toLineaExportar(), t.toString(), "toString debe coincidir con toLineaExportar");
    }

    @Test
    @DisplayName("Verificar la creación de un objeto mediante el método factoría of()")
    void testMetodoFactoriaOf() {
        String lineaInput = " Massey Ferguson # 8S # 265 # 4WD ";
        Tractor t = Tractor.of(lineaInput);
        
        assertAll("Objeto creado desde cadena",
            () -> assertEquals("Massey Ferguson", t.getMarca(), "No limpia espacios o marca incorrecta"),
            () -> assertEquals("8S", t.getModelo(), "Modelo incorrecto"),
            () -> assertEquals(265, t.getPotencia(), "Potencia incorrecta"),
            () -> assertEquals("4WD", t.getTraccion(), "Tracción incorrecta")
        );
    }
}
