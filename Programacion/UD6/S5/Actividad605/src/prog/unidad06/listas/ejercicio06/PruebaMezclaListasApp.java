package prog.unidad06.listas.ejercicio06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import prog.unidad06.listas.ejercicio05.MezclaListasCadenas;

public class PruebaMezclaListasApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("MEZCLA DE LISTAS");

    List<String> lista1 = new ArrayList<>();
    List<String> lista2 = new ArrayList<>();

    String entradaTexto = " ";
    String entradaTexto2 = " ";

    System.out.println("Introduce la primera lista de palabras");
    System.out.println("Introduce palabras, una por línea. Línea vacía para terminar");
    while (!entradaTexto.isEmpty()) {
      entradaTexto = sc.nextLine();
      lista1.add(entradaTexto);
    }

    System.out.println("Introduce la segunda lista de palabras");
    System.out.println("Introduce palabras, una por línea. Línea vacía para terminar");
    while (!entradaTexto2.isEmpty()) {
      entradaTexto2 = sc.nextLine();
      lista2.add(entradaTexto2);
    }

    System.out.println("La primera lista es: " + listaToString(lista1));
    System.out.println("Y la segunda lista es: " + listaToString(lista2));

    List<String> listaUnion = MezclaListasCadenas.union(lista1, lista2);
    List<String> listaInterseccion = MezclaListasCadenas.interseccion(lista1, lista2);
    List<String> listaDiferencia= MezclaListasCadenas.diferencia(lista1, lista2);
    List<String> listaDiferenciaInversa= MezclaListasCadenas.diferencia(lista2, lista1);
    
    System.out.println("La union de ambas listas es: " + listaToString(listaUnion));
    System.out.println("La interseccion de ambas listas es: " + listaToString(listaInterseccion));
    System.out.println("La diferencia de la primera lista menos la segunda es: " + listaToString(listaDiferencia));
    System.out.println("La diferencia de la segunda lista menos la primera es: " + listaToString(listaDiferenciaInversa));
    

  }

  private static String listaToString(List<String> lista) {
    String resultado = "[";
    boolean isLast = true;
    for (String elemento : lista) {
      if (!elemento.isEmpty()) {
        // si no es el ultimo pon coma
        if (!isLast) {
          resultado += ", ";
        } else {
          isLast = false;
        }
        resultado += "\"" + elemento + "\"";
      }
    }
    resultado += "]";
    return resultado;
  }

}
