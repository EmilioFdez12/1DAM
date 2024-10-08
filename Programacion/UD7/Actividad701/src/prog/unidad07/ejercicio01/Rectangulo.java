package prog.unidad07.ejercicio01;

public class Rectangulo extends Figura {
  private Punto punto;
  private Punto punto2;

  public Rectangulo(Punto punto, Punto punto2) {
    this.punto = punto;
    this.punto2 = punto2;
  }

  @Override
  public double getArea() {
    return calculaAltura() * calculaAncho();
  }

  @Override
  public double getPerimetro() {
    return (calculaAltura() * 2) + (calculaAncho() * 2);
  }

  @Override
  public boolean isRegular() {
    return calculaAltura() == calculaAncho();
  }

  private double calculaAncho() {
    return punto2.getX() - punto.getX();
  }

  private double calculaAltura() {
    return punto2.getY() - punto.getY();
  }

}
