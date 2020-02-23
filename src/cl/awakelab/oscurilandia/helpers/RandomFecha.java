package cl.awakelab.oscurilandia.helpers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class RandomFecha {

    // Attributes ------------------------------------------------------------------------------
    
    private Date fecha;
    
    // Constructors ----------------------------------------------------------------------------
    
    public RandomFecha() {
        GregorianCalendar calendario = new GregorianCalendar();
        
        int year = aleatorio(1980, 2010);
        int dia = aleatorio(1, calendario.getActualMaximum(Calendar.DAY_OF_YEAR));
        
        calendario.set(Calendar.YEAR, year);
        calendario.set(Calendar.DAY_OF_YEAR, dia);
        
        this.fecha = calendario.getTime();
    }
    
    // Methods ---------------------------------------------------------------------------------
    
    private int aleatorio(int inicio, int fin) {
        return inicio + (int) Math.round(Math.random() * (fin - inicio));
    }
    
    // Getters ---------------------------------------------------------------------------------
    
    public Date getFecha() {
        return this.fecha;
    }
    
    // Inheritances ----------------------------------------------------------------------------
    
    @Override
    public String toString() {
        return "RandomFecha(fecha: '" + this.getFecha().toString() + "')";
    }

}
