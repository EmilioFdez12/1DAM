package prog.unidad03.repeticion;

import java.util.Scanner;

public class SumaParesIntervaloApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num1, num2;
    int suma = 0;

    do {
      System.out.print("Introduce el número de comienzo del intervalo: ");
      num1 = Integer.parseInt(sc.nextLine());
      System.out.print("Introduce el número de fin del intervalo: ");
      num2 = Integer.parseInt(sc.nextLine());

      if (num1 > num2) {
        System.out.println("Error. El número de inicio (" + num1 + ") debe ser menor o igual al de final " + "(" + num2
            + "). Inténtelo de nuevo.");
      }
    } while (num1 >= num2);

    for (int i = num1; i <= num2; i++) {

      // Es el mismo que el anterior pero añado la condicion de que el resto al
      // dividirlo entre 2 de 0.
      if (i % 2 == 0) {
        suma += i;
      }

    }
    System.out.println("La suma de los números en el intervalo es: " + suma);
    sc.close();
  }

}
