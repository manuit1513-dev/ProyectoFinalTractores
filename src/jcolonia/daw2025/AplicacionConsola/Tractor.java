package jcolonia.daw2025.AplicacionConsola;

/**
 * Representa un Tractor con sus atributos principales.
 * @author manueld.garpra
 * @version 1.0
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
     * Devuelve el objeto formateado para exportar.
     * Ejemplo: JohnDeere # 6120M # 120 # 4WD
     */
    @Override
    public String toString() {
        return String.format("%s # %s # %d # %s", marca, modelo, potencia, traccion);
    }
}

