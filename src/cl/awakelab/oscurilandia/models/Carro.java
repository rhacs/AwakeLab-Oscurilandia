package cl.awakelab.oscurilandia.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.awakelab.oscurilandia.helpers.RandomFecha;

/**
 * Clase abstracta Carro
 */
public abstract class Carro {

    // Attributes ------------------------------------------------------------------------------
    
    private Ubicacion ubicacion;
    private Date ingreso;
    private int ocupantes;
    
    private List<Ubicacion> ubicaciones;
    
    // Constructors ----------------------------------------------------------------------------
    
    /**
     * Constructor. Genera los valores de los atributos de forma aleatoria a excepción de la
     * ubicación
     */
    public Carro() {
        this.ingreso = new RandomFecha().getFecha();
        this.ocupantes = (int) (Math.random() * 20 + 1);
        this.ubicaciones = new ArrayList<>();
    }
    
    // Methods ---------------------------------------------------------------------------------
    
    /**
     * Agrega una ubicación al listado de ubicaciones
     * @param ubicacion nuevo valor
     */
    public void addUbicacion(Ubicacion ubicacion) {
        this.ubicaciones.add(ubicacion);
    }
    
    /**
     * Devuelve el tipo de vehículo
     * @return tipo de vehículo
     */
    public abstract String getTipo();
    
    // Getters ---------------------------------------------------------------------------------
    
    /**
     * Devuelve el listado de ubicaciones
     * @return ubicaciones
     */
    public List<Ubicacion> getUbicaciones() {
        return this.ubicaciones;
    }
    
    /**
     * Devuelve la ubicación del objeto
     * @return ubicación
     */
    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }
    
    /**
     * Devuelve la fecha de ingreso del vehículo a la institución
     * @return fecha de ingreso
     */
    public Date getIngreso() {
        return this.ingreso;
    }
    
    /**
     * Devuelve la cantidad de ocupantes del vehículo
     * @return ocupantes
     */
    public int getOcupantes() {
        return this.ocupantes;
    }
    
    // Setters ---------------------------------------------------------------------------------
    
    /**
     * Cambia la ubicación del vehículo
     * @param ubicacion nuevo valor
     */
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    /**
     * Cambia la fecha de ingreso del vehículo a la institución
     * @param fecha nuevo valor
     */
    public void setIngreso(Date fecha) {
        this.ingreso = fecha;
    }
    
    /**
     * Cambia la cantidad de ocupantes del vehículo
     * @param ocupantes nuevo valor
     */
    public void setOcupantes(int ocupantes) {
        this.ocupantes = ocupantes;
    }
    
    // Inheritances ----------------------------------------------------------------------------
    
    /**
     * Muestra el contenido del objeto
     * @return contenido del objeto
     */
    @Override
    public String toString() {
        return "Carro(ubicacion: " + this.getUbicaciones() + 
                ", ingreso: '" + this.getIngreso() + 
                "', ocupantes: " + this.getOcupantes() + ")";
    }
    
}
