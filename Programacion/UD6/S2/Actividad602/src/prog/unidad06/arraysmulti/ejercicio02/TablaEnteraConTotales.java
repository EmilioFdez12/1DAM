package prog.unidad06.arraysmulti.ejercicio02;

public class TablaEnteraConTotales {

  private int filas;
  private int columnas;
  private int[][] casilla;

  public TablaEnteraConTotales(int filas, int columnas) {
    if (filas < 1 || columnas < 1) {
      throw new IllegalArgumentException();
    }
    this.filas = filas;
    this.columnas = columnas;
    // Array tabla
    this.casilla = new int[filas][columnas];
  }
/**
 * 
 * @param fila Fila de la tabla
 * @param columna - Columna de la tabla
 * @return El valor en esa "coordenada"
 */
  public int getCasilla(int fila, int columna) {
    if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
      throw new ArrayIndexOutOfBoundsException();
    }
    
    return casilla[fila][columna];
  }

  /**
   * Da el valor a la casilla que elijas
   * @param fila Fila de la tabla
   * @param columna Columna de la tabla
   * @param valor Valor de la casilla correspondiente a esas coordenadas
   */
  public void setCasilla(int fila, int columna, int valor) {
    if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
      throw new ArrayIndexOutOfBoundsException();
    }
    casilla[fila][columna] = valor;
  }

  /**
   * Suma el total de la fila que elijas
   * @param fila Fila
   * @return La suma de todas las casillas de una fila
   */
  public int getTotalFila(int fila) {
    int suma = 0;
    for (int i = 0; i < columnas; i++) {
        suma += casilla[fila][i];
    }
    return suma;
}
/**
 * 
 * @param columna
 * @return La suma de todas las casillas de una columna
 */
  public int getTotalColumna(int columna) {
    int suma = 0;
    for (int i = 0; i < filas;i++) {
      suma += casilla[i][columna];
    }
    return suma;
  }

  public int getTotalTabla() {
    int suma = 0;
    // Recorre la tabla entera
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            suma += casilla[i][j];
        }
    }
    return suma;
}
   
}
