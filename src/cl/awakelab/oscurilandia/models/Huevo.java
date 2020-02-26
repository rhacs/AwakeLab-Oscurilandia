package cl.awakelab.oscurilandia.models;

/**
 * Clase Huevo
 */
public class Huevo {

    // Attributes ------------------------------------------------------------------------------
    
    private int puntaje;
    private Ubicacion ubicacion;
    
    // Constructors ----------------------------------------------------------------------------
    
    /**
     * Constructor
     * @param puntaje Puntaje obtenido al momento de lanzar el huevo
     * @param ubicacion Celda en donde se arrojó el huevo
     */
    public Huevo(int puntaje, Ubicacion ubicacion) {
        this.puntaje = puntaje;
        this.ubicacion = ubicacion;
    }
    
    // Getters ---------------------------------------------------------------------------------
    
    /**
     * Devuelve el puntaje obtenido
     * @return puntaje
     */
    public int getPuntaje() {
        return this.puntaje;
    }
    
    /**
     * Devuelve la ubicación del huevo
     * @return ubicacion
     */
    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }
    
    // Setters ---------------------------------------------------------------------------------
    
    /**
     * Cambia el valor del puntaje
     * @param puntaje valor a cambiar
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    /**
     * Cambia la ubicación del huevo en el tablero
     * @param ubicacion valor a cambiar
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    // Inheritances ----------------------------------------------------------------------------
    
    /**
     * Muestra el contenido del objeto
     * @return contenido
     */
    @Override
    public String toString() {
        return "Huevo(puntaje: " + this.getPuntaje() + ", ubicacion: " + this.getUbicacion() + ")";
    }
    
}
