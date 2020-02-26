package cl.awakelab.oscurilandia.models;

import java.util.Date;

import cl.awakelab.oscurilandia.helpers.RandomFecha;

/**
 * Clase Caguano
 * @author Ariel Astorga
 */
public class Caguano extends Carro {
    
    private int alcanceDeTiro;
    private String colorConfeti;
    private Date fechaDeFabricacion;
    
    /** 
     * Constructor
     */
    public Caguano() {
        this.alcanceDeTiro = (int) (Math.random()* 10);
        this.colorConfeti = "cafe"; 
        this.fechaDeFabricacion = new RandomFecha().getFecha();
    }

    /**
     * Devuelve el valor del alcance de tiro
     * @return alcance de tiro
     */
    public int getAlcanceDeTiro() {
        return alcanceDeTiro;
    }

    /**
     * Cambia el valor del alcance de tiro
     * @param alcanceDeTiro nuevo valor
     */
    public void setAlcanceDeTiro(int alcanceDeTiro) {
        this.alcanceDeTiro = alcanceDeTiro;
    }
    
    /**
     * Devuelve el valor del color de confeti
     * @return color del confeti
     */
    public String getColorConfeti() {
        return colorConfeti;
    }

    /**
     * Cambia el valor del color de confeti
     * @param colorConfeti nuevo valor
     */
    public void setColorConfeti(String colorConfeti) {
        this.colorConfeti = colorConfeti;
    }

    /**
     * Cambia el valor de la Fecha de Fabricación del vehículo
     * @param fechaDeFabricacion nuevo valor
     */
    public void setFechaDeFabricacion(Date fechaDeFabricacion) {
        this.fechaDeFabricacion = fechaDeFabricacion;
    }

    /**
     * Devuelve el valor de la fecha de fabricación
     * @return fecha de fabricación
     */
    public Date getFechaDeFabricacion() {
        return fechaDeFabricacion;
    }

    /**
     * Devuelve el tipo de vehículo
     * @return Caguano
     */
    @Override
    public String getTipo() {
        return "Caguano";
    }

    /**
     * Muestra el contenido del objeto
     * @return contenido del objeto
     */
    @Override
    public String toString() {
        return "carro(ubicacion: " + this.getUbicaciones() +
                ", ingreso: '" + this.getIngreso() +
                "', ocupantes: " + this.getOcupantes() + 
                ", alcanceDeTiro: " + this.getAlcanceDeTiro() +
                ", colorConfeti: " + this.getColorConfeti() + ")";
    }

}
