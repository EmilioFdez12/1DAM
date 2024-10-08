package prog.unidad07.relacion02.ejercicio01;

public class Profesor extends Empleado{
  
  private String departamento;

  public Profesor(String nombre, String dni, String estadoCivil, int anyoIncorporacion, String despacho, String departamento) {
    super(nombre, dni, estadoCivil, anyoIncorporacion, despacho);
    this.departamento = departamento;
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
    return super.toString() + String.format(", Departamento: \"%s\"", departamento);
  }

}
