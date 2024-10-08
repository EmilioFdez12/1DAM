package prog.unidad05.consola.ejercicio03;

import java.util.Random;

public class ImpresorTablaReal {
    private int filas;
    private int columnas;
    private double[][] tablaReales;

    public ImpresorTablaReal(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    public void imprimeTabla(int numDecimales) {
      tablaReales = crearTabla();

      // Encontrar el ancho máximo de caracteres para los números
      int anchoMaximo = 0;
      for (int i = 0; i < filas; i++) {
          for (int j = 0; j < columnas; j++) {
              String numeroFormateado = String.format("%." + numDecimales + "f", tablaReales[i][j]);
              int longitud = numeroFormateado.length();
              if (longitud > anchoMaximo) {
                  anchoMaximo = longitud;
              }
          }
      }

      // Imprimir la tabla
      for (int i = 0; i < filas; i++) {
          for (int j = 0; j < columnas; j++) {
              // formato
            System.out.printf("%" + anchoMaximo + "." + numDecimales + "f  ", tablaReales[i][j]);
          }
          System.out.println();
      }
  }


    private double[][] crearTabla() {
        Random random = new Random();
        double[][] tablaReales = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int randomizador = random.nextInt();
                // hago un randomizador, si es menor 0,5 saldra positivo si no saldra negativo
                if (randomizador < 0.5) {
                  double numeroTabla = random.nextDouble(0,9999); 
                  tablaReales[i][j] = numeroTabla;
                } else {
                  double numeroTabla = -random.nextDouble(0,9999); 
                  tablaReales[i][j] = numeroTabla;
                }
                
            }
        }
        return tablaReales;
    }
}
