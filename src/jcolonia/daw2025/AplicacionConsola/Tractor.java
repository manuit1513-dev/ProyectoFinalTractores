package jcolonia.daw2025.AplicacionConsola;

/**
 * Representa un Tractor con sus atributos principales.
 * @author manueld.garpra
 * @version 1.1
 */
public class Tractor {
    /**
     * La marac del tractor.
     */
    private String marca;
    /**
     * El modelo del tractor.
     */
    private String modelo;
    /**
     * La potencia del tractor en CV.
     */
    private int potencia;
    /**
     * Tipo de tracción del tractor que sea 2WD o 4WD.
     */
    private String traccion;

    /**
     * Construvtor con los parametros que debe llevar cada tractor.
     * @param marca La marca
     * @param modelo El modelo
     * @param potencia La potencia en CV
     * @param traccion La tracción 2WD o 4WD
     */
    public Tractor(String marca, String modelo, int potencia, String traccion) {
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.traccion = traccion;
    }

    /**
     * Devuleve el nombre del fabricante
     * @return La marca
     */
    public String getMarca() { return marca; }
    
    /**
     * Devuelve el modelo de la marca
     * @return El modelo del tractor
     */
    public String getModelo() { return modelo; }
    
    /**
     * Devuelve la potencia del motor en CV
     * @return Cantida de CV
     */
    public int getPotencia() { return potencia; }
    
    /**
     * Devuelve el tipo de tracción de ese tractor
     * @return La tracción
     */
    public String getTraccion() { return traccion; }

    /**
     * Devuelve el objeto formateado para exportar según el esquema de la pizarra.
     * Ejemplo: JohnDeere # 6120M # 120 # 4WD
     * @return La línea de exportación con el formato correcto
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

    /**
     * Devuelve la representación en cadena del objeto 
     * que coincide con el formato de exportación
     * 
     * @return Cadena con los datos del tractor separados por #.
     */
    @Override
    public String toString() {
        return toLineaExportar();
    }
}


