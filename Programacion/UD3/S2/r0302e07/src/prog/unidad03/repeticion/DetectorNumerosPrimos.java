package prog.unidad03.repeticion;

import java.util.Scanner;

public class DetectorNumerosPrimos {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Introduce un número entero mayor que para ver si es primo o no: ");
    int numero = Integer.parseInt(sc.nextLine());

    if (numero > 1) {
      // Contador de número de divisores
      int divisores = 0;

      // Para cada número desde 2 hasta el número objetivo
      for (int i = 2; i < numero; i++) {
        // Si este número divide al objetivo
        if (numero % i == 0) {
          // Sumamos divisor
          divisores++;
        }
      }

      // Si se ha encontrado algún divisor
      if (divisores > 0) {
        // El número NO es primo
        System.out.println("El número " + numero + " NO es primo");
      } else {
        // Si no hay ningún divisor, SI es primo
        System.out.println("El número " + numero + " es primo");
      }
    } else {
      // Si el número objetivo no era mayor que 1 muestra un mensaje de error
      System.out.println("ERROR: Debes introducir un número mayor que 1");
    }
    sc.close();
  }

}
