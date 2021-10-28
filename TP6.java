/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import utiles.*;

/**
 *
 * @author Juan Braceras
 */
public class TP6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String nombreArchivoSalida = "src/TP6/Resultados Fibonacci.txt";
        int muestra = 50;
        long promedioR = 0, promedioI = 0;
        try {
            FileWriter escritorArchivo = new FileWriter(nombreArchivoSalida);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);
            for (int i = 0; i < muestra; i++) {
                Random generador = new Random();
                int num = generador.nextInt(50);
                int numF;
                //int num=2000;
                bufferEscritura.write("n:" + num);
                long inicio = System.nanoTime(); // Tomamos la hora del sistema en nanosegundos
                numF = fibonacciRecursivo(num);
                long fin = System.nanoTime();
                long tTotal = fin - inicio;
                promedioR = promedioR + tTotal;
                bufferEscritura.write("         Fib(n)Recursion:" + numF + "           Tiempo Recursivo:" + tTotal);
                // System.out.println("Fibonacci recursivo n= " + num + ": " + numF + ". Demoró " + tTotal + "nanosegundos");
                inicio = System.nanoTime(); // Tomamos la hora del sistema en nanosegundos
                numF = fibonaci(num);
                fin = System.nanoTime();
                tTotal = fin - inicio;
                promedioI = promedioI + tTotal;
                bufferEscritura.write("         Fib(n)Iterativo:" + numF + "           Tiempo Iterativo:" + tTotal);
                //System.out.println("Fibonacci iterativo n= " + num + ": " + numF + ". Demoró " + (fin - inicio) + "nanosegundos");
                bufferEscritura.newLine();
                bufferEscritura.newLine();
            }
            bufferEscritura.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "ERROR: Archivo inexistente");
        } catch (IOException ex) {
            System.err.println("ERROR: No se puede leer/escribir el archivo.");
        }
        promedioR = promedioR / muestra;
        promedioI = promedioI / muestra;
        System.out.println("El tiempo para realizar Fibonaci Recursivo, en promedio para una muestra:" + muestra + ", es de " + promedioR);
        System.out.println("El tiempo para realizar Fibonaci Iterativo, en promedio para una muestra:" + muestra + ", es de " + promedioI);

    }

    public static int fibonaci(int n) {
        int aux1 = 0, aux2 = 1;
        if (n == 0) {
            aux2 = 0;
        } else {
            for (int j = 1; j < n; j++) {
                int aux;
                aux = aux1 + aux2;
                aux1 = aux2;
                aux2 = aux;
            }
        }
        return aux2;
    }

    public static int fibonacciRecursivo(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        }

    }
}
