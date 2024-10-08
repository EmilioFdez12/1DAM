package prog.unidad03.repeticion;

import java.util.Scanner;

public class CalculaFactorialApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("CALCULO DE FACTORIAL");
    System.out.print("Introduce un número entero mayor que cero para calcular su factorial: ");
    int numDeseado = Integer.parseInt(sc.nextLine());

    long factorial = 1;
    for (long i = 1; i <= numDeseado; i++) {
      factorial *= i;
    }
    System.out.println("El factorial de " + numDeseado + " es " + factorial);
    
    sc.close();
  }
}
