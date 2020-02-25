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
        Tablero tablero = new Tablero(true);
        int opcion;
        
        do {
            System.out.println(tablero);
            imprimirMenu();
            opcion = Funciones.pedirNumero(scanner, 1, 2);
            
        } while(opcion != 2);
        
        scanner.close();
    }

}
