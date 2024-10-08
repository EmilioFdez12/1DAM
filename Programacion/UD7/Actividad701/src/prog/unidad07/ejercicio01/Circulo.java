package prog.unidad07.ejercicio01;

public class Circulo extends Figura {

  private static final double PI = 3.1416;
  private double radio;
  private Punto punto;

  public Circulo(Punto punto, double radio) {
    this.radio = radio;
    this.punto = punto;
  }

  @Override
  public double getArea() {
    return (PI * (radio * radio));
  }

  @Override
  public double getPerimetro() {
    return (2 * PI * radio);
  }

  @Override
  public boolean isRegular() {
    return true;
  }

}
