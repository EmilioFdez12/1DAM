package prog.unidad07.relacion02.ejercicio04;

public class Estudiante extends Persona{
  
  private String curso;

  protected Estudiante(String nombreCompleto, String dni, String estadoCivil, String curso) {
    super(nombreCompleto, dni, estadoCivil);
    this.curso = curso;
  }
  
  /**
   * Cambia el curso a uno nuevo
   * @param nuevoCurso
   */
  public void setCurso(String nuevoCurso) {
    this.curso = nuevoCurso;
  }
  
  @Override
  public String toString() {
    return super.toString() + String.format(", Curso: \"%s\"", curso);
  }

}
