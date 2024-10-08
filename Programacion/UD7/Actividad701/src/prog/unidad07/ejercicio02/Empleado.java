package prog.unidad07.ejercicio02;

public abstract class Empleado {

  protected String nombre;
  protected String dni;
  protected String telefono;

  protected Empleado(String nombre, String dni, String telefono) {
    if (nombre == null || dni == null || telefono == null) {
      throw new NullPointerException("Alguno de los parámetros es null");
    } else {
      this.nombre = nombre;
      this.dni = dni;
      this.telefono = telefono;
    }
  }

  public String getNombre() {
    return nombre;
  }

  public String getDni() {
    return dni;
  }

  public String getTelefono() {
    return telefono;
  }
  
  public abstract double getSalario();
  
  protected double redondea2Decimales(double cantidad) {
    return Math.round(cantidad * 100.0) / 100.0;
  }
  
  
}
