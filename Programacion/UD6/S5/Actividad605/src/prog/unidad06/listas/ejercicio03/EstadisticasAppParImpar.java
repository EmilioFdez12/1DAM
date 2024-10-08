package prog.unidad06.listas.ejercicio03;

import java.util.ArrayList;
import java.util.List;

import prog.unidad06.listas.ejercicio01.ListaEnterosUtils;

public class EstadisticasAppParImpar {

  public static void main(String[] args) {

    List<Integer> lista = ListaEnterosUtils.generaListaEnterosAleatorios(10, 20, 0, 100);
    List<Integer> listaPares = filtrarPares(lista);
    List<Integer> listaImpares = filtrarImpares(lista);

    System.out.println("ESTADÍSTICAS II");
    System.out.print("La lista generada es: ");
    System.out.println(ListaEnterosUtils.generaCadena(lista));
    System.out.println("La lista filtrada de pares es " + ListaEnterosUtils.generaCadena(listaPares));
    System.out.println("La lista filtrada de impares es " + ListaEnterosUtils.generaCadena(listaImpares));

    // Suma pares
    double suma = 0;
    double media = 0;
    int maximo = listaPares.get(0);
    int minimo = listaPares.get(0);
    for (int valor : listaPares) {

      suma += valor;
      media = (suma / lista.size());

      if (valor > maximo) {
        maximo = valor;
      }

      if (valor < minimo) {
        minimo = valor;
      }

    }
    
    System.out.println("La suma de los elementos de la lista par es: " + suma);
    System.out.println("La media de los elementos de la lista par es: " + media);
    System.out.println("El mínimo vale " + minimo + " y el máximo vale " + maximo);
    
    // Suma pares
     suma = 0;
     media = 0;
     maximo = listaImpares.get(0);
     minimo = listaImpares.get(0);
    for (int valor : listaImpares) {

      suma += valor;
      media = (suma / lista.size());

      if (valor > maximo) {
        maximo = valor;
      }

      if (valor < minimo) {
        minimo = valor;
      }

    }
    
    System.out.println("La suma de los elementos de la lista impar es: " + suma);
    System.out.println("La media de los elementos de la lista impar es: " + media);
    System.out.println("El mínimo vale " + minimo + " y el máximo vale " + maximo);
  
  }

  private static List<Integer> filtrarPares(List<Integer> lista) {
    List<Integer> resultado = new ArrayList<>();
    
    for (int elemento: lista) {
      if (elemento % 2 == 0) {
        resultado.add(elemento);
      }
    }
    return resultado;
  }

  private static List<Integer> filtrarImpares(List<Integer> lista) {
    List<Integer> resultado = new ArrayList<>();

    for (int elemento : lista) {
      if (elemento % 2 != 0) {
        resultado.add(elemento);
      }
    }
    return resultado;
  }

}