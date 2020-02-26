package cl.awakelab.oscurilandia.controllers;

import java.util.ArrayList;
import java.util.List;

import cl.awakelab.oscurilandia.models.Caguano;
import cl.awakelab.oscurilandia.models.Carro;
import cl.awakelab.oscurilandia.models.Huevo;
import cl.awakelab.oscurilandia.models.Kromi;
import cl.awakelab.oscurilandia.models.Trupalla;
import cl.awakelab.oscurilandia.models.Ubicacion;

/**
 * <b>Tablero</b>
 * Esta clase genera un tablero de tamaño {@value #FILAS}x{@value #COLUMNAS} con tres tipos de
 * vehículos: Kromi que ocupa {@value #SIZE_KROMI} celdas, Caguano que ocupa {@value #SIZE_CAGUANO}
 * celdas y Trupalla que ocupa {@value #SIZE_TRUPALLA} celda.
 * Además, se implementan funciones que manejan el comportamiento del juego de acorde a las
 * necesidades que corresponden.
 * 
 */
public class Tablero {

    /** Cantidad de Filas que tendrá el tablero (Valor por defecto: {@value #FILAS}) */
    public final static int FILAS = 15;
    /** Cantidad de Columnas que tendrá el tablero (Valor por defecto: {@value #COLUMNAS}) */
    public final static int COLUMNAS = 15;
    
    /** Cantidad de espacios verticales que ocupará el vehículo Kromi */
    private final int SIZE_KROMI = 3;
    /** Cantidad de espacios horizontales que ocupará el vehículo Caguano */
    private final int SIZE_CAGUANO = 2;
    /** Cantidad de espacion que ocupará el vehículo Trupalla  */
    @SuppressWarnings("unused")
    private final int SIZE_TRUPALLA = 1;
    
    /** Cantidad de Kromis que aparecerán en el tablero */
    private final int QTY_KROMI = 3;
    /** Cantidad de Caguanos que aparecerán en el tablero */
    private final int QTY_CAGUANO = 5;
    /** Cantidad de Trupallas que aparecerán en el tablero */
    private final int QTY_TRUPALLA = 10;
    
    /** Puntaje que se obtendrá cuando se le atine a una Kromi */
    private final int SCORE_KROMI = 3;
    /** Puntaje que se obtendrá cuando se le atine a un Caguano */
    private final int SCORE_CAGUANO = 2;
    /** Puntaje que se obtendrá cuando se le atine a una Trupalla */
    private final int SCORE_TRUPALLA = 1;
    
    /** Puntaje adicional que se obtendrá cuando se elimine una Kromi por completo 
     * ({@value #SIZE_KROMI} espacios) */
    private final int ADICIONAL_KROMI = 10;
    /** Puntaje adicional que se obtendrá cuando se elimine un Caguano por completo
     * ({@value #SIZE_CAGUANO} espacios) */
    private final int ADICIONAL_CAGUANO = 7;
    
    // Attributes ------------------------------------------------------------------------------
    
    /** Variable para indicar si se muestran o no el contenido de las celdas */
    private boolean cheating;
    /** Donde se almacenan las etiquetas del juego (K, C, T, H) */
    private String[][] tablero;
    /** Donde se almacena el puntaje obtenido por juego */
    private int puntaje;
    
    /** Listado de Huevos arrojados por el usuario */
    private List<Huevo> huevos;
    /** Listado de Carros generados por la aplicación */
    private List<Carro> carros;
    
    // Constructors ----------------------------------------------------------------------------
    
    /**
     * Constructor de la clase
     * @param cheating Indica si se muestra o no el contenido del tablero
     */
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
    
    /**
     * Agrega una trupalla al tablero en una fila,columna que estén desocupadas
     */
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
    
    /**
     * Agrega un Caguano al tablero en una fila,columna que estén desocupadas. Además verifica
     * que la celda de la derecha esté desocupada y dentro del rango permitido.
     */
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
    
