package prog.unidad05.ficheros.ejercicio01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MuestraFicherosTextoApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String rutaFichero = null; // javaLenguajeProgramacion.txt

    // Si se proporciona la ruta por línea de comandos
    if (args.length > 0) {
      rutaFichero = args[0];
    } else {
      System.out.print("Introduce la ruta al fichero:");
      rutaFichero = sc.nextLine();
    }

    // Lista para almacenar las líneas
    List<String> lineas = new ArrayList<>();

    try (BufferedReader flujoEntrada = new BufferedReader(new FileReader(rutaFichero))) {
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

    for (String linea: lineas) {
      System.out.println(linea);     
    }
    
    
  }
}
