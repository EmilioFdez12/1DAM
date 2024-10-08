package prog.unidad04.practica406.libreria;


/**
 * Clase que representa una Fecha a partir del 1/1/1900
 */
public class Fecha extends Object implements ConvertibleATexto {

  private int dia;
  private int mes;
  private int anyo;
  
  /**
   * 
   * @param dia Dia del mes
   * @param mes Mes del año
   * @param anyo Año
   */
  public Fecha(int dia, int mes, int anyo) {
    if (!comprobarFecha(dia, mes, anyo)) {
      throw new IllegalArgumentException();
    }      
      this.dia = dia;
      this.mes = mes;
      this.anyo = anyo;
  }

  //Metodo privado para comprobar  si una fecha es correcta.
  private boolean comprobarFecha(int dia, int mes, int anyo) {
    if (dia < 1 || mes < 1 || mes > 12 || anyo < 1900) {
      return false;
    }
      int maximoDeDias = 0;
      boolean comprobarF = true;

  		if (mes == 2) {
  			if (comprobarEsBisiesto(anyo)) {
  				maximoDeDias = 29;
  			} else {
  				maximoDeDias = 28;
  			}
  		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
  			maximoDeDias = 30;
  		} else {
  			maximoDeDias = 31;
  		}
  		
  		if(dia > maximoDeDias) {
  			comprobarF = false;
  		}     
      return comprobarF;     
  }

  /**
   * Obtiene el dia
   * @return Dia de la fecha
   */
  public int getDia() {
    return dia;
  }

  /**
   * Obtiene el mes
   * @return Mes de la fecha
   */
  public int getMes() {
    return mes;
  }

  /**
   * Obtiene el año
   * @return Año de la fecha
   */
  public int getAnyo() {
    return anyo;
  }

  /**
   * Devuelve si el año es bisiesto o no
   * @return true si es bisiesto, false si no
   */
  public boolean esBisiesto() {
    return comprobarEsBisiesto(anyo);
  }

  private boolean comprobarEsBisiesto(int anyo) {
    return (anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 400 == 0);
}

  /**
   * Obtiene el numero de dias transcurridos entre la fecha y la fecha de inicio
   * del calendario (1/1/1900)
   * @return Número de días transcurridos entre esta fecha y la fecha de inicio
   *         del calendario
   */
  public long diasTranscurridos() {
    long totalDias = 0;

    for (int i = 1900; i < anyo; i++) {
        if (comprobarEsBisiesto(i)) {
            totalDias += 366;
        } else {
            totalDias += 365;
        }
    }

    for (int i = 1; i < mes; i++) {
        if (i == 2) {
            if (comprobarEsBisiesto(anyo)) {
                totalDias += 29;
            } else {
                totalDias += 28;
            }
        } else if (i == 4 || i == 6 || i == 9 || i == 11) {
            totalDias += 30;
        } else {
            totalDias += 31;
        }
    }
    totalDias += (dia - 1);
    return totalDias;
}

  /**
   * @param fecha - Otra fecha posterior a esta
   * @return Número de días transcurridos entre esta fecha y la proporcionada
   * @throws FechaException - Si la fecha proporcionada es anterior a esta
   */
  public long diasEntre(Fecha fecha) {  
  	Fecha fecha1 = new Fecha(dia,mes,anyo);
    Fecha otraFecha = new Fecha(fecha.dia,fecha.mes,fecha.anyo);
    long diasFecha1 = fecha1.diasTranscurridos();
    long diasOtraFecha = otraFecha.diasTranscurridos();
    
    long diasTotales = diasFecha1 - diasOtraFecha;
    if(diasTotales < 0) {
    	 return -diasTotales;  
    } else {
    	throw new FechaException();
    }    
  }

  /**
   * Compara esta fecha con otra
   * @param fecha Fecha con la que se quiere comparar esta
   * @return Menor que 0 si esta fecha es anterior a la otra, 0 si las dos fechas son iguales y mayor que cero si esta fecha es posterior a la otra
   */
  public int compara(Fecha fecha) {
  	 Fecha fecha1 = new Fecha(dia,mes,anyo);
     Fecha otraFecha = new Fecha(fecha.dia,fecha.mes,fecha.anyo);      
     if(fecha1.diasTranscurridos() < otraFecha.diasTranscurridos()){
    	 return -1;
     } else if (fecha1.diasTranscurridos() > otraFecha.diasTranscurridos()) {
    	 return 1;
     } else {
    	 return 0;
     }  
  }

  //Pasamos la fecha al formato que se nos pide.Interfaz
  @Override
  public String aTexto() {
    if (this.mes == 1) {
      return String.format("%d de enero de %02d", this.dia, this.anyo);
    } else if (this.mes == 2) {
      return String.format("%d de febrero de %02d", this.dia, this.anyo);
    } else if (this.mes == 3) {
      return String.format("%d de marzo de %02d", this.dia, this.anyo);
    } else if (this.mes == 4) {
      return String.format("%d de abril de %02d", this.dia, this.anyo);
    } else if (this.mes == 5) {
      return String.format("%d de mayo de %02d", this.dia, this.anyo);
    } else if (this.mes == 6) {
      return String.format("%d de junio de %02d", this.dia, this.anyo);
    } else if (this.mes == 7) {
      return String.format("%d de julio de %02d", this.dia, this.anyo);
    } else if (this.mes == 8) {
      return String.format("%d de agosto de %02d", this.dia, this.anyo);
    } else if (this.mes == 9) {
      return String.format("%d de septiembre de %02d", this.dia, this.anyo);
    } else if (this.mes == 10) {
      return String.format("%d de octubre de %02d", this.dia, this.anyo);
    } else if (this.mes == 11) {
      return String.format("%d de noviembre de %02d", this.dia, this.anyo);
    } else if (this.mes == 12) {
      return String.format("%d de diciembre de %02d", this.dia, this.anyo);
    } else {
      throw new IllegalArgumentException();
    }
  }
}
