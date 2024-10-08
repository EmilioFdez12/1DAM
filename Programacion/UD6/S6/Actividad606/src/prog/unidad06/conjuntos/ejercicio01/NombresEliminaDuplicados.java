package prog.unidad06.conjuntos.ejercicio01;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NombresEliminaDuplicados {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("NOMBRES DUPLICADOS I");
    
    Set<String> conjunto = new HashSet<>();   
    String entradaTexto = " ";
    
    while(!entradaTexto.isEmpty()) {   
    System.out.print("Introduzca un nombre (vacío para terminar): ");
    entradaTexto = sc.nextLine();
    conjunto.add(entradaTexto);
    }
    
    System.out.println("Los nombres introducidos sin duplicados son: ");
    for (String nombre: conjunto) {
      if (!nombre.isBlank()) {
        System.out.println(nombre);
      }
      
    }
    
    
    
  }

}
