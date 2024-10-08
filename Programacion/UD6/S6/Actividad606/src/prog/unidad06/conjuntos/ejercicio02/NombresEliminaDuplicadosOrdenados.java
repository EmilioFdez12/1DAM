package prog.unidad06.conjuntos.ejercicio02;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NombresEliminaDuplicadosOrdenados {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("NOMBRES DUPLICADOS II");
    // TreeSet para ordenar alfabeticamente
    Set<String> conjunto = new TreeSet<>();
    String entradaTexto = " ";

    while (!entradaTexto.isEmpty()) {
      System.out.print("Introduzca un nombre (vacío para terminar): ");
      entradaTexto = sc.nextLine();
      conjunto.add(entradaTexto);
    }

    System.out.println("Los nombres introducidos sin duplicados son: ");
    for (String nombre : conjunto) {
      if (!nombre.isBlank()) {
        System.out.println(nombre);
      }
    }

  }
}
