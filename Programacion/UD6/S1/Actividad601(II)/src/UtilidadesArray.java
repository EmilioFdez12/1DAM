import java.util.Random;

public class UtilidadesArray {

  public static int[] generarArrayEnteroAleatorio(int longitud, int valorMinimo, int valorMaximo) {

    if (longitud <= 0) {
      throw new IllegalArgumentException();
    }

    if (valorMaximo < valorMinimo || valorMinimo == valorMaximo || valorMaximo < 0 || valorMinimo < 0) {
      throw new IllegalArgumentException();
    }
    
    if(longitud > (valorMaximo - valorMinimo)) {
      throw new IllegalArgumentException();
    }
    
    int[] arrayAleatorio = new int[longitud];

    Random random = new Random();
    for(int i = 1; i <= longitud; i++) {
    int numeroRandom = random.nextInt(valorMinimo, valorMaximo);
    arrayAleatorio[i] = numeroRandom;
    }
    

    return null;
  }

}
