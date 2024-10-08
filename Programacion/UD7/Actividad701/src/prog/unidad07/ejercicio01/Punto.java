package prog.unidad07.ejercicio01;

public class Punto {
  private double x;
  private double y;
  
  public Punto(double x, double y) {
    this.x = x;
    this.y = y;
  }
  
  public double getX() {
    return x;
  }
  
  public double getY() {
    return y;
  }
  
  public double calcDist(Punto otroPunto) {
    double dx = this.x - otroPunto.getX();
    double dy = this.y - otroPunto.getY();
    return Math.sqrt(dx * dx + dy * dy);
}
  
}
