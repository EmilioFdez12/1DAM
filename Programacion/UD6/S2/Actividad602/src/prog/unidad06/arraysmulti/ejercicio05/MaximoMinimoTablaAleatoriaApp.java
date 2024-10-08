package prog.unidad06.arraysmulti.ejercicio05;

import java.util.Random;

import prog.unidad06.arraysmulti.ejercicio02.TablaEnteraConTotales;

public class MaximoMinimoTablaAleatoriaApp {

  public static void main(String[] args) {
    
    TablaEnteraConTotales tablaAleatoria = new TablaEnteraConTotales(6, 10);
    
    Random rm = new Random();
    int filas = 6;
    int columnas = 10;

 
    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        int generadorRandom = rm.nextInt(1000);
        tablaAleatoria.setCasilla(i, j, generadorRandom);
      }
    }   
    
    System.out.println("MÁXIMO Y MÍNIMO EN TABLA ALEATORIA");
    System.out.println("---------------------------------------------------------------------------");
    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        System.out.print(tablaAleatoria.getCasilla(i, j) + "\t");
      }
      System.out.println();
    }
    System.out.println("---------------------------------------------------------------------------");
    
    //El primer valor es el máximo(no hay mas)
    int valorMaximo = tablaAleatoria.getCasilla(0, 0);
    int valorMinimo = tablaAleatoria.getCasilla(0, 0);
    int posicionFilaMaximo = 0;
    int posicionColumnaMaximo = 0;
    int posicionFilaMinimo = 0;
    int posicionColumnaMinimo= 0;
    
    // Recorremas la tabla y vamos actualizando el máximo
    for(int i = 0; i < filas; i++) {
    	for(int j = 0; j < columnas; j++) {
    		int valorActual = tablaAleatoria.getCasilla(i, j);
    		
    		// Conseguimos el máximo
    		if (valorMaximo < valorActual) {
    			posicionFilaMaximo = i + 1 ;// + 1 para que empiece por la fila 0
      		posicionColumnaMaximo = j + 1;
    			valorMaximo = valorActual;
    		} 
    		
    		// Conseguimos el mínimo
    		if (valorMinimo > valorActual) {
    			posicionFilaMinimo = i + 1 ;// + 1 para que empiece por la fila 0
      		posicionColumnaMinimo = j + 1;
    			valorMinimo = valorActual;
    		} 
    		
    	}
    }
    System.out.println("El máximo vale " + valorMaximo + " y esta locacalizado en la fila " + (posicionFilaMaximo) + " y la columna " + (posicionColumnaMaximo));
    System.out.println("El mínimo vale " + valorMinimo+ " y esta locacalizado en la fila " + (posicionFilaMinimo) + " y la columna " + (posicionColumnaMinimo));
  }


}
