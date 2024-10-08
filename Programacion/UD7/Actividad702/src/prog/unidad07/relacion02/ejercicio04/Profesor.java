package prog.unidad07.relacion02.ejercicio04;

public class Profesor extends Empleado{
  
  private String departamento;
  private double salario;

  public Profesor(String nombre, String dni, String estadoCivil, int anyoIncorporacion, String despacho, String departamento, double salario) {
    super(nombre, dni, estadoCivil, anyoIncorporacion, despacho);
    this.departamento = departamento;
    this.salario = salario;
  }
  /**
   * Cambia a un profesor de un departamento a otro
   * @param nuevoDepartamento
   */
  public void setDepartamento(String nuevoDepartamento) {
    departamento = nuevoDepartamento;
  }
  
  @Override
  public String toString() {
    return "(Profesor): " + super.toString() + String.format(", Departamento: \"%s\"", departamento);
  }
  @Override
  public double getSalario() {
    return salario;
  }

}
