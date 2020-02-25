package cl.awakelab.oscurilandia.controllers;

import java.util.ArrayList;
import java.util.List;

import cl.awakelab.oscurilandia.models.Caguano;
import cl.awakelab.oscurilandia.models.Carro;
import cl.awakelab.oscurilandia.models.Huevo;
import cl.awakelab.oscurilandia.models.Kromi;
import cl.awakelab.oscurilandia.models.Trupalla;
import cl.awakelab.oscurilandia.models.Ubicacion;

public class Tablero {

    public final static int FILAS = 15;
    public final static int COLUMNAS = 15;
    
    private final int SIZE_KROMI = 3;
    private final int SIZE_CAGUANO = 2;
    
    private final int QTY_KROMI = 3;
    private final int QTY_CAGUANO = 5;
    private final int QTY_TRUPALLA = 10;
    
    private final int SCORE_KROMI = 3;
    private final int SCORE_CAGUANO = 2;
    private final int SCORE_TRUPALLA = 1;
    
    private final int ADICIONAL_KROMI = 10;
    private final int ADICIONAL_CAGUANO = 7;
    
    // Attributes ------------------------------------------------------------------------------
    
    private boolean cheating;
    private String[][] tablero;
    private int puntaje;
    
    private List<Huevo> huevos;
    private List<Carro> carros;
    
    // Constructors ----------------------------------------------------------------------------
    
    public Tablero(boolean cheating) {
        this.cheating = cheating;
        this.tablero = new String[FILAS][COLUMNAS];
        this.puntaje = 0;
        
        this.huevos = new ArrayList<>();
        this.carros = new ArrayList<>();
        
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
        
        Trupalla trupalla = new Trupalla();
        trupalla.addUbicacion(new Ubicacion(fila, columna));
    }
    
    private void insertarCaguano() {
        int fila;
        int columna;
        
        do {
            fila = (int) (Math.random() * FILAS);
            columna = (int) (Math.random() * (COLUMNAS - SIZE_CAGUANO));
        } while(!isViable(fila, columna, true));

        Caguano caguano = new Caguano();
        for(int i = 0; i < SIZE_CAGUANO; i++) {
            caguano.addUbicacion(new Ubicacion(fila, columna + i));
            this.tablero[fila][columna + i] = "C";
        }
        
        this.carros.add(caguano);
    }
    
    private void insertarKromi() {
        int fila;
        int columna;
        
        do {
            fila = (int) (Math.random() * (FILAS - (SIZE_KROMI + 1)));
            columna = (int) (Math.random() * COLUMNAS);
        } while(!isViable(fila, columna, false));
        
        Kromi kromi = new Kromi();
        for(int i = 0; i < SIZE_KROMI; i++) {
            kromi.addUbicacion(new Ubicacion(fila + i, columna));
            this.tablero[fila + i][columna] = "K";
        }
        
        carros.add(kromi);
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
    
    public void arrojarHuevo(int fila, int columna) {
        int puntaje = 0;
        String celda = tablero[fila][columna];
        
        if(celda != null) {
            if(!celda.equals("H")) {
                
                if(celda.equals("K"))
                    puntaje += SCORE_KROMI;
                else if(celda.equals("C"))
                    puntaje += SCORE_CAGUANO;
                else
                    puntaje += SCORE_TRUPALLA;
                
            }
        }
        
        Huevo huevo = new Huevo(puntaje, new Ubicacion(fila, columna));
        huevos.add(huevo);
        
        Carro carro = existeCarro(fila, columna);
        if(carro != null && meLaPitie(carro)) {
            String etiqueta = tablero[fila][columna];
            
            if(etiqueta != null) {
                if(etiqueta.equals("K"))
                    puntaje += ADICIONAL_KROMI;
                else if(etiqueta.equals("C"))
                    puntaje += ADICIONAL_CAGUANO;
            }
        }

        tablero[fila][columna] = "H";
        this.puntaje += puntaje;
    }
    
    private Carro existeCarro(int fila, int columna) {
        for(Carro carro : this.carros) {
            List<Ubicacion> ubicaciones = carro.getUbicaciones();
            
            for(Ubicacion u : ubicaciones) {
                if(u.getFila() == fila && u.getColumna() == columna)
                    return carro;
            }
        }
        
        return null;
    }
    
    private boolean meLaPitie(Carro carro) {
        List<Ubicacion> ubicaciones = carro.getUbicaciones();
        int posicionesAtacadas = 0;
        
        for(Ubicacion ubicacion : ubicaciones) {
            for(Huevo huevo : this.huevos) {
                Ubicacion ubHuevo = huevo.getUbicacion();
                
                if(ubicacion.getFila() == ubHuevo.getFila() && 
                        ubicacion.getColumna() == ubHuevo.getColumna())
                    posicionesAtacadas++;
            }
        }
        
        if(posicionesAtacadas == ubicaciones.size())
            return true;
        
        return false;
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
    
    // Getters ---------------------------------------------------------------------------------
    
    public int getPuntaje() {
        return this.puntaje;
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
