package prog.unidad05.ficheros.ejercicio04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class FicheroBytesAleatorios {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    // Ruta del fichero
    String rutaFichero = null;
    boolean anyadir = true;
    int longitud = 0;
    int limiteInferior = 0;
    int limiteSuperior = 0;
    Random random = new Random();
    

    if (args.length > 0) {
      rutaFichero = args[0];
      System.out.print("Introduzca la longitud del fichero a crear (en btyes): ");
      longitud = Integer.parseInt(sc.nextLine());
      System.out.print("ntroduzca el limite inferior del rango de extracción de bytes aleatorios (0-255):");
      limiteInferior = Integer.parseInt(sc.nextLine());
      System.out.print("ntroduzca el limite superior del rango de extracción de bytes aleatorios (0-255):");
      limiteSuperior = Integer.parseInt(sc.nextLine());
      // Si no
    } else {
      System.out.print("Introduzca la ruta al archivo a crear:");
      rutaFichero = sc.nextLine();
      System.out.print("Introduzca la longitud del fichero a crear (en btyes): ");
      longitud = Integer.parseInt(sc.nextLine());
      System.out.print("Introduzca el limite inferior del rango de extracción de bytes aleatorios (0-255):");
      limiteInferior = Integer.parseInt(sc.nextLine());
      System.out.print("Introduzca el limite superior del rango de extracción de bytes aleatorios (0-255):");
      limiteSuperior = Integer.parseInt(sc.nextLine());
    }
       
    
    try (FileOutputStream flujoSalida = new FileOutputStream(rutaFichero, anyadir)) {
      System.out.println("Fichero iniciado con éxito");
      
      for (int i = 0; i < longitud; i++) {
        // Byte random dentro del rango
        int byteRandom =  random.nextInt(limiteInferior,limiteSuperior);
        flujoSalida.write(byteRandom);
      }
      
    } catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
		} catch (IOException e) {
			System.out.println("No se ha creado el archivo");
		}
  }

}
