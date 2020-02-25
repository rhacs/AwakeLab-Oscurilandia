package cl.awakelab.oscurilandia.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.awakelab.oscurilandia.helpers.RandomFecha;
import cl.awakelab.oscurilandia.helpers.RandomNombre;
import cl.awakelab.oscurilandia.models.Trupalla;
import cl.awakelab.oscurilandia.models.Ubicacion;

/**
 * @author Diego Quiero
 */
class TrupallaTest {

    private int armadura;
    private String manipula;
    private Trupalla patrulla;
    private Ubicacion ubicacion;
    private Date ingreso;
    private int ocupantes;
    
    
    @BeforeEach
    void setup() throws Exception {
        ubicacion = new Ubicacion(0,0);
        armadura = (int) (Math.random()*5 +1);
        manipula = new RandomNombre().getNombre();
        ingreso = new RandomFecha().getFecha();
        ocupantes = (int) (Math.random() * 20 + 1);
        
        patrulla = new Trupalla(ubicacion);
        patrulla.setArmadura(armadura);
        patrulla.setManipula(manipula);
        patrulla.setIngreso(ingreso);
        patrulla.setOcupantes(ocupantes);  
    }

    @Test
    void shouldReturnfabricacion() {
       assertEquals(armadura, patrulla.getArmadura());
    }
    
    @Test
    void shouldChangeArmadura() {
       int armadura = (int) (Math.random()*5 + 1);
       patrulla.setArmadura(armadura);
       assertEquals(armadura, patrulla.getArmadura());
    }
    
    @Test 
    void shouldReturnManipula() {
       assertEquals(manipula, patrulla.getManipula());
    }
    
    @Test
    void shouldChangeManipula() {
       String manipula = new RandomNombre().getNombre() ;
       patrulla.setManipula(manipula);
       
       assertEquals(manipula, patrulla.getManipula());
    }
    
    @Test
    void shouldReturnUbicacion() {
        assertEquals(ubicacion, patrulla.getUbicacion());
    }
    
    @Test
    void shouldChangeUbicacion() {
        Ubicacion ubicacion = new Ubicacion(1,4);
        patrulla.setUbicacion(ubicacion);
       
        assertEquals(ubicacion, patrulla.getUbicacion());
    }
    
    @Test
    void shouldReturnIngreso() {
        assertEquals(ingreso, patrulla.getIngreso());
    }
    
    @Test
    void shouldChangeIngreso() {
        Date ingreso = new RandomFecha().getFecha();
        patrulla.setIngreso(ingreso);
        
        assertEquals(ingreso, patrulla.getIngreso());
    }
    
    @Test
    void shouldReturnOcupates() {
       assertEquals(ocupantes, patrulla.getOcupantes());
        
    }
    
    @Test
    void shouldChangeOcupantes() {
       int ocupantes = (int)(Math.random() * 20 + 1);
       patrulla.setOcupantes(ocupantes); 
       
       assertEquals(ocupantes, patrulla.getOcupantes());
    }
    
    
}
