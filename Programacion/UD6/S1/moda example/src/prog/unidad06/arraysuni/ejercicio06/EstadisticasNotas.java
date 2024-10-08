package prog.unidad06.arraysuni.ejercicio06;

public class EstadisticasNotas {

  // Atributos
  // Para la media
  // Suma de las calificaciones
  private double suma;
  // Cantidad de calificaciones
  private int calificaciones;
  // Para la moda
  private int[] frecuencias;

  public EstadisticasNotas() {
    // Inicializamos los atributos
    suma = 0;
    calificaciones = 0;
    // Array con 11 posiciones
    frecuencias = new int[11];
  }

  public void addCalificacion(int calificacion) {
    // Si la calificacion es correcta
    if (calificacion >= 0 && calificacion <= 10) {
      // Actualizamos la frecuencia de la calificacion
      frecuencias[calificacion]++;
      suma += calificaciones;
      // Contamos una nueva calificacion
      calificaciones++;
    } else {
      throw new IllegalArgumentException();
    }

  }

  public double calificacionMedia() {
    if (calificaciones > 0) {
      return (suma / calificaciones);
    } else {
      return 0;
    }

  }

  public int calificacionModa() throws EstadisticasNotasException {
    if (calificaciones > 0) {
      int posicion = 0;
      int maximo = frecuencias[0];
      for (int i = 0; i < frecuencias.length; i++) {
        if (frecuencias[i] > maximo) {
          posicion = i;
          maximo = frecuencias[i];
        }

        // Cuando llegamos aqui el maximo esta en la maxima frecuencia
        // y en su posicion
        //
      }
      return posicion;

    } else {
      throw new EstadisticasNotasException();
    }
  }
}
