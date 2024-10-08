package prog.ud07.juego;

public class Sanador extends Personaje {

  // Atributos
  private static final double BOOSTEADOR_CURA = 1/3;
  private static final int DEBUFFER_CURAR = 2;
  
  /**
   * 
   * @param nombre   Nombre del Personaje
   * @param vida     Vida del personaje
   * @param armadura Lleva o no armadura. True si lleva, false si no.
   * @param arma     Arma que porta el guerrero. True espada y false si es mazo
   */
  public Sanador(String nombre, int vida) {
    super(nombre, vida);
  }

  @Override
  public int serAtacado(int poderAtaque) {
     return vida -= poderAtaque / 10 * 10;
  }
  
  @Override
  public int serCurado(int poderCuracion) {
    // Duplicamos el poder de curacion
    vida += poderCuracion + (poderCuracion * BOOSTEADOR_CURA);

    if (vida > vidaInicial) {
      vida = vidaInicial;

    }
    return vida;
  }

  @Override
  public int getCuracionActual() {
    return vida / DEBUFFER_CURAR;
  }

  // No ataca
  @Override
  public int getAtaqueActual() {
    return 0;
  }

  @Override
  protected boolean tieneArmadura() {
    return false;
  }


}
