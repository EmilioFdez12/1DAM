package prog.unidad06.arraysmulti.ejercicio10;

import java.util.Random;

import prog.unidad06.arraysmulti.ejercicio06.TablaEnteraUtils;

public class CuboAleatorioConSumasTotalesApp {

  private static final int PLANOS = 5;
  private static final int FILAS = 4;
  private static final int COLUMNAS = 3;

  public static void main(String[] args) {
    Random random = new Random();

    int[][][] cubo = new int[PLANOS][FILAS][COLUMNAS];

    for (int plano = 0; plano < (PLANOS - 1); plano++) {
      for (int fila = 0; fila < (FILAS - 1); fila++) {
        for (int columna = 0; columna < (COLUMNAS - 1); columna++) {
          int generedorRandom = random.nextInt(100, 999);

          cubo[plano][fila][columna] = generedorRandom;
          // Sumamos el valor a la suma total de la fila
          cubo[plano][fila][COLUMNAS - 1] += generedorRandom;
          // Ahora a la suma total de la columna
          cubo[plano][FILAS - 1][columna] += generedorRandom;
          // AL total del plano
          cubo[plano][FILAS - 1][COLUMNAS - 1] += generedorRandom;
          // Al total del segmento
          cubo[PLANOS - 1][fila][columna] += generedorRandom;
          // Al total de la fila del segmento
          cubo[PLANOS - 1][fila][COLUMNAS - 1] += generedorRandom;
          // Al total de la columna del segmento
          cubo[PLANOS - 1][FILAS - 1][columna] += generedorRandom;
          // Y por último al total definitivo
          cubo[PLANOS - 1][FILAS - 1][COLUMNAS - 1] += generedorRandom;
        }
      }
    }

    // Imprimimos los planos
    for (int plano = 0; plano < PLANOS; plano++) {
      // Titulo del plano
      System.out.println("-----------");
      System.out.println("Plano " + (plano + 1));
      System.out.println("-----------");
      // Usamos TablaEnteraUtils para imprimir el plano
      TablaEnteraUtils.imprimeTabla(cubo[plano], 1);
      System.out.println("-----------");
    }
  }

}
