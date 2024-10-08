package prog.unidad06.arraysobjetos;

public class Estudiante extends Persona {
  
  private static final String PRIMERO = "Primero"; 
  private static final String SEGUNDO = "Segundo"; 
  private static final String MASTER = "Master"; 

  private String curso;

  public Estudiante(String dni, String nombre, String curso) {
    this.dni = dni;
    this.nombre = nombre;
    this.curso = curso;
    
    
    if(curso.equalsIgnoreCase(PRIMERO)) {
      this.curso = PRIMERO;
    } else if (curso.equalsIgnoreCase(SEGUNDO)) {
      this.curso = SEGUNDO;
    } else if (curso.equalsIgnoreCase(MASTER)) {
      this.curso = MASTER;
    }
    

  }


  public String getCurso() {
    return curso;
  }
}
