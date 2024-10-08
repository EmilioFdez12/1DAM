package r03e05;

import java.util.Scanner;

public class CalculadoraSalariosApp {

  // Creacion de constantes segun el salario si es extra o no
  public static double SALARIO = 16;
  public static double SALARIOEXTRA = 20;
  public static double HORASBASE = 40;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Introduce las horas trabajadas esta semana: ");
    double horasTrabajadas = Double.parseDouble(sc.nextLine());

    if (horasTrabajadas <= 40) {
      double salario = (SALARIO * horasTrabajadas);
      System.out.println("El salario por trabajar " + horasTrabajadas + " horas es de " + salario + "€");
    } else if (horasTrabajadas > 40) {
      // variables muchas
      double horasExtra = (horasTrabajadas - 40);
      double horasBase = (horasTrabajadas - horasExtra);
      double salarioextra = (horasExtra * SALARIOEXTRA);
      double salario = (SALARIO * horasBase);
      System.out.println("El salario por trabajar " + HORASBASE + " horas normales y " + horasExtra + " horas extra es "
          + (salario + salarioextra) + "€");
    }
    sc.close();
  }
}
