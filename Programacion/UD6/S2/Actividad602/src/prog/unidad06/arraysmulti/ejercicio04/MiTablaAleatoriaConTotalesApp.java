package prog.unidad06.arraysmulti.ejercicio04;

import java.util.Random;
import java.util.Scanner;

import prog.unidad06.arraysmulti.ejercicio02.TablaEnteraConTotales;

public class MiTablaAleatoriaConTotalesApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random rm = new Random();
    int filas = 4;
    int columnas = 5;

    TablaEnteraConTotales tabla20 = new TablaEnteraConTotales(filas + 1, columnas + 1);

    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        int generadorRandom = rm.nextInt(100, 999);
        tabla20.setCasilla(i, j, generadorRandom);
      }
    }

    // Setting total for each row
    tabla20.setCasilla(0, columnas, tabla20.getTotalFila(0));
    tabla20.setCasilla(1, columnas, tabla20.getTotalFila(1));
    tabla20.setCasilla(2, columnas, tabla20.getTotalFila(2));
    tabla20.setCasilla(3, columnas, tabla20.getTotalFila(3));

    // Setting total for each column
    tabla20.setCasilla(filas, 0, tabla20.getTotalColumna(0));
    tabla20.setCasilla(filas, 1, tabla20.getTotalColumna(1));
    tabla20.setCasilla(filas, 2, tabla20.getTotalColumna(2));
    tabla20.setCasilla(filas, 3, tabla20.getTotalColumna(3));
    tabla20.setCasilla(filas, 4, tabla20.getTotalColumna(4));

    tabla20.setCasilla(4, 5, tabla20.getTotalColumna(5));

    // Printing the table with totals
    for (int i = 0; i <= filas; i++) {
      for (int j = 0; j <= columnas; j++) {
        System.out.print(tabla20.getCasilla(i, j) + "\t");
      }
      System.out.println();
    }
  }

}
