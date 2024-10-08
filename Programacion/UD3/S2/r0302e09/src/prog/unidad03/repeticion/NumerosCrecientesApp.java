package prog.unidad03.repeticion;

import java.util.Scanner;

public class NumerosCrecientesApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("NÚMEROS CRECIENTES");
    System.out.print("Introduce un número entero: ");
    int numero1 = Integer.parseInt(sc.nextLine());

    int numeroActual;

    do {
      System.out.print("Introduce ahora un número mayor que " + numero1 + ": ");
      numeroActual = Integer.parseInt(sc.nextLine());

      if (numeroActual <= numero1) {
        System.out.println(
            "El número " + numeroActual + " no es mayor que el número anterior " + numero1 + ". Terminando" + "");
      }
      numero1 = numeroActual;

    } while (numeroActual > numero1);

    sc.close();
  }

}
