package prog.unidad07.relacion02.ejercicio04;

public class AdministracionServicios extends Empleado{
  
  private static final double EUROS_HORA = 15;
  
  private String seccion;
  private double horasTrabajadas;
  
  public AdministracionServicios(String nombre, String dni, String estadoCivil, int anyoIncorporacion, String despacho, String seccion, double horasTrabajadas) {
    super(nombre, dni, estadoCivil, anyoIncorporacion, despacho);
    this.seccion = seccion;
    this.horasTrabajadas = horasTrabajadas;
  }
  
  /**
   * Cambia a un profesor de un departamento a otro
   * @param nuevoDepartamento
   */
  public void setSeccion(String nuevaSeccion) {
    seccion = nuevaSeccion;
  }
  
  @Override
  public String toString() {
    return "(PAS): " + super.toString() + String.format(", Sección: \"%s\"", seccion);
  }

  @Override
  public double getSalario() {
    return horasTrabajadas * EUROS_HORA;
  }

}
