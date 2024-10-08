package prog.unidad03.repeticion;

import java.util.Scanner;

public class CalculadoraDivisoresApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Introduce el numero entero para que calcule sus divisores: ");
    int numEntero = Integer.parseInt(sc.nextLine());

    for (int i = 1; i <= numEntero; i++) {
      if (numEntero % i == 0) {
        System.out.println("Los divisores son " + i);
      }

    }
    sc.close();
  }

}
