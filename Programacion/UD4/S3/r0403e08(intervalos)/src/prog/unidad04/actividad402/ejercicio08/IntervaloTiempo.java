package prog.unidad04.actividad402.ejercicio08;

public class IntervaloTiempo {

  // mejor hacerlo en segundos
  private int horas;
  private int minutos;
  private int segundos;

  /**
   * @author Emi
   * @version 1.0 Constructor que crea un intervalo en horas, minutos y segundos
   * 
   * @param horas
   * @param minutos
   * @param segundos
   */
  public IntervaloTiempo(int horas, int minutos, int segundos) {
    this.segundos = segundos % 60;// nos quedamos con el resto 300/60 = 5 resto = 0, esos 5 minutos se pasaran al
                                  // parametro minutos
    minutos += (segundos / 60);// pasamos los segundos sobrantes a minutos
    // Los segundos estan listos, ahora repetimos lo mismo con los minutos
    this.minutos = minutos % 60;
    horas += (minutos / 60);
    this.horas = horas;
  }

  public IntervaloTiempo suma(IntervaloTiempo otro) {
    int segundos = this.segundos + otro.segundos;
    int minutos = this.minutos + otro.minutos;
    int horas = this.horas + otro.horas;
    return new IntervaloTiempo(horas, minutos, segundos);
  }

  public IntervaloTiempo resta(IntervaloTiempo otro) {
    int segundos = this.segundos - otro.segundos;
    int minutos = 0;
    if (segundos < 0) {
      segundos += 60;
      minutos = 1;
    }

    minutos = this.minutos - otro.minutos - minutos;
    if (minutos < 0) {
      minutos += 60;
      horas = 1;
    }
    horas = this.horas - otro.horas - horas;
    if (horas >= 0) {
      return new IntervaloTiempo(horas, minutos, segundos);
    } else {
      return null;
    }

  }

  public String obtenerCadena() {
      return String.format( "%02dh %02dm %02ds", horas, minutos, segundos);
  }
}
