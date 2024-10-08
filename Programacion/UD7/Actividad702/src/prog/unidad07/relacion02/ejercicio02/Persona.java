package prog.unidad07.relacion02.ejercicio02;

abstract public class Persona {
  
  protected String nombreCompleto;
  protected String dni;
  protected String estadoCivil;
  
  
  protected Persona(String nombreCompleto, String dni, String estadoCivil) {
    this.nombreCompleto = nombreCompleto;
    this.dni = dni;
    this.estadoCivil = estadoCivil;
  }
  
  /**
   * Cambia el estado civil a uno nuevo
   * @param nuevoEstadoCivil
   */
  public void setEstadoCivil(String nuevoEstadoCivil) {
    estadoCivil = nuevoEstadoCivil;
  }
  
  public String getDni() {
    return dni;
  }
  
  @Override
  public String toString() {
    return String.format("Nombre: \"%s\", DNI: \"%s\", Estado Civil: \"%s\"", nombreCompleto, dni, estadoCivil); 
  }
  
}
