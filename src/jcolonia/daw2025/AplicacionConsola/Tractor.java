package jcolonia.daw2025.AplicacionConsola;

/**
 * Representa un Tractor con sus atributos principales.
 * @author manueld.garpra
 * @version 1.1
 */
public class Tractor {
    private String marca;
    private String modelo;
    private int potencia;
    private String traccion;

    public Tractor(String marca, String modelo, int potencia, String traccion) {
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.traccion = traccion;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getPotencia() { return potencia; }
    public String getTraccion() { return traccion; }

    /**
     * Devuelve el objeto formateado para exportar según el esquema de la pizarra.
     * Ejemplo: JohnDeere # 6120M # 120 # 4WD
     */
    public String toLineaExportar() {
        return String.format("%s # %s # %d # %s", marca, modelo, potencia, traccion);
    }

    /**
     * Método de factoría: Crea un Tractor a partir de una línea de texto.
     * @param linea La cadena de texto con los datos separados por '#'
     * @return Un nuevo objeto Tractor
     */
    public static Tractor of(String linea) {
        String[] trozos = linea.split("#");
        
        String marca = trozos[0].trim();
        String modelo = trozos[1].trim();
        int potencia = Integer.parseInt(trozos[2].trim());
        String traccion = trozos[3].trim();
        
        return new Tractor(marca, modelo, potencia, traccion);
    }

    @Override
    public String toString() {
        return toLineaExportar();
    }
}