    /**
     * Agrega una Kromi al tablero en una celda que esté desocupada, verificando que las dos celdas
     * que le siguen hacia abajo estén disponibles
     */
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
    
    /**
     * Permite verificar que la celda definida por fila y columna esté desocupada
     * @param fila fila que se quiere verificar
     * @param columna columna que se quiere verificar
     * @return verdadero o falso según la disponibilidad
     */
    private boolean isViable(int fila, int columna) {
        if(tablero[fila][columna] != null)
            return false;
        
        return true;
    }
    
    /**
     * Verifica que la celda definida por el programa, además de la derecha para el Caguano y las
     * dos siguientes para la Kromi estén disponibles para su uso.
     * @param fila fila que se quiere verificar
     * @param columna columna que se quiere verificar
     * @param horizontal Verdadero si vehículo == Caguano, falso si vehículo == Kromi
     * @return verdadero o falso según corresponda
     */
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
    
    /**
     * Arroja un huevo al tablero en la celda de coordenadas [fila, columna] verificando que esté
     * o no ocupada y actuando según corresponda
     * @param fila fila
     * @param columna columna
     * @return Celda afectada
     */
    public String arrojarHuevo(int fila, int columna) {
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
        return celda;
    }
    
    /**
     * Recorre la lista carros en búsqueda de la celda con coordenadas [fila, columna]. Si la
     * ubicación está dentro del carro en cuestión, devuelve el carro, sino, devuelve nulo.
     * @param fila fila
     * @param columna columna
     * @return Carro encontrado o nulo
     */
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
    
    /**
     * Compara el carro con la lista de huevo arrojados por el usuario. Si todas las posiciones
     * del carro se vieron afectadas por el atentado, entonces devuelve verdadero. En caso 
     * contrario, devuelve falso.
     * @param carro Carro a analizar
     * @return verdadero o falso según sea el caso
     */
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
    
    /**
     * "Hermosea" la cadena
     * @param separador Separador que se ocupará entre celdas
     * @param tope Tope que se usará para el último valor
     * @return Cadena formateada
     */
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
    
    /**
     * Devuelve el puntaje obtenido por el usuario
     * @return puntaje
     */
    public int getPuntaje() {
        return this.puntaje;
    }
    
    /**
     * Devuelve el listado de carros generados por la aplicacion
     * @return carros
     */
    public List<Carro> getCarros() {
        return this.carros;
    }
    
    /**
     * Devuelve el listado de huevos lanzados por el usuario
     * @return huevos
     */
    public List<Huevo> getHuevos() {
        return this.huevos;
    }
    
    // Setter ----------------------------------------------------------------------------------
    
    /**
     * Cambia el valor de la variable cheating
     * @param cheating nuevo valor
     */
    public void setCheating(boolean cheating) {
        this.cheating = cheating;
    }
    
    // Inheritances ----------------------------------------------------------------------------
    
    /**
     * Muestra de forma ordenada el tablero del juego actual
     * @return contenido del tablero
     */
    @Override
    public String toString() {
        String temp = "╔" + hermoseameLaCadena("═", "╗");
        temp += String.format("║ Oscurilandia %" + ((COLUMNAS * 4) - 30) + "s Puntaje: %4d ║\n",
                "", puntaje);
        temp += "╠" + hermoseameLaCadena("╦", "╣");

        for(int i = 0; i < FILAS; i++) {
            temp += "║";
            
            for(int j = 0; j < COLUMNAS; j++) {
                temp += " ";
                
                if(cheating) {
                    if(tablero[i][j] != null)
                        temp += tablero[i][j];
                    else
                        temp += " ";
                } else {
                    if(tablero[i][j] != null && tablero[i][j].equals("H"))
                        temp += "H";
                    else
                        temp += " ";
                }
                
                temp += " ║";
            }
            
            if(i != (FILAS - 1))
                temp += "\n╠" + hermoseameLaCadena("╬", "╣");
        }
        
        temp += "\n╚" + hermoseameLaCadena("╩", "╝");
        
        return temp;
    }

}
