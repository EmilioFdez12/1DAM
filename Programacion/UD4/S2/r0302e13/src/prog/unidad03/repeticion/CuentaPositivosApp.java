package prog.unidad03.repeticion;

import java.util.Scanner;

public class CuentaPositivosApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("CONTADOR DE POSITIVOS");
    int num1;
    int contadorPositivos = 0;

    do {
      System.out.print("Introduce un número entero positivo o cero (negativo para terminar): ");
      num1 = Integer.parseInt(sc.nextLine());
      if (num1 >= 0) {
        contadorPositivos++;
      } else {
        System.out.println("Has introducido " + contadorPositivos + " numeros positivos");
      }
    } while (num1 > 0);

    sc.close();
  }
}