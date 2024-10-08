package prog.unidad05.ficheros2.ejercicio01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GeneraPrimosTextoApp {

  public static void main(String[] args) {
    String rutaArchivo = "C:\\Users\\alumnado\\Desktop\\primos.txt";

    try (PrintWriter flujoSalida = new PrintWriter(new FileWriter(rutaArchivo))) {
      // Del 2 al 500
      for (int numero = 2; numero <= 500; numero++) {
        boolean esPrimo = true;
        if (numero <= 1) {
          esPrimo = false;
        } else {
          for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
              esPrimo = false;
            }
          }
        }
        if (esPrimo) {
          flujoSalida.println(numero);
        }
      }
    } catch (IOException e) {
      System.out.println("No se ha podido crear el archivo.");
      e.printStackTrace();
    }
  }
}
