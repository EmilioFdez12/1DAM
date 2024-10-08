package prog.unidad03.excepciones;

import java.util.Scanner;

public class MayorMenorMediaExcepcionesApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    boolean valorValido = false;
    int numDeseados = 0;

    do {
      try {
        System.out.print("Cuantos numeros desea introducir: ");
        numDeseados = Integer.parseInt(sc.nextLine());
        valorValido = true;
      } catch (NumberFormatException e) {
        System.out.println("El valor introducido no es un número entero correcto. Inténtelo de nuevo");
      }
    } while (!valorValido);

    if (numDeseados > 0) {

      valorValido = false;
      double primer = 0;

      do {
        try {

          System.out.print("Introduce el numero 1: ");
          primer = Double.parseDouble(sc.nextLine());
          valorValido = true;
        } catch (NumberFormatException e) {
          System.out.println("El valor introducido no es un número entero correcto. Inténtelo de nuevo");
        }
      } while (!valorValido);

      double mayor = primer;
      double menor = primer;
      double suma = primer;

      for (int i = 2; i <= numDeseados; i++) {

        valorValido = false;
        double numero = 0;
        do {
          try {
            System.out.print("Introduce el numero " + i + ": ");
            numero = Double.parseDouble(sc.nextLine());
            valorValido = true;
          } catch (NumberFormatException e) {
            System.out.println("El valor introducido no es un número entero correcto. Inténtelo de nuevo");
          }
        } while (!valorValido);

        if (numero > mayor) {
          mayor = numero;
        }

        if (numero < menor) {
          menor = numero;
        }

        suma += numero;

        double media = (suma / numDeseados);

        System.out.println("El número mayor es " + mayor);
        System.out.println("El número menor es " + menor);
        System.out.println("La media es " + media);
      }

    } else {
      System.out.println("El numero debe ser al menos 1 no puede ser 0 ni negativo");
    }
    sc.close();
  }

}

//el mayor es el primero mayor=primero
