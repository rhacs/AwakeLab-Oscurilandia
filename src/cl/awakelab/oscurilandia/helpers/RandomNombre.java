package cl.awakelab.oscurilandia.helpers;

/**
 * Genera un nombre completo (Nombre + Apellido) aleatorio
 */
public class RandomNombre {

    // Constants -------------------------------------------------------------------------------
    
    /** Listado de Nombres */
    private final String[] NOMBRES = {"Isabella", "Sofia", "Agustina", "Emilia", "Josefa",
            "Isidora", "Emma", "Trinidad", "Florencia", "Julieta", "Maite", "Maria", "Amanda",
            "Antonella", "Martina", "Valentina", "Catalina", "Leonor", "Renata", "Mia", "Mateo",
            "Agustin", "Santiago", "Tomas", "Benjamin", "Lucas", "Gaspar", "Alonso", "Vicente",
            "Maximiliano", "Joaquin", "Matias", "Martin", "Jose", "Luciano", "Facundo", "Julian",
            "Gabriel", "Maximo", "Juan"};
    
    /** Listado de Apellidos */
    private final String[] APELLIDOS = {"Gonzalez", "Munoz", "Rojas", "Diaz", "Perez", "Soto",
            "Contreras", "Silva", "Martinez", "Sepulveda", "Morales", "Rodriguez", "Lopez",
            "Fuentes", "Hernandez", "Torres", "Araya", "Flores", "Espinoza", "Valenzuela",
            "Castillo", "Ramirez", "Reyes", "Gutierrez", "Castro", "Vargas", "Alvarez", "Vasquez",
            "Tapia", "Fernandez", "Sanchez", "Carrasco", "Gomez", "Cortes", "Herrera", "Nunez",
            "Jara", "Vergara", "Rivera", "Figueroa"};
    
    // Attributes ------------------------------------------------------------------------------
    
    private String nombre;
    
    // Constructors ----------------------------------------------------------------------------
    
    /**
     * Constructor
     * Genera el nombre completo de forma aleatoria
     */
    public RandomNombre() {
        this.nombre = NOMBRES[(int) (Math.random() * NOMBRES.length)] + " " +
                APELLIDOS[(int) (Math.random() * APELLIDOS.length)];
    }
    
    // Getters ---------------------------------------------------------------------------------
    
    /**
     * Devuelve el nombre completo generado
     * @return nombre + apellido
     */
    public String getNombre() {
        return this.nombre;
    }
    
    // Inheritances ----------------------------------------------------------------------------
    
    /**
     * Muestra el contenido del objeto
     * @return contenido
     */
    @Override
    public String toString() {
        return "RandomNombre(nombre: '" + this.getNombre() + "')";
    }

}
