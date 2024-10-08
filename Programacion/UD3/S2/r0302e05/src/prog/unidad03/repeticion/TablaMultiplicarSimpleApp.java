package prog.unidad03.repeticion;

import java.util.Scanner;

public class TablaMultiplicarSimpleApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("De que numero entero quieres mostrar su tabla de multiplicar: ");
    int numEntero = Integer.parseInt(sc.nextLine());

    System.out.println("Tabla del " + numEntero);

    for (int i = 1; i <= 10; i++) {
      int multiplicacion = (numEntero * i);

      System.out.println(numEntero + " X " + i + " = " + multiplicacion);
    }
    sc.close();
  }

}
