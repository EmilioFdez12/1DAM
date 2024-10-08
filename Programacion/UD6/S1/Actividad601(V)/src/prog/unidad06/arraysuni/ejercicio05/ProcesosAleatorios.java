package prog.unidad06.arraysuni.ejercicio05;

import java.util.Random;

import prog.unidad06.arraysuni.ejercicio04.UtilidadesArrays;

public class ProcesosAleatorios {

  public static void main(String[] args) {

    int[] array = new int[150];
    
    Random random = new Random();
    //hacemos 150 numeros random
    for (int i = 0; i < array.length; i++) {
      int numerosRandom = random.nextInt(1, 301);
      array[i] = numerosRandom; 
    }
    
    int valorMayor = UtilidadesArrays.getMaximoArrayEntero(array);
    int valorMenor = UtilidadesArrays.getMinimoArrayEntero(array);
    int repeticionesMayor = UtilidadesArrays.enteroApareceEnArrayEntero(array, valorMayor);
    int repeticionesMenor = UtilidadesArrays.enteroApareceEnArrayEntero(array, valorMenor);
    
    System.out.println("El mayor valor del array es " + valorMayor);
    System.out.println("El menor valor del array es " + valorMenor);
    System.out.println("El numero " + valorMayor + " se repite " + repeticionesMayor + " veces");
    System.out.println("El numero " + valorMenor + " se repite " + repeticionesMenor + " veces"); 

  }

}
