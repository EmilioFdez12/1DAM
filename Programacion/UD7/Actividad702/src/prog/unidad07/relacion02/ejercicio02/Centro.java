package prog.unidad07.relacion02.ejercicio02;

import java.util.HashMap;
import java.util.Map;

public class Centro {

  private Map<String, Estudiante> estudiantes;
  private Map<String, Profesor> profesores;
  private Map<String, AdministracionServicios> pas;

  public Centro() {
    estudiantes = new HashMap<>();
    profesores = new HashMap<>();
    pas = new HashMap<>();
  }

  /**
   * Da de alta a un estudiante
   * 
   * @param estudiante
   */
  public void alta(Estudiante estudiante) {
    estudiantes.put(estudiante.getDni(), estudiante);
  }

  /**
   * Da de alta a un profesor
   * 
   * @param profesor
   */
  public void alta(Profesor profesor) {
    profesores.put(profesor.getDni(), profesor);
  }

  /**
   * Da de alta a un empleado de administracion
   * 
   * @param personal
   */
  public void alta(AdministracionServicios personal) {
    pas.put(personal.getDni(), personal);
  }

  public void baja(String dni) {
    estudiantes.remove(dni);
    profesores.remove(dni);
    pas.remove(dni);
  }

  public void imprimir() {
    // Para cada estudiante
    System.out.println("Estudiantes");
    System.out.println("-----------");
    for (Estudiante estudiante : estudiantes.values()) {
      // Lo imprime
      System.out.println(estudiante);
    }

    // Para cada profesor
    System.out.println();
    System.out.println("Profesores");
    System.out.println("----------");
    for (Profesor profesor : profesores.values()) {
      // Lo imprime
      System.out.println(profesor);
    }

    // Para cada PAS
    System.out.println();
    System.out.println("Personal de Administración y Servicios");
    System.out.println("--------------------------------------");
    for (AdministracionServicios personal : pas.values()) {
      // Lo imprime
      System.out.println(personal);
    }

  }

}
