package cl.awakelab.oscurilandia.helpers;

import java.util.Scanner;

public class Funciones {

    public static int pedirNumero(Scanner scanner) {
        int entero;
        
        while(!scanner.hasNextInt()) {
            System.err.print("[!] Por favor, ingrese un número válido: ");
            scanner.next();
        }
        
        entero = scanner.nextInt();
        
        if(scanner.hasNextLine())
            scanner.nextLine();

        return entero;
    }
    
    public static int pedirNumero(Scanner scanner, int limiteInferior) {
        int entero;
        
        do {
            entero = pedirNumero(scanner);
            
            if(entero < limiteInferior)
                System.err.print("[!] Por favor, ingrese un número mayor o igual a " + 
                        limiteInferior + ": ");
        } while(entero < limiteInferior);
        
        return entero;
    }
    
    public static int pedirNumero(Scanner scanner, int limiteInferior, int limiteSuperior) {
        int entero;
        
        do {
            entero = pedirNumero(scanner);
            
            if(entero < limiteInferior || entero > limiteSuperior)
                System.err.print("[!] Por favor, ingrese un número entre " + limiteInferior + 
                        " y " + limiteSuperior + ": ");
        } while(entero < limiteInferior || entero > limiteSuperior);
        
        return entero;
    }
    
}
