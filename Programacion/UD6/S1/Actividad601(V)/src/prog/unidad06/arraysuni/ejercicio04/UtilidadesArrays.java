package prog.unidad06.arraysuni.ejercicio04;

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

  public static int getMinimoArrayEntero(int[] array) {

    if (array == null || array.length == 0) {
      throw new IllegalArgumentException("Array vacío o nulo");
    }

    int numeroMinimo = array[0];
    for (int numerosArray : array) {
      if (numerosArray < numeroMinimo) {
        numeroMinimo = numerosArray;
      }
    }

    return numeroMinimo;
  }

  public static int getMaximoArrayEntero(int[] array) {
    if (array == null || array.length == 0) {
      throw new IllegalArgumentException("Array vacío o nulo");
    }
    int numeroMaximo = array[0];
    for (int numerosArray : array) {
      if (numerosArray > numeroMaximo) {
        numeroMaximo = numerosArray;
      }
    }
    return numeroMaximo;
  }

  public static int enteroApareceEnArrayEntero(int[] array, int valor) {
    int contadorValor = 0;
    for (int numeroEntero : array) {
      if (numeroEntero == valor) {
        contadorValor++;
      }
    }
    return contadorValor;
  }
}
