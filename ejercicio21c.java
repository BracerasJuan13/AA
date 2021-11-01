/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6;

/**
 *
 * @author Juan Braceras
 */
import java.util.Collections;
import java.util.Vector;
import utiles.TecladoIn;

class ejercicio21c {

    public static void main(String args[]) {

        // Insertamos el numero del cual queremos los factores 
        System.out.println("Ingrese n: ");
        int n = TecladoIn.readInt();
        System.out.println("El factor primo mas grande sera:" + factorPrimo(n, 2));

// iteramos de 2 a la mitad del número ya que no puede haber un factor mayor que la mitad del número.
        //System.out.println("Los factores primos seran los siguientes:");
//        for (int i = 2; i <= n / 2; i++) {
//            // Verificamos si el numero es factor
//            if (n % i == 0) {
//                // Verificamos si el factor es primo
//                if (esPrimo(i) == true) {
//                    // Es factor y es primo.
//                    System.out.println(+i);
//                }
//            }
//        }
    }

    static int factorPrimo(int n, int factor) {
        int resultado;
        if (n == factor) {
            resultado = factor;
        } else if (n % factor == 0 && esPrimo(factor)) {// Verificamos si es factor y primo.
        // Si lo es llamamos a la recursividad con el resto de dividir al numero por el factor primo.
            resultado = factorPrimo(n / factor, factor);
        } else {
            // Si no lo es llamamos a la recursividad con el numero y el siguiente posible factor primo.
            resultado = factorPrimo(n, factor + 1);
        }
        return resultado;
    }

    // Verifica si x es primo
    static boolean esPrimo(int x) {
        boolean result = true;
        if (x <= 1) {
            result = false;
        }
        // Si existe un divisor ademas del 1 y si mismo no sera.
        for (int i = 2; i <= x / 2; i++) {
            if (x % i == 0) {
                result = false;
            }
        }
        return result;
    }

}
