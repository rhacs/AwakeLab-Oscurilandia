package cl.awakelab.oscurilandia;

import java.util.Scanner;

import cl.awakelab.oscurilandia.controllers.Tablero;
import cl.awakelab.oscurilandia.helpers.Funciones;

public class Main {

    private static void imprimirMenu() {
        System.out.println(" 1 - Lanzar huevo");
        System.out.println(" 2 - Terminar juego");
        System.out.print("Ingrese el número correspondiente a la acción: ");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero = new Tablero(false);
        int opcion;
         
        do {
            System.out.println(tablero);
            imprimirMenu();
            opcion = Funciones.pedirNumero(scanner, 1, 2);
            
            if(opcion == 1) {
                System.out.print("Ingrese la fila (0 - " + (Tablero.FILAS - 1) + "): ");
                int fila = Funciones.pedirNumero(scanner, 0, Tablero.FILAS - 1);
                System.out.print("Ingrese la columna (0 - " + (Tablero.COLUMNAS - 1) + "): ");
                int columna = Funciones.pedirNumero(scanner, 0, Tablero.COLUMNAS - 1);
                
                tablero.arrojarHuevo(fila, columna);
            }
        } while(opcion != 2);
        
        System.out.println("Puntaje obtenido: " + tablero.getPuntaje());
        
        scanner.close();
    }

}
