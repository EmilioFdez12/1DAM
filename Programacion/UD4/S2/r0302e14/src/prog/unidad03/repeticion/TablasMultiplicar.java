package prog.unidad03.repeticion;

import java.util.Scanner;

public class TablasMultiplicar {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    for (int j = 1; j <= 10; j++) {
      System.out.println("");
      System.out.println("Tabla del " + j);
      System.out.println("------------");

      for (int i = 1; i <= 10; i++) {
        int multiplicacion = (j * i);

        System.out.println(j + " X " + i + " = " + multiplicacion);
      }
    }
    sc.close();
  }

}
