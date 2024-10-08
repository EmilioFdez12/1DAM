package prog.ud07.juego;

public abstract class Personaje {

  // Atributos
  private String nombre;
  protected int vida;
  private boolean vivo;
  protected int vidaInicial;
  
  public Personaje(String nombre, int vida) {
    if (nombre == null || nombre.isBlank()) {
      throw new IllegalArgumentException();
    }
    this.nombre = nombre;
    
    if (vida <= 0) {
      throw new IllegalArgumentException();
    }
    this.vida = vida;
    this.vivo = true;
    this.vidaInicial = vida;
  }
  
  /**
   * Metodo para ser atacado
   * @param poderAtaque Poder con el que se te ataca
   */
  public abstract int serAtacado(int poderAtaque);
  
  /**
   * Metodo para ser curado
   * @param poderCuracion Poder con el que se te cura
   */
  public abstract int serCurado(int poderCuracion);
  
  /**
   * Obtiene la curacion que recibirias en este instante
   * @return Curacion
   */
  public abstract int getCuracionActual();
  
  /**
   * Obtiene el daño que harias en este instante
   * @return Daño actual
   */
  public abstract int getAtaqueActual();
  
  /**
   * Devuelve si el personaje esta vivo o no
   * @return Si esta vivo true, false si no
   */
  public boolean estaVivo() {
    boolean estaVivo = true;
    if (vida <= 0) {
      estaVivo = false;
    }
    return estaVivo;
  }
  
  public int getSalud() {
    return vida;
  }

  protected abstract boolean tieneArmadura();
  
}
