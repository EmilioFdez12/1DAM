package prog.unidad07.ejercicio02;

public class Consultor extends Empleado {

  protected double tarifaHora;
  protected double horasTrabajadas;
  
  protected Consultor(String nombre, String dni, String telefono, Double tarifaHora, int horasTrabajadas) {
    super(nombre, dni, telefono);
    if (tarifaHora >= 0 && horasTrabajadas >= 0) {
      this.tarifaHora = tarifaHora;
      this.horasTrabajadas = horasTrabajadas;
    } else {
      throw new IllegalArgumentException("La tarifa y el número de horas deben ser positivos");
    }
    
  }

  @Override
  public double getSalario() {
    return redondea2Decimales(tarifaHora * horasTrabajadas);
  }

}
