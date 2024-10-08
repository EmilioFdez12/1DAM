package prog.unidad07.ejercicio02;

public class EmpleadoFijo extends Empleado {
  
  private Double salario;

  protected EmpleadoFijo(String nombre, String dni, String telefono, Double salario) {
    super(nombre, dni, telefono);
    if (salario >= 0) {
      this.salario = redondea2Decimales(salario);
    } else {
      throw new IllegalArgumentException("El salario no puede ser negativo");
    }
  }

  @Override
  public double getSalario() {
    return salario;
  }

}
