package prog.unidad05.ficheros.ejercicio02;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscribeFicherosTextoApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean anyadir = false;
    String rutaArchivoACrear = "";
    String linea = " ";

    System.out.print("Introduce la ruta al archivo a crear:");
    rutaArchivoACrear = sc.nextLine();

    try (PrintWriter flujoSalida = new PrintWriter(new FileWriter(rutaArchivoACrear, anyadir))) {
      System.out.println("Fichero iniciado con éxito. Introduzca el texto a almacenar línea a línea y una línea "
          + "vacía para terminar");
      do {
        System.out.print("Texto de la línea: ");
        linea = sc.nextLine();
        if (!linea.isBlank()) {
          flujoSalida.println(linea);
          
        }
      } while (!linea.isBlank());

    } catch (IOException e) {
      System.out.println("No se ha podido crear el archivo");
    }
  }
}
