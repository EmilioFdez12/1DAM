package prog.unidad04.atributos.personas;

import java.util.Scanner;

import prog.unidad04.atributos.Persona;

/**
 * Prueba la clase Persona
 */
public class PersonasApp{

  /**
   * Punto de entrada a la aplicación
   * @param args
   */
  public static void main(String[] args) {
    // Creamos Scanner para leer desde teclado
    Scanner sc = new Scanner(System.in);
    
    // Mostramos cabecera
    System.out.println("PROGRAMA DE MANEJO DE PERSONAS");
    // Solicitamos la cantidad de personas a crear (debe ser mayor o igual a 1)
    int personasACrear = 0;
    do {
      // 
      try {
        System.out.print("Introduzca la cantidad de personas a crear (1 o mas): ");
        personasACrear = Integer.parseInt(sc.nextLine());
        // Si valor no valido
        if (personasACrear < 1) {
          // Mensaje
          System.out.println("El valor no es válido. Debe introducir un número entero mayor que cero. Inténtelo de nuevo");
        }
      } catch (NumberFormatException e) {
        // Mensaje
        System.out.println("El valor no es válido. Debe introducir un número entero mayor que cero. Inténtelo de nuevo");
      }
    } while (personasACrear < 1);
    
    // Para cada persona
    for (int i = 0; i < personasACrear; i++) {
      // Creamos la persona
      Persona persona = new Persona();
      // Solicitamos los datos de la persona
      System.out.println("Introduce los datos de la persona " + (i + 1));
      System.out.print("Introduce el nombre de la persona: ");
      persona.nombre = sc.nextLine();
      System.out.print("Introduce la edad de la persona (debe ser mayor o igual a cero): ");
      persona.edad = Integer.parseInt(sc.nextLine());
      if (persona.edad >= 0) {
        System.out.print("Introduce el DNI de la persona (debe constar de 8 números y una letra): ");
        persona.dni = sc.nextLine();
        if (persona.dni.length() == 9) {
          System.out.print("Introduce el sexo de la persona (H = Hombre, M = Mujer): ");
          persona.sexo = sc.nextLine().toUpperCase().charAt(0);
          if ((persona.sexo == 'H') || (persona.sexo == 'M')) {
            System.out.print("Introduce el peso de la persona (en kilogramos. Debe ser mayor que cero): ");
            persona.peso = Double.parseDouble(sc.nextLine());
            if (persona.peso > 0) {
              System.out.print("Introduce la altura de la persona (en metros. Debe ser mayor que cero): ");
              persona.altura = Double.parseDouble(sc.nextLine());
              if (persona.altura > 0) {
                // Imprimirmos la persona
                System.out.println("Datos de la persona " + (i + 1));
                System.out.println("Nombre: " + persona.nombre);
                System.out.println("Edad: " + persona.edad);
                System.out.println("DNI: " + persona.dni);
                System.out.println("Sexo: " + persona.sexo);
                System.out.println("Peso: " + persona.peso);
                System.out.println("Altura: " + persona.altura);
              } else {
                System.err.println("Error. La altura de la persona debe ser mayor que cero");
              }
            } else {
              System.out.println("Error. El peso de la persona debe ser mayor que cero");
            }
          } else {
            System.out.println("Error. El sexo de la persona debe ser H o M");
          }
        } else {
          System.out.println("Error. El DNI debe constar de 9 caracteres");
        }
      } else {
        System.out.println("Error. La edad de la persona debe ser mayor o igual a cero");
      }
      sc.close();
    }
  }
}
