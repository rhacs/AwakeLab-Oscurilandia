package cl.awakelab.oscurilandia.models;

public class Ubicacion {

    // Attributes ------------------------------------------------------------------------------
    
    private int fila;
    private int columna;
    
    // Constructors ----------------------------------------------------------------------------
    
    public Ubicacion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    
    // Getters ---------------------------------------------------------------------------------
    
    public int getFila() {
        return this.fila;
    }
    
    public int getColumna() {
        return this.columna;
    }
    
    // Setters ---------------------------------------------------------------------------------
    
    public void setFila(int fila) {
        this.fila = fila;
    }
    
    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    // Inheritances ----------------------------------------------------------------------------
    
    @Override
    public String toString() {
        return "Ubicacion(fila: " + this.getFila() + ", columna: " + this.getColumna() + ")";
    }
    

}
