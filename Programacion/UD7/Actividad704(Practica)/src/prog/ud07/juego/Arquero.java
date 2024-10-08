package prog.ud07.juego;

public abstract class Arquero extends Personaje {

  // Atributos
  private static final double REDUCCION_DAÑO_RECIBIDO = 0.5;

  private static String MAESTRIA_NOVATO = "novato";
  private static String MAESTRIA_MEDIO = "medio";
  private static String MAESTRIA_EXPERTO = "experto";
  
  private static final int DEBUFFER_NOVATO = 1/5;
  private static final int DEBUFFER_MEDIO = 1/3;
  private static final int DEBUFFER_EXPERTO = 1/2;

  // Solo tiene arco
  private static boolean ARCO = true;
  // Armadura
  private boolean armadura;

  private String maestriaActual;
  
  /**
   * 
   * @param nombre   Nombre del Personaje
   * @param vida     Vida del personaje
   * @param armadura Lleva o no armadura. True si lleva, false si no.
   * @param arma     Arma que porta el guerrero. True espada y false si es mazo
   */
  protected Arquero(String nombre, int vida, boolean armadura, String maestria) {
    super(nombre, vida);
    this.armadura = armadura;
    if (maestria.equals(MAESTRIA_NOVATO)) {
      this.maestriaActual = maestria;
    } else if (maestria.equals(MAESTRIA_MEDIO)) {
      this.maestriaActual = maestria;
    } else if (maestria.equals(MAESTRIA_EXPERTO)) {
      this.maestriaActual = maestria;
    }
    
  }

  @Override
  public int serAtacado(int poderAtaque) {
    // Si lleva armadura recibe la mitad de daño
    if (armadura) {
      // El ataque se reduce a la mitad
      poderAtaque *= REDUCCION_DAÑO_RECIBIDO;
      // Reducimos la vida
      vida -= poderAtaque / 10 * 10;
      // Se pierde la armadura
      armadura = false;
    } else {
      // Si no el ataque no se reduce
      vida -= poderAtaque / 10 * 10;
    }
return vida;
  }
  @Override
  public int serCurado(int poderCuracion) {
    // Duplicamos el poder de curacion
    vida += poderCuracion;

    if (vida > vidaInicial) {
      vida = vidaInicial;

    }
    return vida;
  }

 

  @Override
  public int getCuracionActual() {
    // El arquero no cura
    return 0;
  }

  @Override
  public int getAtaqueActual() {
    int daño = 1;
    if (maestriaActual.equals(MAESTRIA_NOVATO)) {
      daño = vida * DEBUFFER_NOVATO;
    } else if (maestriaActual.equals(MAESTRIA_MEDIO)) {
      daño = vida * DEBUFFER_MEDIO;
    } else {
      daño = vida * DEBUFFER_EXPERTO;
    }
    return daño;
  }

  /**
   * Pone la armadura al guerrero si no tiene
   */
  public void ponerArmadura() {
    // Si tiene armadura se queda igual
    if (armadura) {
      armadura = true;
    } else {
      // Si no se le pone la armadura
      armadura = true;
    }
  }

  /**
   * Metodo para saber si tiene o no armadura
   * 
   * @return Si tiene puesto o no aramdura, true si la tiene, false si no.
   */
  public boolean tieneArmadura() {
    return armadura;
  }
  
  public void promocionar() {
    if (maestriaActual.equals(MAESTRIA_NOVATO)) {
      maestriaActual = MAESTRIA_MEDIO;
    } else if (maestriaActual.equals(MAESTRIA_MEDIO)) {
      maestriaActual = MAESTRIA_EXPERTO;
    } else {
      maestriaActual = MAESTRIA_EXPERTO;
    }
  }

}
