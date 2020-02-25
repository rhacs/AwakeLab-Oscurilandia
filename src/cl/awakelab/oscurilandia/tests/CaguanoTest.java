package cl.awakelab.oscurilandia.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.awakelab.oscurilandia.helpers.RandomFecha;
import cl.awakelab.oscurilandia.models.Caguano;
import cl.awakelab.oscurilandia.models.Ubicacion;

import java.util.Date;
class CaguanoTest {
    
    private Caguano caguano;
    private int  alcanceDeTiro;
    private Ubicacion ubicacion;
    private String colorConfeti;
    private Date ingreso;
    private int numeroDeOcupantes;
    private Date fechaDeFabricacion;
    

    @BeforeEach
    void setup() throws Exception {
        alcanceDeTiro = (int) (Math.random()* 10);
        colorConfeti = "cafe";
        ubicacion = new Ubicacion(0,0);
        numeroDeOcupantes = (int) (Math.random() * 10 - 8);
        fechaDeFabricacion = new RandomFecha().getFecha();
        ingreso = new RandomFecha().getFecha();
        
        caguano = new Caguano(ubicacion);
        caguano.setColorConfeti(colorConfeti);
        caguano.setAlcanceDeTiro(alcanceDeTiro);
        caguano.setOcupantes(numeroDeOcupantes);
        caguano.setFechaDeFabricacion(fechaDeFabricacion);
        caguano.setIngreso(ingreso);
        
    }
    
    @Test
    void shouldReturnUbicacion() {
        assertEquals(ubicacion, caguano.getUbicacion());
    }

    @Test
    void shouldChangeUbicacion() {
        Ubicacion u = new Ubicacion(3, 5);
        caguano.setUbicacion(u);
        assertEquals(u, caguano.getUbicacion());
    }

    @Test
    void shouldReturnalcanceDeTiro() {
        assertEquals(alcanceDeTiro, caguano.getAlcanceDeTiro());
    }
    
    @Test
    void shouldChangeAlcanceDeTiro() {
        int alcanceDeTiro = (int) (Math.random()* 10);
        caguano.setAlcanceDeTiro(alcanceDeTiro);
        assertEquals(alcanceDeTiro, caguano.getAlcanceDeTiro());
    }
    
    @Test
    void shouldReturncolorConfeti() {
         assertEquals(colorConfeti, caguano.getColorConfeti());
    }
    
    @Test
    void shouldChangeColorConfeti() {
        String color = "verde";
        caguano.setColorConfeti(color);
        assertEquals(color, caguano.getColorConfeti());
  
}
    @Test
    void shouldChangeIngreso() {
        Date ingreso = new RandomFecha().getFecha();
        caguano.setIngreso(ingreso);
        assertEquals(ingreso, caguano.getIngreso());
        
    }
    @Test
    void shouldReturnnumeroDeOcupantes() {
        assertEquals(numeroDeOcupantes, caguano.getOcupantes());
    }
    @Test
    void shouldChargetNumeroDeOcupantes() {
        int numeroDeOcupantes = (int)(Math.random() * 10 - 8);
        caguano.setOcupantes(numeroDeOcupantes);
        assertEquals(numeroDeOcupantes, caguano.getOcupantes());
    }
    @Test
    void shouldReturnfabricacion() {
        assertEquals(fechaDeFabricacion, caguano.getFechaDeFabricacion());
    }
    
    @Test
    void shouldChangeFabricacion() {
        Date fecha = new RandomFecha().getFecha();
        caguano.setFechaDeFabricacion(fecha);

        assertEquals(fecha, caguano.getFechaDeFabricacion());
            
        }
       // TODO Auto-generated method stub

}
        
  
