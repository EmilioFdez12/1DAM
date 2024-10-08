package prog.unidad06.listas.ejercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListaEnterosUtils {

  public ListaEnterosUtils() {

  }

  public static List<Integer> generaListaEnterosAleatorios(int longitudMin, int longitudMax, int valorMin,
      int valorMax) {
    Random random = new Random();

    if (longitudMin >= 0 && longitudMax >= longitudMin) {
      int longitud = random.nextInt(longitudMin, longitudMax + 1);

      if (valorMin <= valorMax) {
        List<Integer> resultado = new ArrayList<>();

        for (int i = 0; i < longitud; i++) {
          int valor = random.nextInt(valorMin, valorMax + 1);
          resultado.add(valor);
        }
        return resultado;
      } else {
        throw new IllegalArgumentException();
      }

    } else {
      throw new IllegalArgumentException();
    }
  }

  public static String generaCadena(List<Integer> lista) {
    String salida = "";
    if (lista != null) {
      salida = "(";

      boolean coma = false;
      for (int valor: lista) {
        if (coma) {
          salida += ", ";
        } else {
          coma = true;
        }
        salida += valor;
      }
      salida += ")";
    }
    return salida;
  }
  
}
