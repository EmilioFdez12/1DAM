package prog.unidad05.ficheros2.ejercicio02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListaPrimosTextoApp {

  public static void main(String[] args) {
    String rutaArchivo = "C:\\Users\\alumnado\\Desktop\\primos.txt";
    List<String> lineas = new ArrayList<>();
    try (BufferedReader flujoEntrada = new BufferedReader(new FileReader(rutaArchivo))) {
      String linea = null;
      do {
        linea = flujoEntrada.readLine();
        if (linea != null) {
          lineas.add(linea);
        }

      } while (linea != null);
    } catch (FileNotFoundException e) {
      System.out.println("No se ha encontrado el fichero");
    } catch (IOException e) {
      System.out.println("No se puede leer el archivo");
    }

    for (String linea : lineas) {
      System.out.println(linea);
    }
  }
}
