package prog.unidad06.arraysuni.ejercicio06;

public class EstadisticasNotas {

  private int[] arrayCalificaciones;
  private int cantidadCalificaciones = 0;

  public EstadisticasNotas() {
    this.arrayCalificaciones = new int[20];
    this.cantidadCalificaciones = 0;
  }
  int longitudArray = 0;
  int[] arrayPrueba = new int[longitudArray];

  public void addCalificacion(int calificacion) {

    if (calificacion < 0 || calificacion > 10) {
      throw new IllegalArgumentException();
    } else {
      if (cantidadCalificaciones < arrayCalificaciones.length) {
        arrayCalificaciones[cantidadCalificaciones] = calificacion;
        cantidadCalificaciones++;
      } else {
        System.out.println("No hay más espacio disponible");
      }
    }
  }

  public double calificacionMedia() {
    double sumaNotas = 0;

    if (cantidadCalificaciones < 1) {
      return 0;
    }

    for (int i = 0; i < cantidadCalificaciones; i++) {
      sumaNotas += arrayCalificaciones[i];
    }
    double media = sumaNotas / cantidadCalificaciones;
    return media;
  }

  public double calificacionModa() throws EstadisticasNotasException {
    if(cantidadCalificaciones < 1) {
      throw new EstadisticasNotasException();      
    }
    return cantidadCalificaciones;
    
  }
  
}
