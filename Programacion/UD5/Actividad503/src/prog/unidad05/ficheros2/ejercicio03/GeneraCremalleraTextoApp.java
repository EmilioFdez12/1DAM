package prog.unidad05.ficheros2.ejercicio03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneraCremalleraTextoApp {

  public static void main(String[] args) {
    String fichero1 = null;
    String fichero2 = null;
    List<String> archivo1 = new ArrayList<>();
    List<String> archivo2 = new ArrayList<>();

    if (args.length > 0) {
      fichero1 = args[0];
      fichero2 = args[1];
    }

    // Leemos el primer archivo y almacenamos en una lista cada linea
    try (BufferedReader flujoEntrada = new BufferedReader(new FileReader(fichero1))) {
      String linea = null;
      do {
        linea = flujoEntrada.readLine();
        if (linea != null) {
          archivo1.add(linea);
        }

      } while (linea != null);

    } catch (FileNotFoundException e) {
      System.out.println("No se ha encontrado el archivo");
    } catch (IOException e) {
      System.out.println("No se puede leer el archivo");
    }

    // Leemos el segundo archivo y almacenamos en una lista cada linea
    try (BufferedReader flujoEntrada = new BufferedReader(new FileReader(fichero2))) {
      String linea = null;
      do {
        linea = flujoEntrada.readLine();
        if (linea != null) {
          archivo2.add(linea);
        }

      } while (linea != null);

    } catch (FileNotFoundException e) {
      System.out.println("No se ha encontrado el archivo");
    } catch (IOException e) {
      System.out.println("No se puede leer el archivo");
    }

    int contador = 2;
    List<String> lineasArchivos = new ArrayList<>();

    for (int i = 0; i < archivo1.size() || i < archivo2.size(); i++) {
      if (i < archivo1.size()) {
        lineasArchivos.add(archivo1.get(i));
      }
      if (i < archivo2.size()) {
        lineasArchivos.add(archivo2.get(i));
      }
      contador++;
    }

    int totalLineas = lineasArchivos.size();
    for (int i = 0; i < totalLineas - 1; i++) {
      System.out.printf("%s%n", lineasArchivos.get(i));
    }
    // Imprime la última línea sin un salto de línea adicional
    if (totalLineas > 0) {
      System.out.print(lineasArchivos.get(totalLineas - 1));
    }

  }
}
