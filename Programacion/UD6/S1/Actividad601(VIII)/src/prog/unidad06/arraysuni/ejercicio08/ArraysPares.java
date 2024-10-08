package prog.unidad06.arraysuni.ejercicio08;

import java.util.Scanner;

public class ArraysPares {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] arrayPares = new int[20];

    for (int i = 0; i < arrayPares.length; i++) {
      arrayPares[i] = 2 * (i + 1);
    }

    for (int i = 0; i < arrayPares.length; i++) {
      System.out.println(arrayPares[i]);
    }
  }
  
}
