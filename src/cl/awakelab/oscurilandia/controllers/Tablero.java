package cl.awakelab.oscurilandia.controllers;

public class Tablero {

    // Constants -------------------------------------------------------------------------------
    
    private final int FILAS = 15;
    private final int COLUMNAS = 15;
    
    // Attributes ------------------------------------------------------------------------------
    
    private char[][] tablero;
    private boolean cheating;
    
    // Constructors ----------------------------------------------------------------------------
    
    public Tablero(boolean cheating) {
        this.tablero = new char[FILAS][COLUMNAS];
        this.cheating = cheating;
    }
    
    // Methods ---------------------------------------------------------------------------------
    
    
    
    // Getters ---------------------------------------------------------------------------------
    
    
    
    // Setters ---------------------------------------------------------------------------------
    
    
    
    // Inheritances ----------------------------------------------------------------------------
    
    @Override
    public String toString() {
        return "";
    }

}
