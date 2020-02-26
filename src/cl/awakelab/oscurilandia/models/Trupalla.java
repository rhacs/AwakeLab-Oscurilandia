package cl.awakelab.oscurilandia.models;

import cl.awakelab.oscurilandia.helpers.RandomNombre;

/**
 * Clase Trupalla
 * @author Diego Quiero
 */
public class Trupalla extends Carro {

    private int armadura;
    private String manipula;
    
    /**
     * Constructor
     * Genera los valores de los atributos de manera aleatoria
     */
    public Trupalla() {
        this.armadura = (int) (Math.random()*5 +1);
        this.manipula = new RandomNombre().getNombre();
    }
    
    /**
     * Devuelve la armadura del vehículo
     * @return armadura
     */
    public int getArmadura() {
        return armadura;
    }

    /**
     * Cambia el valor de la armadura del vehículo
     * @param armadura nuevo valor
     */
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    /**
     * Devuelve el nombre del conductor del vehículo
     * @return manipulador
     */
    public String getManipula() {
        return manipula;
    }

    /**
     * Cambia el nombre del conductor del vehículo
     * @param ocupante nuevo valor
     */
    public void setManipula(String ocupante) {
        this.manipula = ocupante;
    }

    /**
     * Muestra el contenido del objeto
     * @return contenido
     */
    @Override
    public String toString() {
        return "Trupalla(ubicacion: " + this.getUbicaciones() + 
                ", ingreso: '" + this.getIngreso() + 
                "', ocupantes: " + this.getOcupantes() +
                ", armadura: " + this.getArmadura() +
                ", manipula: '" + this.getManipula() + "')";
    }
    
    /**
     * Devuelve el tipo de vehículo
     * @return "Trupalla"
     */
    @Override
    public String getTipo() {
        return "Trupalla";
    }

}
