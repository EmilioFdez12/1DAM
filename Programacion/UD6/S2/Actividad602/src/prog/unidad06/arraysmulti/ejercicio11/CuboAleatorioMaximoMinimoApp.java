package prog.unidad06.arraysmulti.ejercicio11;

import java.util.Arrays;
import java.util.Random;

import prog.unidad06.arraysmulti.ejercicio06.TablaEnteraUtils;

public class CuboAleatorioMaximoMinimoApp {

  private static final int PLANOS = 5;
  private static final int FILAS = 6;
  private static final int COLUMNAS = 10;

  public static void main(String[] args) {
    Random random = new Random();

    int[][][] cubo = new int[PLANOS][FILAS][COLUMNAS];

    for (int plano = 0; plano < (PLANOS); plano++) {
      for (int fila = 0; fila < (FILAS); fila++) {
        for (int columna = 0; columna < (COLUMNAS); columna++) {
          int generedorRandom = random.nextInt(0, 1000);

          cubo[plano][fila][columna] = generedorRandom;
          // Sumamos el valor a la suma total de la fila

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
      TablaEnteraUtils.imprimeTabla(cubo[plano], 2);
      System.out.println("-----------");
    }
    
    int maximoCubo = TablaEnteraUtils.getMaximo(cubo[0]);
    int planoMaximo = 0;
    int[] posMaximo = TablaEnteraUtils.localizaMaximo(cubo[0]);

    for (int plano = 0; plano < PLANOS; plano++) {
        int maximoPlano = TablaEnteraUtils.getMaximo(cubo[plano]);
        if (maximoPlano > maximoCubo) {
            maximoCubo = maximoPlano;
            planoMaximo = plano;
            posMaximo = TablaEnteraUtils.localizaMaximo(cubo[plano]);
        }
    }

    System.out.print("El valor máximo es " + maximoCubo + " y está situado en (");
    System.out.println("Plano " + (planoMaximo + 1) + " Fila " + ((posMaximo[0]) + 1) + ", Columna " + ((posMaximo[1]) + 1) + ")");
  }
}
