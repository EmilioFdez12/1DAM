package prog.unidad04.atributos.personas;

import prog.unidad04.atributos.Persona;

import java.util.Scanner;

public class PersonasApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Introduzca la cantidad de personas a crear: ");
    int numPersonas = Integer.parseInt(sc.nextLine());

    for (int i = 1; i <= numPersonas; i++) {
      Persona persona = new Persona();

      System.out.println("Introduce los datos de la persona " + i);

      System.out.print("Introduce la edad de la persona (mayor o igual a 0): ");
      persona.edad = Integer.parseInt(sc.nextLine());
      System.out.print("Introduce el DNI de la persona(8 números y 1 letra): ");
      persona.dni = sc.nextLine();
      System.out.print("Introduce el sexo de la persona (H = " + persona.SEXO_HOMBRE + 
          ", M = " + persona.SEXO_MUJER + ": ");
      
      System.out.print("Introduce el peso de la persona (en Kg)");
      persona.peso = Double.parseDouble(sc.nextLine());
      System.out.print("Introduce la altura de la persona (en metros)");
      persona.altura = Double.parseDouble(sc.nextLine());

      System.out.println("Datos de la persona " + i);
      System.out.println("Edad: " + persona.edad);
      System.out.println("DNI: " + persona.dni);
      System.out.println("Sexo: " + persona.
      System.out.println("Peso: " + persona.);
      System.out.println("Altura: " + persona.altura);

    }

    sc.close();

  }

}
