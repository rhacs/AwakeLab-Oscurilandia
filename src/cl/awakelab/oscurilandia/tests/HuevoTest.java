package cl.awakelab.oscurilandia.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.awakelab.oscurilandia.models.Huevo;
import cl.awakelab.oscurilandia.models.Ubicacion;

class HuevoTest {

    private Huevo huevo;
    private int puntaje;
    private Ubicacion ubicacion;
    
    @BeforeEach
    void setUp() throws Exception {
        puntaje = (int) (Math.random() * 10);
        ubicacion = new Ubicacion(0, 0);
        
        huevo = new Huevo(puntaje, ubicacion);
    }
    
    @Test
    void shouldReturnPuntaje() {
        assertEquals(puntaje, huevo.getPuntaje());
    }
    
    @Test
    void shouldChangePuntaje() {
        int puntaje = -1;
        huevo.setPuntaje(puntaje);
        
        assertEquals(puntaje, huevo.getPuntaje());
    }
    
    @Test
    void shouldReturnUbicacion() {
        assertEquals(ubicacion, huevo.getUbicacion());
    }
    
    @Test
    void shouldChangeUbicacion() {
        Ubicacion u = new Ubicacion(2, 2);
        huevo.setUbicacion(u);
        
        assertEquals(u, huevo.getUbicacion());
    }

}
