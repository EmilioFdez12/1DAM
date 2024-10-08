package prog.unidad06.listas.ejercicio04;

import java.util.ArrayList;
import java.util.List;

public class ListaPalabrasRepetidas {

  private List<String> listaPalabras = new ArrayList<>();

  public ListaPalabrasRepetidas() {

  }

  public void add(String cadena) {
    if (!listaPalabras.contains(cadena)) {
      listaPalabras.add(cadena);
    }
  }

  public String obtenerResumen() {
    String salida = "(";

    boolean coma = false;
    for (String valor : listaPalabras) {
      if (coma) {
        salida += ", ";
      } else {
        coma = true;
      }
      salida += "\"" + valor + "\"";
    }
    salida += ")";

    return salida;
  }

}
