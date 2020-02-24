package cl.awakelab.oscurilandia.models;

public class Huevo {

    // Attributes ------------------------------------------------------------------------------
    
    private int puntaje;
    private Ubicacion ubicacion;
    
    // Constructors ----------------------------------------------------------------------------
    
    public Huevo(int puntaje, Ubicacion ubicacion) {
        this.puntaje = puntaje;
        this.ubicacion = ubicacion;
    }
    
    // Getters ---------------------------------------------------------------------------------
    
    public int getPuntaje() {
        return this.puntaje;
    }
    
    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }
    
    // Setters ---------------------------------------------------------------------------------
    
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    // Inheritances ----------------------------------------------------------------------------
    
    @Override
    public String toString() {
        return "Huevo(puntaje: " + this.getPuntaje() + ", ubicacion: " + this.getUbicacion() + ")";
    }
    
}
