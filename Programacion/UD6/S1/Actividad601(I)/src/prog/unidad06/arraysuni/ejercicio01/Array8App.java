package prog.unidad06.arraysuni.ejercicio01;

import java.util.Iterator;
import java.util.Scanner;

public class Array8App {

  private static final int NUMEROS = 8;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    double[] numeros = new double[NUMEROS];

    for (int i = 0; i < numeros.length; i++) {
      System.out.print("Introduce el número " + (i + 1) + ": ");
      numeros[i] = Double.parseDouble(sc.nextLine());
    }

    // Suma total
    double suma = 0;
    for (double numero : numeros) {
      suma += numero;
    }
    
    // Calculamos la suma de los números mayores a 36
    double sumaMayores36 = 0;
    for (double numero : numeros) {
      if(numero > 36) {
        sumaMayores36 += numero;
      }
    }
    
    double contadorMayores50 = 0;
    for(double numero : numeros) {
      if( numero > 50 ) {
        contadorMayores50++;
      }
    }
    
    double contadorEntre10Y30 = 0;
    double sumaNum = 0;
    double media = 0;
    for(double numero : numeros) {
      if( numero > 10 && numero < 30 ) {
        contadorEntre10Y30++;
        
        sumaNum += numero;
        
       media = sumaNum / contadorEntre10Y30;
       
      }
    }
    
    System.out.println("La suma total vale: " + suma);
    System.out.println("La suma de los valores mayores que 36 vale: " + sumaMayores36);
    System.out.println("Hay " + contadorMayores50 + " numeros mayores que 50");
    System.out.println("La media de los numeros que estan entre 10 y 30 es: " + media);      
  }
}
