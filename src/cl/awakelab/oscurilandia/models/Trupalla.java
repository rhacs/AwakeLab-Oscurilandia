package cl.awakelab.oscurilandia.models;

import cl.awakelab.oscurilandia.helpers.RandomNombre;

/**
 * @author Diego Quiero
 */
public class Trupalla extends Carro {

    private int armadura;
    private String manipula;
    
    public Trupalla() {
        this.armadura = (int) (Math.random()*5 +1);
        this.manipula = new RandomNombre().getNombre();
    }
    
    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public String getManipula() {
        return manipula;
    }

    public void setManipula(String ocupante) {
        this.manipula = ocupante;
    }

    @Override
    public String toString() {
        return "Trupalla(ubicacion: " + this.getUbicacion() + 
                ", ingreso: '" + this.getIngreso() + 
                "', ocupantes: " + this.getOcupantes() +
                ", armadura: " + this.getArmadura() +
                ", manipula: '" + this.getManipula() + "')";
    }
    
    @Override
    public String getTipo() {
        return "Trupalla";
    }

}
