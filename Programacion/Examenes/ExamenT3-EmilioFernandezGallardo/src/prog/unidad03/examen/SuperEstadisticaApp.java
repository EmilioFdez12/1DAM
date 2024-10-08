package prog.unidad03.examen;

import java.util.Scanner;

public class SuperEstadisticaApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // iniciamos las variables
    int numero = 1;
    int contador = 0;
    int contadorimpares = 0;
    double suma = 0;

    // Creamos un ciclo mientras el numero sea diferenta a 0
    // y un try para controlar las excepciones.
    do {
      try {
        System.out.print("Introduce un numero entero (0 para salir): ");
        numero = Integer.parseInt(sc.nextLine());

        // contador de numeros
        if (numero != 0) {
          contador++;
          // Contador de impares, y cada vez que metes uno te avisa, y lleva la cuenta.

          // pongo dos if, el primero para detectar si es impar, en el caso de que lo sea
          // meto el intervalo y las excepciones
          if (numero % 2 != 0)
            if (numero <= -11 || numero > 20 || numero == 3 || numero == -1) {
              contadorimpares++;
              System.out.println("El numero " + numero + " es impar");
              System.out.println("Llevas " + contadorimpares + " numeros impares");
              suma += numero;
            }

        }
        // Si nos da error saldra este texto
      } catch (NumberFormatException e) {
        System.out.println("ERROR. Introduzca un numero entero por favor");
      }

    } while (numero != 0);

    // cerramos bucle, y abrimos un if para dar todos los datos restantes
    // hacemos la media
    if (contador > 0) {
      double media = suma / contadorimpares;
      System.out.println("La cantidad de numeros impares ingresados es: " + contadorimpares);
      System.out.println("La media de los numeros impares es: " + media);
      System.out.println("Programa Terminado");
    } else {
      System.out.println("No se ingresaron números.");
    }

    sc.close();
  }
}
