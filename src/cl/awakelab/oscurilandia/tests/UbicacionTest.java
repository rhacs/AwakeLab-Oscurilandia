package cl.awakelab.oscurilandia.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.awakelab.oscurilandia.models.Ubicacion;

class UbicacionTest {

    private Ubicacion ubicacion;
    private int fila;
    private int columna;
    
    @BeforeEach
    void setUp() throws Exception {
        fila = (int) Math.round(Math.random() * 20);
        columna = (int) Math.round(Math.random() * 20);
        
        ubicacion = new Ubicacion(fila, columna);
    }
    
    @Test
    void shouldReturnFila() { 
        assertEquals(fila, ubicacion.getFila());
    }
    
    @Test
    void shouldChangeFila() {
        int fila = -1;
        ubicacion.setFila(fila);
        
        assertEquals(fila, ubicacion.getFila());
    }
    
    @Test
    void shouldReturnColumna() {
        assertEquals(columna, ubicacion.getColumna());
    }
    
    @Test
    void shouldChangeColumna() {
        int columna = -1;
        ubicacion.setColumna(columna);
        
        assertEquals(columna, ubicacion.getColumna());
    }

}
