package prog.unidad05.ficheros2.ejercicio04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuitaComentariosApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String fichero1 = null;
    String ficheroSalida = null;
    List<String> archivoJava = new ArrayList<>();

    if (args.length > 0) {
      fichero1 = args[0];
      ficheroSalida = args[1];
    } else {
      System.out.print("Ponga la ruta del archivo al que se le van a quitar los comentarios: ");
      fichero1 = sc.nextLine();
      System.out.print("Ponga la ruta del archivo (resultado): ");
      ficheroSalida = sc.nextLine();
    }

    // Leemos el primer archivo y almacenamos en una lista cada linea
    try (BufferedReader flujoEntrada = new BufferedReader(new FileReader(fichero1))) {
      String linea = null;
      do {
        linea = flujoEntrada.readLine();

        if (linea != null) {
          archivoJava.add(linea);
        }
      } while (linea != null);

    } catch (FileNotFoundException e) {
      System.out.println("No se ha encontrado el archivo");
    } catch (IOException e) {
      System.out.println("No se puede leer el archivo");
    }

    // Creamos un archivo y solo escrbimos las lineas sin comentarios
    try (PrintWriter flujoSalida = new PrintWriter(new FileWriter(ficheroSalida))) {
      for (String linea : archivoJava) {
        // Si la linea sin espacios no es nula
        if (linea != null || !linea.trim().isEmpty()) {
          // Y empieza por //
          if (!linea.trim().startsWith("//")) {
            // añade la línea
            flujoSalida.println(linea);
          }
        }        
      }
      System.out.println("Archivo creado con éxito");
    } catch (IOException e) {
      System.out.print("Error");
    }

  }

}
