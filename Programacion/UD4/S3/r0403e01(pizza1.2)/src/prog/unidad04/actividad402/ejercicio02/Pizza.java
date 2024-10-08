package prog.unidad04.actividad402.ejercicio02;

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

  static final double COSTE_MEDIANA = 5;

  static final double COSTE_FAMILIAR = 7.5;

  static final int INGREDIENTE_MARAGARITA = 2;
  static final int INGREDIENTE_CUATRO_QUESOS = 4;
  static final int INGREDIENTE_FUNGHI = 3;

  private static int pizzasServidas = 0;
  private static int totalPizzas = 0;
  private String estado = ESTADO_PEDIDA;
  private String tamanyo;
  private String tipo;
  private double coste = 0;

  /**
   * 
   * @param tamanyo
   * @param tipo
   */
  public Pizza(String tamanyo, String tipo) {
    this.tamanyo = tamanyo;
    this.tipo = tipo;

    boolean bParametros = true;

    if (!tipo.equals(TIPO_CUATRO_QUESOS) && (!tipo.equals(TIPO_MARGARITA) && (tipo.equals(TIPO_FUNGHI)))) {
      System.out.println("El parametro tipo no es correcto");
      bParametros = false;
    }

    if (!tamanyo.equals(TAMANYO_MEDIANA) && !tamanyo.equals(TAMANYO_FAMILIAR)) {
      System.out.println("El paramatro tamaño no es correcto. Tiene que ser 'mediana' o 'familiar'");
      bParametros = false;
    }

    if (bParametros) {
      totalPizzas++;
    }

  }

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

  public double coste() {

    if (tamanyo.equals(TAMANYO_MEDIANA) && (tipo.equals(TIPO_MARGARITA))) {
      coste = COSTE_MEDIANA + INGREDIENTE_MARAGARITA;
    } else if (tamanyo.equals(TAMANYO_MEDIANA) && (tipo.equals(TIPO_CUATRO_QUESOS))) {
      coste = COSTE_MEDIANA + INGREDIENTE_CUATRO_QUESOS;
    } else if (tamanyo.equals(TAMANYO_MEDIANA) && (tipo.equals(TIPO_FUNGHI))) {
      coste = COSTE_MEDIANA + INGREDIENTE_FUNGHI;
    } else if (tamanyo.equals(TAMANYO_FAMILIAR) && (tipo.equals(TIPO_MARGARITA))) {
      coste = COSTE_FAMILIAR + INGREDIENTE_MARAGARITA;
    } else if (tamanyo.equals(TAMANYO_FAMILIAR) && (tipo.equals(TIPO_CUATRO_QUESOS))) {
      coste = COSTE_FAMILIAR + INGREDIENTE_CUATRO_QUESOS;
    } else if (tamanyo.equals(TAMANYO_FAMILIAR) && (tipo.equals(TIPO_FUNGHI))) {
      coste = COSTE_FAMILIAR + INGREDIENTE_FUNGHI;
    }
    return coste;
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
