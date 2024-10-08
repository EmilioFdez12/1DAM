package prog.unidad06.arraysobjetos;

public class Profesor extends Persona {
  
  private String materia;

  public Profesor(String dni, String nombre, String materia) {
    this.dni = dni;
    this.nombre = nombre;
    this.materia = materia;
  }
  
  public String getMateria() {
    return materia;
  }

}
