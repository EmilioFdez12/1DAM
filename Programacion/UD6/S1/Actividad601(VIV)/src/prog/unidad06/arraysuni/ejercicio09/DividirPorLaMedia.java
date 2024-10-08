package prog.unidad06.arraysuni.ejercicio09;

import java.util.Random;

public class DividirPorLaMedia {

  public static void main(String[] args) {

    int[] arrayEntero = new int[50];
    Random random = new Random();

    for (int i = 0; i < arrayEntero.length; i++) {
      int numerosRandom = random.nextInt(300, 800);
      arrayEntero[i] = numerosRandom;
    }

    System.out.println("DIVIDIR POR LA MEDIA");
    System.out.println("El array entero es: ");
    for (int i = 0; i < arrayEntero.length; i++) {
      System.out.print(arrayEntero[i] + ", ");
      if (i % 10 == 0) {
        System.out.println();
      }
    }

    // Calculamos la media del array
    double sumaTotalArray = 0;
    for (double numeros : arrayEntero) {
      sumaTotalArray += numeros;
    }
    double media = sumaTotalArray / 50; // 50 es el tamaño del array

    System.out.println();
    System.out.println();
    System.out.println("El array real es:");
    for (int i = 0; i < arrayEntero.length; i++) {
      System.out.print((arrayEntero[i] / media) + ", ");
      if (i % 5 == 0) {
        System.out.println();
      }
    }
  }

}
