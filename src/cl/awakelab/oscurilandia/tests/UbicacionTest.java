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
        fila = (int) (Math.random() * 20);
        
        // Para efectos de pruebas, evitamos que los valores de fila y columna sean iguales
        do {
            columna = (int) (Math.random() * 20);
        } while(columna == fila);
        
        ubicacion = new Ubicacion(fila, columna);
    }
    
    // Verificar que el valor que me devuelve es el de fila
    @Test
    void shouldReturnFila() { 
        assertEquals(fila, ubicacion.getFila());
    }
    
    // Verificar que el valor que cambia es el de fila
    @Test
    void shouldChangeFila() {
        int fila = -1;
        ubicacion.setFila(fila);
        
        assertEquals(fila, ubicacion.getFila());
    }
    
    // Verificar que el valor que me devuelve es el de columna
    @Test
    void shouldReturnColumna() {
        assertEquals(columna, ubicacion.getColumna());
    }
    
    // Verificar que el valor que cambia es columna
    @Test
    void shouldChangeColumna() {
        int columna = -1;
        ubicacion.setColumna(columna);
        
        assertEquals(columna, ubicacion.getColumna());
    }

}
