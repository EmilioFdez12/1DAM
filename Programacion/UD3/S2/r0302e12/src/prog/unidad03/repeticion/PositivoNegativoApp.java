package prog.unidad03.repeticion;

import java.util.Scanner;

public class PositivoNegativoApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("NÚMEROS POSITIVOS Y NEGATIVOS");
    int num1;

    do {
      System.out.print("Introduce un número entero (0 para terminar): ");
      num1 = Integer.parseInt(sc.nextLine());
      if (num1 == 0) {
        System.out.println("Programa Terminado");
      }

      if (num1 > 0) {
        System.out.println("El número " + num1 + " es positivo");
      } else if (num1 < 0) {
        System.out.println("El número " + num1 + " es negativo");
      }
    } while (num1 != 0);
    
    sc.close();
  }
}
