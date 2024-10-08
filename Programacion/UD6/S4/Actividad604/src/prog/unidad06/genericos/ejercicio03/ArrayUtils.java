package prog.unidad06.genericos.ejercicio03;

public class ArrayUtils {
  
  public ArrayUtils() {
    
  }
  
  public static <T> void intercambiarElementos(T[] array, int indiceDesde, int indiceHasta) {
    T valor = array[indiceDesde];
    array[indiceDesde] = array[indiceHasta];
    array[indiceHasta] = valor;
  }
  
  
 public static <T> void invertirArray(T[] array) {
    int inicio = 0;
    int fin = array.length - 1 ;
    
    while(inicio < fin){
      intercambiarElementos(array, inicio, fin);
      inicio++;
      fin--;
    }
  }
  
  
}
