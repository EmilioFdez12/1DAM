package prog.ud07.juego;

public class Sacerdote extends Personaje {

  // Atributos
  // Reduccion de daño
  private static final double BOOSTEADOR_CURA = 1/3;
  private static final int DEBUFFER_CURAR = 2;

  private boolean reliquia;

  /**
   * 
   * @param nombre   Nombre del Personaje
   * @param vida     Vida del personaje
   * @param armadura Lleva o no armadura. True si lleva, false si no.
   * @param arma     Arma que porta el guerrero. True espada y false si es mazo
   */
  public Sacerdote(String nombre, int vida, boolean reliquia) {
    super(nombre, vida);
    this.reliquia = true; // Empieza con reliquia
   
  }

  @Override
  public int serAtacado(int poderAtaque) {
    // Si lleva reliquia no recibe daño y la pierde
    if (reliquia) {      
      reliquia = false;
    } else {
      // Si no el ataque es normal
      vida -= poderAtaque / 10 * 10;
    }
return vida;
  }
  
  
  @Override
  public int serCurado(int poderCuracion) {
    // Duplicamos el poder de curacion
    int vidaActaulizada = 0;
    vidaActaulizada += poderCuracion * BOOSTEADOR_CURA;
    
    if (vidaActaulizada > vida) {
      vidaActaulizada = vida;
    } 
   return vidaActaulizada;
  }
  
  
  @Override
  public int getCuracionActual() {
   int curacion = 1;
   if (reliquia) {
    curacion += vida;
  } else {
    // La mitad de la vida
    curacion += vida / DEBUFFER_CURAR;
  }
   return curacion;
  }

  @Override
  public int getAtaqueActual() {
    return 0;
  }

  /**
   * Pone la armadura al guerrero si no tiene
   */
  public void ponerReliquia() {
    // Si tiene reliquia se queda igual
    if (reliquia) {
      reliquia = true;
    } else {
      // Si no se le pone la reliquia
      reliquia = true;
    }
  }

  @Override
  protected boolean tieneArmadura() {
    return false;
  }

}
