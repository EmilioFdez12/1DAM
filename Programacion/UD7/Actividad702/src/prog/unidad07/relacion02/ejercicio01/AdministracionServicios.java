package prog.unidad07.relacion02.ejercicio01;

public class AdministracionServicios extends Empleado{
  
  private String seccion;

  public AdministracionServicios(String nombre, String dni, String estadoCivil, int anyoIncorporacion, String despacho, String seccion) {
    super(nombre, dni, estadoCivil, anyoIncorporacion, despacho);
    this.seccion = seccion;
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
    return super.toString() + String.format(", Sección: \"%s\"", seccion);
  }

}
