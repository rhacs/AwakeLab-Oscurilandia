package cl.awakelab.oscurilandia.models;

/**
 * Clase Ubicación
 */
public class Ubicacion {

    // Attributes ------------------------------------------------------------------------------
    
    private int fila;
    private int columna;
    
    // Constructors ----------------------------------------------------------------------------

    /**
     * Constructor
     * @param fila valor de la fila
     * @param columna valor de la columna
     */
    public Ubicacion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    
    // Getters ---------------------------------------------------------------------------------
    
    /**
     * Devuelve el valor almacenado en fila
     * @return fila
     */
    public int getFila() {
        return this.fila;
    }
    
    /**
     * Devuelve el valor almacenado en columna
     * @return columna
     */
    public int getColumna() {
        return this.columna;
    }
    
    // Setters ---------------------------------------------------------------------------------
    
    /**
     * Cambia el valor de fila
     * @param fila valor a cambiar
     */
    public void setFila(int fila) {
        this.fila = fila;
    }
    
    /**
     * Cambia el valor de columna
     * @param columna valor a cambiar
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    // Inheritances ----------------------------------------------------------------------------
    
    /**
     * Muestra el contenido del objeto
     * @return contenido
     */
    @Override
    public String toString() {
        return "Ubicacion(fila: " + this.getFila() + ", columna: " + this.getColumna() + ")";
    }
    

}
