package prog.unidad06.listas.ejercicio02;

import java.util.List;

import prog.unidad06.listas.ejercicio01.ListaEnterosUtils;

public class EstadisticasApp {

  public static void main(String[] args) {

    List<Integer> lista = ListaEnterosUtils.generaListaEnterosAleatorios(10, 20, 0, 100);

    System.out.print("La lista generada es: ");
    System.out.println(ListaEnterosUtils.generaCadena(lista));

    double suma = 0;
    double media = 0;
    int maximo = lista.get(0);
    int minimo = lista.get(0);
    for (int valor : lista) {
      suma += valor;
      media = (suma / lista.size());

      if (valor > maximo) {
        maximo = valor;
      }

      if (valor < minimo) {
        minimo = valor;
      }

    }

    System.out.println("La suma de los elementos vale: " + suma + " su media vale " + media + ". El valor mínimo es "
        + minimo + " y el valor máximo es " + maximo);

  }

}
