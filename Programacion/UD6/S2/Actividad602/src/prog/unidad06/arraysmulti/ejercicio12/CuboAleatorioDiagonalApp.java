package prog.unidad06.arraysmulti.ejercicio12;

import java.util.Random;

import prog.unidad06.arraysmulti.ejercicio06.TablaEnteraUtils;

public class CuboAleatorioDiagonalApp {

  private static final int PLANOS = 10;
  private static final int FILAS = 10;
  private static final int COLUMNAS = 10;

  public static void main(String[] args) {
    Random random = new Random();

    int[][][] cubo = new int[PLANOS][FILAS][COLUMNAS];

    for (int i = 0; i < PLANOS; i++) {
      for (int j = 0; j < FILAS; j++) {
        for (int k = 0; k < COLUMNAS; k++) {
          int numeroRandom = random.nextInt(200, 300);
          cubo[i][j][k] = numeroRandom;
        }
      }
    }

    for (int i = 0; i < PLANOS; i++) {
      System.out.println("PLANO " + (i + 1));
      System.out.println("------------------------------------------------");
      TablaEnteraUtils.imprimeTabla(cubo[i], 2);
      System.out.println("------------------------------------------------");
      System.out.println();
    }

    int minimo = cubo[0][0][0];
    int maximo = cubo[0][0][0];
    double suma = 0;

    System.out.print("Los elementos que están en la diagonal son: ");

    int[][][] arrayDiagonal = new int[PLANOS][FILAS][COLUMNAS];

    for (int i = 0; i < PLANOS; i++) {
      for (int j = 0; j < FILAS; j++) {
        for (int k = 0; k < COLUMNAS; k++) {
          if (i == j && i == k) {
            // Imprimir elemento diagonal
            System.out.print(cubo[i][j][k] + " ");
            arrayDiagonal[i][j][k] = cubo[i][j][k];

            if (cubo[i][j][k] < minimo) {
              // Actualizar el mínimo
              minimo = cubo[i][j][k];
            }

            if (cubo[i][j][k] > maximo) {
              // Actualizar el máximo
              maximo = cubo[i][j][k];
            }

            // Agregar a la suma para calcular la media
            suma += cubo[i][j][k];
          }
        }
      }
    }

    System.out.println();
    System.out.println("El máximo de los elementos de la diagonal es " + maximo + ", el mínimo es " + minimo
        + ", y la media de todos los elementos de la diagonal es " + (suma / PLANOS));
  }
}
