package cl.awakelab.oscurilandia.helpers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Genera una fecha aleatoria
 */
public class RandomFecha {

    // Attributes ------------------------------------------------------------------------------
    
    private Date fecha;
    
    // Constructors ----------------------------------------------------------------------------
    
    /**
     * Constructor y generador de la fecha aleatoria
     */
    public RandomFecha() {
        GregorianCalendar calendario = new GregorianCalendar();
        
        int year = aleatorio(1980, 2010);
        int dia = aleatorio(1, calendario.getActualMaximum(Calendar.DAY_OF_YEAR));
        
        calendario.set(Calendar.YEAR, year);
        calendario.set(Calendar.DAY_OF_YEAR, dia);
        
        this.fecha = calendario.getTime();
    }
    
    // Methods ---------------------------------------------------------------------------------
    
    /**
     * Genera un valor aleatorio entre inicio y fin
     * @param inicio valor mínimo
     * @param fin valor máximo
     * @return valor aleatorio
     */
    private int aleatorio(int inicio, int fin) {
        return inicio + (int) Math.round(Math.random() * (fin - inicio));
    }
    
    // Getters ---------------------------------------------------------------------------------
    
    /**
     * Devuelve la fecha generada aleatoriamente
     * @return fecha
     */
    public Date getFecha() {
        return this.fecha;
    }
    
    // Inheritances ----------------------------------------------------------------------------
    
    /**
     * Muestra el contenido del objeto
     * @return contenido
     */
    @Override
    public String toString() {
        return "RandomFecha(fecha: '" + this.getFecha().toString() + "')";
    }

}
