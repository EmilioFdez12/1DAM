package prog.unidad03.repeticion;

import java.util.Scanner;

public class CuentaParesApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Cuantos números pares desea introducir: ");
    int numDeseados = Integer.parseInt(sc.nextLine());

    int numPares = 0;

    // Repetir
    while (numPares < numDeseados) {
      System.out.print("Introduzca un número entero: ");
      int numero = Integer.parseInt(sc.nextLine());
      if (numero % 2 == 0) {
        numPares++;
      }

      int numRestantes = numDeseados - numPares;

      if (numRestantes == 0) {
        System.out.println("¡Ya has introducido " + numDeseados + " numeros pares!");

      } else {
        System.out.println("Te quedan " + numRestantes + " numeros pares!");
      }

    }
    sc.close();
  }
}
