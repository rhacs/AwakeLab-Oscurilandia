package cl.awakelab.oscurilandia.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.awakelab.oscurilandia.helpers.RandomFecha;

public abstract class Carro {

    // Attributes ------------------------------------------------------------------------------
    
    private Ubicacion ubicacion;
    private Date ingreso;
    private int ocupantes;
    
    private List<Ubicacion> ubicaciones;
    
    // Constructors ----------------------------------------------------------------------------
    
    public Carro() {
        this.ingreso = new RandomFecha().getFecha();
        this.ocupantes = (int) (Math.random() * 20 + 1);
        this.ubicaciones = new ArrayList<>();
    }
    
//    public Carro(Ubicacion ubicacion) {
//        this.ubicacion = ubicacion;
//        
//        this.ingreso = new RandomFecha().getFecha();
//        this.ocupantes = (int) (Math.random() * 20 + 1);
//    }
    
    // Methods ---------------------------------------------------------------------------------
    
    public void addUbicacion(Ubicacion ubicacion) {
        this.ubicaciones.add(ubicacion);
    }
    
    public abstract String getTipo();
    
    // Getters ---------------------------------------------------------------------------------
    
    public List<Ubicacion> getUbicaciones() {
        return this.ubicaciones;
    }
    
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
