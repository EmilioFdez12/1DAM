package prog.unidad07.relacion02.ejercicio04;

import java.util.HashMap;
import java.util.Map;

public class Centro {

  private Map<String, Persona> personas;


  public Centro() {
    personas = new HashMap<>();
  }

  /**
   * Da de alta a un estudiante
   * 
   * @param estudiante
   */
  public void alta(Persona persona) {
    personas.put(persona.getDni(), persona);
  }

  public void baja(String dni) {
    personas.remove(dni);
  }

  public void imprimir() {
    // Para cada estudiante
    System.out.println("Personas");
    System.out.println("-----------");
    for (Persona persona : personas.values()) {
      // Lo imprime
      System.out.println(persona);
    }
  }

}
