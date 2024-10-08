package prog.unidad04.actividad403.ejercicio02;

import java.util.Random;

public class Persona {

  private String nombre;
  private int edad;
  private char sexo;
  private double peso;
  private double estatura;
  private double imc;
  private boolean mayorEdad;
  private String dni;

  public Persona() {
    this.nombre = "";
    this.edad = 0;
    this.sexo = 'M';
    this.peso = 0.0;
    this.estatura = 0.0;
    this.generarDNI();
  }

  /**
   * 
   * @param nombre
   * @param edad
   * @param sexo
   */
  public Persona(String nombre, int edad, char sexo) {
    this.nombre = nombre;
    this.edad = edad;
    this.sexo = sexo;
  }

  /**
   * 
   * @param nombre
   * @param edad
   * @param sexo
   * @param peso
   * @param estatura
   */
  public Persona(String nombre, int edad, char sexo, double peso, double estatura) {
    this.nombre = nombre;
    this.edad = edad;
    this.sexo = sexo;
    this.peso = peso;
    this.estatura = estatura;
    
    if(edad <= 0) {
      throw new IllegalArgumentException();
    }
    
    if( sexo != 'H' && sexo != 'M') {
      throw new IllegalArgumentException();
    }
    
    if(peso <= 0) {
      throw new IllegalArgumentException();
    }
    
    if(estatura <= 0) {
      throw new IllegalArgumentException();
    }
    

    if (estatura == 0) {
      imc = 0;
    } else
      imc = (peso / (estatura * estatura));

    if (edad >= 18) {
      mayorEdad = true;
    } else {
      mayorEdad = false;
    }
  }

  private String generarDNI() {
    this.dni = "";
    
    // Generar número aleatorio de 8 dígitos.
    Random generador = new Random();
    int dniEnt = generador.nextInt(10000000, 99999999);
    
    // Convierto de int a String.
    String dni = Integer.toString(dniEnt);
    
    // Se calcula la letra y se concatena con la parte numérica.
    if (dniEnt % 23 == 0) {
      this.dni = (dni + 'T');
    } else if (dniEnt % 23 == 1) {
      this.dni = (dni + 'R');
    } else if (dniEnt % 23 == 2) {
      this.dni = (dni + 'W');
    } else if (dniEnt % 23 == 3) {
      this.dni = (dni + 'A');
    } else if (dniEnt % 23 == 4) {
      this.dni = (dni + 'G');
    } else if (dniEnt % 23 == 5) {
      this.dni = (dni + 'M');
    } else if (dniEnt % 23 == 6) {
      this.dni = (dni + 'Y');
    } else if (dniEnt % 23 == 7) {
      this.dni = (dni + 'F');
    } else if (dniEnt % 23 == 8) {
      this.dni = (dni + 'P');
    } else if (dniEnt % 23 == 9) {
      this.dni = (dni + 'D');
    } else if (dniEnt % 23 == 10) {
      this.dni = (dni + 'X');
    } else if (dniEnt % 23 == 11) {
      this.dni = (dni + 'B');
    } else if (dniEnt % 23 == 12) {
      this.dni = (dni + 'N');
    } else if (dniEnt % 23 == 13) {
      this.dni = (dni + 'J');
    } else if (dniEnt % 23 == 14) {
      this.dni = (dni + 'Z');
    } else if (dniEnt % 23 == 15) {
      this.dni = (dni + 'S');
    } else if (dniEnt % 23 == 16) {
      this.dni = (dni + 'Q');
    } else if (dniEnt % 23 == 17) {
      this.dni = (dni + 'V');
    } else if (dniEnt % 23 == 18) {
      this.dni = (dni + 'H');
    } else if (dniEnt % 23 == 19) {
      this.dni = (dni + 'L');
    } else if (dniEnt % 23 == 20) {
      this.dni = (dni + 'C');
    } else if (dniEnt % 23 == 21) {
      this.dni = (dni + 'K');
    } else if (dniEnt % 23 == 22) {
      this.dni = (dni + 'E');
    }
    
    return this.dni;
  }

  public double getIMC() {
    return imc;
  }

  public int getPesoCorrecto() {
    if (imc < 20) {
      return -1;
    } else if (imc <= 25) {
      return 0;
    } else {
      return 1;
    }
  }

  public boolean esMayorDeEdad() {
    return mayorEdad;
  }

  public String obtenerCadena() {
    return "Nombre: " + nombre + "\sEdad: " + edad + "\sSexo: " + sexo + "\sPeso: " + peso + "\sEstatura: " + estatura
        + "\sDNI: " + dni;
  }

  
}
