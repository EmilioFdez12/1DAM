package prog.unidad06.listas.ejercicio05;

import java.util.ArrayList;
import java.util.List;

public class MezclaListasCadenas {

  public MezclaListasCadenas() {

  }

  public static List<String> diferencia(List<String> lista, List<String> otraLista) {
    if (lista != null && otraLista != null) {
      List<String> arrayDiferencia = new ArrayList<>();
      for (String elemento : lista) {
        if (!otraLista.contains(elemento) && !arrayDiferencia.contains(elemento)) {
          arrayDiferencia.add(elemento);
        }
      }
      return arrayDiferencia;
    } else {
      throw new IllegalArgumentException("Las listas no pueden ser nulas");
    }
  }

  public static List<String> interseccion(List<String> lista, List<String> otraLista) {
    if (lista != null && otraLista != null) {
      List<String> arrayInterseccion = new ArrayList();
      // si esta en la lista, y no esta en el resultado
      for (String elemento : lista) {
        if (otraLista.contains(elemento) && !arrayInterseccion.contains(elemento)) {
          arrayInterseccion.add(elemento);
        }
      }
      return arrayInterseccion;
    } else {
      throw new IllegalArgumentException();
    }
  }

  public static List<String> union(List<String> lista, List<String> otraLista) {
    if (lista != null && otraLista != null) {

      List<String> arrayUnion = new ArrayList<>();

      for (String elemento : lista) {
        if (!arrayUnion.contains(elemento)) {
          arrayUnion.add(elemento);
        }
      }

      for (String elemento : otraLista) {
        if (!arrayUnion.contains(elemento)) {
          arrayUnion.add(elemento);
        }
      }

      return arrayUnion;
    } else {
      throw new IllegalArgumentException();
    }
  }
}
