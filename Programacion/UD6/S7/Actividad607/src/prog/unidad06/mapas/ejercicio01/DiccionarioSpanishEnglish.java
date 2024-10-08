package prog.unidad06.mapas.ejercicio01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DiccionarioSpanishEnglish {
  private static Map<String, String> diccionario;

  public DiccionarioSpanishEnglish() {
    diccionario = new HashMap<>();

    cargarDiccionario();
  }

  public String traducir(String palabra) {
    if (palabra.isBlank()) {
      throw new IllegalArgumentException("Programa Terminado");
    }
        
    return diccionario.get(palabra);
  }

  public Set<String> getPalabraSpanish() {
    return diccionario.keySet();
  }

  private static void cargarDiccionario() {
    diccionario.put("girar", "spin");
    diccionario.put("sorpresa", "surprise");
    diccionario.put("maceta", "pot");
    diccionario.put("historiador", "historian");
    diccionario.put("enjuagar", "rinse");
    diccionario.put("casilla", "square");
    diccionario.put("signo", "sign");
    diccionario.put("importar", "import");
    diccionario.put("profesional", "professional");
    diccionario.put("ficha", "piece");
    diccionario.put("patines", "skates");
    diccionario.put("historia", "history");
    diccionario.put("tornillo", "screw");
    diccionario.put("cantante", "singer");
    diccionario.put("insulto", "insult");
    diccionario.put("firma", "sign");
    diccionario.put("lechuga", "lettuce");
    diccionario.put("tiza", "chalk");
    diccionario.put("adoptar", "adopt");
    diccionario.put("pila", "battery");
    diccionario.put("ciudad", "city");
    diccionario.put("rail", "rail");
    diccionario.put("frontera", "border");
    diccionario.put("prisionero", "prisoner");
    diccionario.put("capullo", "cocoon");
    diccionario.put("anchoa", "anchovy");
    diccionario.put("opinión", "opinion");
    diccionario.put("pierna", "leg");
    diccionario.put("hábito", "habit");
    diccionario.put("hueso", "bone");
  }

}
