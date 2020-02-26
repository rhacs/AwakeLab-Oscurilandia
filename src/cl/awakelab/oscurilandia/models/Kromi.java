package cl.awakelab.oscurilandia.models;

import java.util.Date;

import cl.awakelab.oscurilandia.helpers.RandomFecha;

/**
 * Clase Kromi
 * @author Diego Quiero
 */
public class Kromi extends Carro {

    private Date fabricacion;
    private String marca;

    /**
     * Constructor
     * Genera los valores de forma aleatoria
     */
    public Kromi() {
        this.fabricacion = new RandomFecha().getFecha();
        this.marca = new String("Volvo");
    }

    /**
     * Devuelve la fecha de fabricación del vehículo
     * @return fecha de fabricación
     */
    public Date getFabricacion() {
        return fabricacion;
    }

    /**
     * Cambia la fecha de fabricación del vehículo
     * @param fabricacion nuevo valor
     */
    public void setFabricacion(Date fabricacion) {
        this.fabricacion = fabricacion;
    }

    /**
     * Devuelve la marca del vehículo
     * @return marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Cambia la marca del vehículo
     * @param marca nuevo valor
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Muestra el contenido del objeto
     * @return contenido del objeto
     */
    @Override
    public String toString() {
        return "Kromi(ubicacion: " + this.getUbicaciones() + 
                ", ingreso: '" + this.getIngreso() + 
                "', ocupantes: " + this.getOcupantes() +
                ", fabricacion: '" + this.getFabricacion() +
                "', marca : '" + this.getMarca() + "')";
    }

    /**
     * Devuelve el tipo de vehículo
     * @return "Kromi"
     */
    @Override
    public String getTipo() {
        return "Kromi";
    }

}
