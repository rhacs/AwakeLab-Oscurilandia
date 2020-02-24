package cl.awakelab.oscurilandia.models;

import java.util.Date;

import cl.awakelab.oscurilandia.helpers.RandomFecha;

public abstract class Carro {

    // Attributes ------------------------------------------------------------------------------
    
    private Ubicacion ubicacion;
    private Date ingreso;
    private int ocupantes;
    
    // Constructors ----------------------------------------------------------------------------
    
    public Carro(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
        
        this.ingreso = new RandomFecha().getFecha();
        this.ocupantes = (int) (Math.random() * 20 + 1);
    }
    
    public Carro(Ubicacion ubicacion, Date ingreso, int ocupantes) {
        this(ubicacion);
        
        this.ingreso = ingreso;
        this.ocupantes = ocupantes;
    }
    
    // Methods ---------------------------------------------------------------------------------
    
    public abstract String getTipo();
    
    // Getters ---------------------------------------------------------------------------------
    
    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }
    
    public Date getIngreso() {
        return this.ingreso;
    }
    
    public int getOcupantes() {
        return this.ocupantes;
    }
    
    // Setters ---------------------------------------------------------------------------------
    
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public void setIngreso(Date fecha) {
        this.ingreso = fecha;
    }
    
    public void setOcupantes(int ocupantes) {
        this.ocupantes = ocupantes;
    }
    
    // Inheritances ----------------------------------------------------------------------------
    
    @Override
    public String toString() {
        return "Carro(ubicacion: " + this.getUbicacion() + 
                ", ingreso: '" + this.getIngreso() + 
                "', ocupantes: " + this.getOcupantes() + ")";
    }
    
}
