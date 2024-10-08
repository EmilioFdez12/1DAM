package prog.unidad05.ficheros.ejercicio03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CuentaBytesEnArchivoApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Ruta del fichero
    String rutaFichero = null;
    // byteBuscado
    int byteBuscado = 0;
    // Lista para almacenar las líneas
    List<Integer> bytes = new ArrayList<>();

    // Si se proporciona la ruta por línea de comandos
    if (args.length > 0) {
      rutaFichero = args[0];
      System.out.print("Introduce el valor del byte a contabilizar: ");
      byteBuscado = Integer.parseInt(sc.nextLine());
      // Si no
    } else {
      System.out.print("Introduce la ruta al fichero:");
      rutaFichero = sc.nextLine();
      System.out.print("Introduce el valor del byte a contabilizar: ");
      byteBuscado = Integer.parseInt(sc.nextLine());
    }

    try (FileInputStream flujoEntrada = new FileInputStream(rutaFichero)) {
      int byteArchivo = -1;
      // mientras lso bytes del archivo no sean -1
      do {
        // Le uno a uno los bytes del archivo
        byteArchivo = flujoEntrada.read();
        if (byteArchivo != 1) {
          // mete todos lo bytes en una lista
          bytes.add(byteArchivo);
        }
      } while (byteArchivo != -1);

    } catch (FileNotFoundException e) {
      System.out.println("No se ha encontrado el fichero");
    } catch (IOException e) {
      System.out.println("No se puede leer el archivo");
    }

    int contadorBytes = 0;
    // Para cada byte de la lista
    for (int byteLista: bytes) {
      // Si el byte es igual al que se busca
      if (byteLista == byteBuscado) {
        contadorBytes++;
      }
    }

    System.out.println("El byte " + byteBuscado + " aparece " + contadorBytes + " veces en el fichero " + rutaFichero);
  }
}
