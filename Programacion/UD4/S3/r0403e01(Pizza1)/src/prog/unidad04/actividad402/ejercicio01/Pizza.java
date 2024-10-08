package prog.unidad04.actividad402.ejercicio01;

public class Pizza {
  /**
   * Clase que representa una pizza
   */
  static final String ESTADO_PEDIDA = "pedida";

  static final String ESTADO_SERVIDA = "servida";

  static final String TAMANYO_FAMILIAR = "familiar";

  static final String TAMANYO_MEDIANA = "mediana";

  static final String TIPO_CUATRO_QUESOS = "cuatro";

  static final String TIPO_FUNGHI = "funghi";

  static final String TIPO_MARGARITA = "margarita";


  private static int pizzasServidas = 0;
  private static int totalPizzas = 0;
  private String estado = ESTADO_PEDIDA;
  private String tamanyo;
  private String tipo;
 

  /**
   * 
   * @param tamanyo Tamaño de la pizza
   * @param tipo Tipo de Pizza (Margarita, 4 Quesos, ...)
   */
  public Pizza(String tamanyo, String tipo) {
    this.tamanyo = tamanyo;
    this.tipo = tipo;
    
    boolean bParametros = true;
       
    if(!tipo.equals(TIPO_CUATRO_QUESOS) && (!tipo.equals(TIPO_MARGARITA)&& (tipo.equals(TIPO_FUNGHI)))) {
      System.out.println("El parametro tipo no es correcto");
      bParametros = false;
    }
    
    if(!tamanyo.equals("mediana") && !tamanyo.equals("familiar")) {
      System.out.println("El paramatro tamaño no es correcto. Tiene que ser 'mediana' o 'familiar'");
      bParametros = false;
    }
    
    if (bParametros) {
      totalPizzas++;
    }
    
  }  
/**
 * 
 * @return Devuelve el tamaño 
 */
  public String getTamanyo() {
    return tamanyo;
  }

  public String getTipo() {
    return tipo;
  }

  public String getEstado() {
    return estado;
  }

  public static int getPizzasCreadas() {
   return totalPizzas;
  }

  public static int getPizzasServidas() {
    return pizzasServidas;
  }
  
  public void sirve() {
    if (estado.equals(ESTADO_SERVIDA)) {
      System.out.println("Error. Esta pizza ya se ha servido");
    } else {
      estado = ESTADO_SERVIDA;
      pizzasServidas++;
    }
  }

}
