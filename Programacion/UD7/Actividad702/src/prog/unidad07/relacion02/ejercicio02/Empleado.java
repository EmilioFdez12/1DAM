package prog.unidad07.relacion02.ejercicio02;

public class Empleado extends Persona {

  protected int anyoIncorporacion;
  protected String despacho;

  protected Empleado(String nombreCompleto, String dni, String estadoCivil, int anyoIncorporacion, String despacho) {
    super(nombreCompleto, dni, estadoCivil);
    this.anyoIncorporacion = anyoIncorporacion;
    this.despacho = despacho;
  }

  /**
   * Cambia el código de despacho a uno nuevo
   * 
   * @param nuevoDespacho
   */
  public void setDespacho(String nuevoDespacho) {
    despacho = nuevoDespacho;
  }

  @Override
  public String toString() {
    return super.toString() + String.format(", Año de incorporación: %d, Despacho: %s", anyoIncorporacion, despacho);
  }
}
