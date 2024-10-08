package prog.unidad06.arraysuni.ejercicio02;

import java.util.Random;

public class UtilidadesArrays {

  public static int[] generaArrayEnteroAleatorio(int longitud, int valorMinimo, int valorMaximo) {

    if (longitud <= 0 || valorMaximo <= valorMinimo) {
      throw new IllegalArgumentException();
    }

    int[] arrayAleatorio = new int[longitud];

    Random random = new Random();
    for (int i = 0; i < longitud; i++) {
      int numeroRandom = random.nextInt(valorMinimo, valorMaximo);
      arrayAleatorio[i] = numeroRandom;
    }
    return arrayAleatorio;
  }
}
