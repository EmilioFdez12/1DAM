package prog.unidad07.ejercicio01;

public abstract class Figura {
  // Métodos abstractos que deben ser implementados por las clases hijas
  
  /**
   * Calcula el area de la figura
   * @return Area de la figura en m^2
   */
  public abstract double getArea();

  public abstract double getPerimetro();

  public abstract boolean isRegular();

}
