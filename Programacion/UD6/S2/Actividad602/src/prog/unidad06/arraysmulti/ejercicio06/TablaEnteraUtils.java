package prog.unidad06.arraysmulti.ejercicio06;

import java.util.Random;

public class TablaEnteraUtils {

  public TablaEnteraUtils() {

  }

  /**
   * Genera una tabla de las dimensiones especificadas rellena con los numeros
   * aleatorios entre un rango dado
   * 
   * @param filas       Número de filas de la nueva tabla. Debe ser mayor a cero
   * @param columnas    Número de columnas de la nueva tabla. Debe ser mayor a
   *                    cero
   * @param inicioRango Valor de inicio del rango del que se extraerán los números
   *                    aleatorios, incluido
   * @param finRango    Valor de fin del rango anterior, incluido. Debe ser mayor
   *                    o igual que inicioRango
   * @return Array de dos dimensiones con la tabla
   * @throws IllegalArgumentException - Si filas o columnas es menor que 1 o si
   *                                  inicioRango es mayor que finRango
   */
  public static int[][] nuevaTablaAleatoria(int filas, int columnas, int inicioRango, int finRango) {
    // Condicionales
    if (filas < 1 || columnas < 1) {
      throw new IllegalArgumentException();
    }
    if (inicioRango > finRango) {
      throw new IllegalArgumentException();
    }

    // Creamos la tabla
    Random random = new Random();
    int[][] arrayAleatorio = new int[filas][columnas];
    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        int generadorRandom = random.nextInt(inicioRango, finRango);
        arrayAleatorio[i][j] = generadorRandom;
      }
    }
    return arrayAleatorio;
  }

  public static int getMaximo(int[][] tabla) {
    if (tabla == null) {
      throw new IllegalArgumentException();
    }
    int valorMaximo = tabla[0][0];

    for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        int valorActual = tabla[i][j];

        // Conseguimos el máximo
        if (valorMaximo < valorActual) {
          valorMaximo = valorActual;
        }
      }
    }
    return valorMaximo;

  }

  /**
   * Localiza la posición del valor máximo contenido en una tabla
   * 
   * @param tabla Tabla donde localizar el máximo. No debe ser vacía o null
   * @return array de dos posiciones. La primera es la fila en la que está
   *         localizado el máximo dentro de la tabla y la segunda es la columna.
   *         Están basadas en cero. En caso de que el elemento máximo aparezca
   *         varias veces se devuelve la posición de la primera aparición en orden
   *         creciente de filas y dentro de la misma fila por columnas
   * @throws IllegalArgumentException - Si la tabla está vacía o es null
   */
  public static int[] localizaMaximo(int[][] tabla) {
    if (tabla == null) {
      throw new IllegalArgumentException();
    }
    int valorMaximo = tabla[0][0];
    int posicionFila = 0;
    int posicionColumna = 0;

    for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        int valorActual = tabla[i][j];

        // Conseguimos el máximo
        if (valorMaximo < valorActual) {
          posicionFila = i;
          posicionColumna = j;
          valorMaximo = valorActual;
        }
      }
    }
    return new int[] { posicionFila, posicionColumna };
  }

  public static int getMinimo(int[][] tabla) {
    if (tabla == null) {
      throw new IllegalArgumentException();
    }
    int valorMinimo = tabla[0][0];

    for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        int valorActual = tabla[i][j];

        // Conseguimos el máximo
        if (valorMinimo > valorActual) {
          valorMinimo = valorActual;
        }
      }
    }
    return valorMinimo;

  }

  public static int[] localizaMinimo(int[][] tabla) {
    if (tabla == null) {
      throw new IllegalArgumentException();
    }
    int valorMinimo = tabla[0][0];
    int posicionFila = 0;
    int posicionColumna = 0;

    for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        int valorActual = tabla[i][j];

        // Conseguimos el máximo
        if (valorMinimo > valorActual) {
          posicionFila = i;
          posicionColumna = j;
          valorMinimo = valorActual;
        }
      }
    }
    return new int[] { posicionFila, posicionColumna };
  }

  /**
   * Imprime una tabla entera cualquiera por pantalla
   * 
   * @param tabla      Tabla a imprimir. No debe ser null o vacía
   * @param separacion Cantidad de espacios que separan los números. Debe ser
   *                   superior o igual a 1
   * @throws IllegalArgumentException - Si la tabla no es correcta o la separacion
   *                                  es menor a 1
   */
  public static void imprimeTabla(int[][] tabla, int separacion) {
    if (separacion < 1) {
      throw new IllegalArgumentException();
    }

    for (int i = 0; i < tabla.length; i++) {
      for (int j = 0; j < tabla[i].length; j++) {
        // Imprimir el valor seguido de la separación
        System.out.print(tabla[i][j]);

        // Imprimir espacios de separación
        for (int k = 0; k < separacion; k++) {
          System.out.print(" ");
        }
      }
      System.out.println(); // Nueva línea después de cada fila
    }
  }

 //Prueba para imprimir localizacion etc.
  public static void main(String[] args) {
    int[][] tabla = { {5,43,6,9},{ 16, 17, 18, 19, 20 } };
    
   int minimo = TablaEnteraUtils.getMinimo(tabla);
   System.out.println(minimo);

    TablaEnteraUtils.imprimeTabla(tabla, 1);    
    int[] posMaximo = TablaEnteraUtils.localizaMaximo(tabla);
    System.out.println("Posición del máximo: Fila " + posMaximo[0] + ", Columna " + posMaximo[1]);
  }
}
