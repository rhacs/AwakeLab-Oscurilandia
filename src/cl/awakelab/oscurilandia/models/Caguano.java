package cl.awakelab.oscurilandia.models;

import java.util.Date;

import cl.awakelab.oscurilandia.helpers.RandomFecha;

public class Caguano extends Carro {
    
    private int alcanceDeTiro;
    private String colorConfeti;
    private Date fechaDeFabricacion;
    
    public Caguano() {
        this.alcanceDeTiro = (int) (Math.random()* 10);
        this.colorConfeti = "cafe"; 
        this.fechaDeFabricacion = new RandomFecha().getFecha();
    }

    public float getAlcanceDeTiro() {
        return alcanceDeTiro;
    }

    public void setAlcanceDeTiro(int alcanceDeTiro) {
        this.alcanceDeTiro = alcanceDeTiro;
    }
    
    public String getColorConfeti() {
        return colorConfeti;
    }

    public void setColorConfeti(String colorConfeti) {
        this.colorConfeti = colorConfeti;
    }

    public void setFechaDeFabricacion(Date fechaDeFabricacion) {
        this.fechaDeFabricacion = fechaDeFabricacion;
    }

    public Date getFechaDeFabricacion() {
        return fechaDeFabricacion;
    }

    @Override
    public String getTipo() {
        // TODO Auto-generated method stub
        return "Caguano";
    }

    @Override
    public String toString() {
        return "carro(ubicacion: " + this.getUbicacion() +
                ", ingreso: '" + this.getIngreso() +
                "', ocupantes: " + this.getOcupantes() + 
                ", alcanceDeTiro: " + this.getAlcanceDeTiro() +
                ", colorConfeti: " + this.getColorConfeti() + ")";

    }

}
