package cl.awakelab.oscurilandia.controllers;

public class Tablero {

    public final int FILAS = 15;
    public final int COLUMNAS = 15;
    
    private final int SIZE_KROMI = 3;
    private final int SIZE_CAGUANO = 2;
    
    private final int QTY_KROMI = 3;
    private final int QTY_CAGUANO = 5;
    private final int QTY_TRUPALLA = 10;
    
    // Attributes ------------------------------------------------------------------------------
    
    private boolean cheating;
    private String[][] tablero;
    private int puntaje;
    
    // Constructors ----------------------------------------------------------------------------
    
    public Tablero(boolean cheating) {
        this.cheating = cheating;
        this.tablero = new String[FILAS][COLUMNAS];
        this.puntaje = 0;
        
        // Insertar Kromi
        for(int i = 0; i < QTY_KROMI; i++)
            insertarKromi();
        
        // Insertar Caguano
        for(int i = 0; i < QTY_CAGUANO; i++)
            insertarCaguano();
        
        // Insertar Trupalla
        for(int i = 0; i < QTY_TRUPALLA; i++)
            insertarTrupalla();
    }
    
    // Methods ---------------------------------------------------------------------------------
    
    private void insertarTrupalla() {
        int fila;
        int columna;
        
        do {
            fila = (int) (Math.random() * FILAS);
            columna = (int) (Math.random() * COLUMNAS);
        } while(!isViable(fila, columna));
        
        this.tablero[fila][columna] = "T";
    }
    
    private void insertarCaguano() {
        int fila;
        int columna;
        
        do {
            fila = (int) (Math.random() * FILAS);
            columna = (int) (Math.random() * (COLUMNAS - SIZE_CAGUANO));
        } while(!isViable(fila, columna, true));
        
        for(int i = 0; i < SIZE_CAGUANO; i++)
            this.tablero[fila][columna + i] = "C";
    }
    
    private void insertarKromi() {
        int fila;
        int columna;
        
        do {
            fila = (int) (Math.random() * (FILAS - (SIZE_KROMI + 1)));
            columna = (int) (Math.random() * COLUMNAS);
        } while(!isViable(fila, columna, false));
        
        for(int i = 0; i < SIZE_KROMI; i++)
            this.tablero[fila + i][columna] = "K";
    }
    
    private boolean isViable(int fila, int columna) {
        if(tablero[fila][columna] != null)
            return false;
        
        return true;
    }
    
    private boolean isViable(int fila, int columna, boolean horizontal) {
        if(horizontal) {
            for(int i = 0; i < SIZE_CAGUANO; i++) {
                if(!isViable(fila, columna + i))
                    return false;
            }
        } else {
            for(int i = 0; i < SIZE_KROMI; i++) {
                if(!isViable(fila + i, columna))
                    return false;
            }
        }
        
        return true;
    }
    
    private String hermoseameLaCadena(String separador, String tope) {
        String temp = "";
        
        for(int i = 0; i < COLUMNAS; i++) {
            temp += "═══";
            
            if(i == (COLUMNAS - 1))
                temp += tope + "\n";
            else
                temp += separador;
        }
        
        return temp;
    }
    
    // Inheritances ----------------------------------------------------------------------------
    
    @Override
    public String toString() {
        String temp = "╔" + hermoseameLaCadena("═", "╗");
        temp += String.format("║ Oscurilandia %" + ((COLUMNAS * 4) - 30) + "s Puntaje: %4d ║\n",
                "", puntaje);
        temp += "╠" + hermoseameLaCadena("╦", "╣");

        for(int i = 0; i < FILAS; i++) {
            temp += "║";
            
            for(int j = 0; j < COLUMNAS; j++) {
                temp += " " + 
                        (cheating ? (tablero[i][j] == null ? " " : tablero[i][j]) : " ") + " ║";
            }
            
            if(i != (FILAS - 1))
                temp += "\n╠" + hermoseameLaCadena("╬", "╣");
        }
        
        temp += "\n╚" + hermoseameLaCadena("╩", "╝");
        
        return temp;
    }

}
