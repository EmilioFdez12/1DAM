package prog.unidad06.arraysmulti.ejercicio01;

public class MiPrimerArrayBidimensional {

  public static void main(String[] args) {

    int[][] arrayPrueba = new int[3][6];

    // Fila 1
    arrayPrueba[0][0] = 35;
    arrayPrueba[0][2] = 64;
    arrayPrueba[0][3] = 69;
    arrayPrueba[0][5] = 93;

    // Fila 2
    arrayPrueba[1][0] = 12;
    arrayPrueba[1][4] = 92;
    arrayPrueba[1][5] = 97;

    // Fila 3
    arrayPrueba[2][0] = 13;
    arrayPrueba[2][2] = 33;
    arrayPrueba[2][4] = 52;

    System.out.println("MI PRIMER ARRAY BIDIMENSIONAL");
    System.out.println("------------------------------------------");
    // Imprimir por pantalla el array
    for (int i = 0; i < arrayPrueba.length; i++) {
      for (int j = 0; j < arrayPrueba[i].length; j++) {
        System.out.print(arrayPrueba[i][j] + "\t");
      }
      System.out.println();
    }
    System.out.println("------------------------------------------");
  }
}
