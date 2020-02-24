package cl.awakelab.oscurilandia.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.awakelab.oscurilandia.helpers.RandomFecha;

class KromiTest {

     private Date fabricacion;
     private String marca;
     private Kromi micro;
     private Ubicacion ubicacion;
     private Date ingreso;
     private int ocupantes;
     
     @BeforeEach
     void setup() throws Exception {
        ubicacion = new Ubicacion(0,0);
        marca = "Chevrolet";
        fabricacion = new RandomFecha().getFecha();
        ingreso = new RandomFecha().getFecha();
        ocupantes = (int) (Math.random() * 20 + 1);
        micro = new Kromi(ubicacion);
        micro.setMarca(marca);
        micro.setFabricacion(fabricacion);
        micro.setIngreso(ingreso);
        micro.setOcupantes(ocupantes);
     }
     
     
     @Test
     void shouldReturnfabricacion() {
        assertEquals(fabricacion, micro.getFabricacion());
     }
     
     @Test
     void shouldChangeFabricacion() {
        Date fecha = new RandomFecha().getFecha();
        micro.setFabricacion(fecha);
        assertEquals(fecha, micro.getFabricacion());
     }
     
     @Test 
     void shouldReturnMarca() {
        assertEquals(marca, micro.getMarca());
     }
     
     @Test
     void shouldChangeMarca() {
        String marca = "Dodge";
        micro.setMarca(marca);
        
        assertEquals(marca, micro.getMarca());
     }
     
     @Test
     void shouldReturnUbicacion() {
         assertEquals(ubicacion, micro.getUbicacion());
     }
     
     @Test
     void shouldChangeUbicacion() {
         Ubicacion ubicacion = new Ubicacion(1,4);
         micro.setUbicacion(ubicacion);
        
         assertEquals(ubicacion,micro.getUbicacion());
     }
     
     @Test
     void shouldReturnIngreso() {
         assertEquals(ingreso, micro.getIngreso());
     }
     
     @Test
     void shouldChangeIngreso() {
         Date ingreso = new RandomFecha().getFecha();
         micro.setIngreso(ingreso);
         
         assertEquals(ingreso, micro.getIngreso());
     }
     
     @Test
     void shouldReturnOcupates() {
        assertEquals(ocupantes, micro.getOcupantes());
         
     }
     
     @Test
     void shouldChangeOcupantes() {
        int ocupantes = (int)(Math.random() * 20 + 1);
        micro.setOcupantes(ocupantes); 
        
        assertEquals(ocupantes, micro.getOcupantes());
     }
     
     
}
