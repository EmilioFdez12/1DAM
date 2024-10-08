package prog.unidad03.excepciones;

import java.util.Scanner;

public class NumeroSeguroCansinoApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("INTRODUCCIÓN DE NÚMERO SEGURA CANSINA");
    // bandera
    boolean numeroValido = false;

    int numero = 0;

    // Ciclo mientras el número no sea válido
    do {
      // Capturamos excepciones dentro del bloque siguiente
      try {
        // Intentamos leer el número
        System.out.print("Introduce un número entero: ");
        numero = Integer.parseInt(sc.nextLine());
        // Si llega hasta aqui, es que lo introducido se ha podido convertir a número
        // Modificamos la bandera para indicar que ya tenemos número válido
        numeroValido = true;
      } catch (NumberFormatException e) {
        System.out.println("El dato introducido no es un número válido");
      }
    } while (!numeroValido);

    System.out.println("El número introducido es " + numero);

    sc.close();
  }

}
