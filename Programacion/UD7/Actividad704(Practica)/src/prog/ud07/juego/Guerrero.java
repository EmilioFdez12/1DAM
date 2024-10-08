package prog.ud07.juego;

public class Guerrero extends Personaje {

  // Atributos
  // Reduccion de daño
  private static final double REDUCCION_DAÑO_RECIBIDO = 0.5;
  private static final int DEBUFFER_ESPADA = 2;
  private static final double BOOSTEADOR_CURA = 2;

  private boolean armadura;
  private boolean arma;

  /**
   * 
   * @param nombre   Nombre del Personaje
   * @param vida     Vida del personaje
   * @param armadura Lleva o no armadura. True si lleva, false si no.
   * @param arma     Arma que porta el guerrero. True espada y false si es mazo
   */
  public Guerrero(String nombre, int vida, boolean armadura, boolean arma) {
    super(nombre, vida);
    this.armadura = armadura;
    this.arma = arma;
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
    vida += (poderCuracion * BOOSTEADOR_CURA);

    if (vida > vidaInicial) {
      vida = vidaInicial;

    }
    return vida;
  }

  @Override
  public int getCuracionActual() {
    // El guerrero no cura
    return 0;
  }

  @Override
  public int getAtaqueActual() {

    int daño = 0;
    // Si lleva Espada

    if (arma) {
      // Daño reducido a la mitad
      daño = vida / DEBUFFER_ESPADA;
    } else {
      // Si lleva mazo, el daño es el mismo a la vida
      daño = vida;
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

  /**
   * Método para cambiar el arma
   * 
   * @param arma Arma a la que se quiere cambiar
   * @return Devuelve el nuevo arma
   */
  public boolean cambiaArma(boolean armaNueva) {
    this.arma = armaNueva;
    return arma;
  }

}
