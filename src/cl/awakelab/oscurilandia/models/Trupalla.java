package cl.awakelab.oscurilandia.models;

import java.util.Date;

import cl.awakelab.oscurilandia.helpers.RandomFecha;

public class Trupalla extends Carro {

    private Date fabricacion;
    private String marca;
    
    public Trupalla(Ubicacion ubicacion) {
        super(ubicacion);
        this.fabricacion = new RandomFecha().getFecha();
        this.marca = new String("Dodge");
    }
    
    

    
    @Override
    public String getTipo() {
        // TODO Ap�ndice de m�todo generado autom�ticamente
        return null;
    }

}
