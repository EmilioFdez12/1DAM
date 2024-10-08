package prog.unidad05.ficheros.ejercicio05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreceDiscosApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String rutaArchivo = null;
    boolean anyadir = false;
    // Datos CD
    String tituloDisco;
    String autorDisco;
    int anyoPublicacion;
    double precioDisco;
    String esDisco;
    boolean disco = false;
    List<Disco> listaDiscos = new ArrayList<>();
    List<String> lineas = new ArrayList<String>();
    
    if (args.length > 0) {
      rutaArchivo = args[0];
    } else {
      System.out.print("Introduzca la ruta donde quieras crear el archivo: ");
      rutaArchivo = sc.nextLine();
    }
    
//    rutaArchivo = "C:\\Users\\alumnado\\Desktop\\disco.dat";

    // Lee el archivo
    // Si no existe esta vacio
    try (BufferedReader flujoEntrada = new BufferedReader(new FileReader(rutaArchivo))) {
      String linea = null;
      do {
        linea = flujoEntrada.readLine();
        if (linea != null) {
          lineas.add(linea);
        }

      } while (linea != null);
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
      System.out.println("No se puede leer el archivo");
    }
    
    if (lineas.isEmpty()) {
      System.out.println("La coleccion está vacia");
    }
        
    // Imprimo las lineas que tiene el archivo
    for (String linea: lineas) {
      System.out.println(linea);     
    }
      
    // Preguntamos para crear el disco
    System.out.println("Introduce los datos del nuevo disco");
    System.out.print("Introduce el titulo del disco (no puede dejarse en blanco): ");
    tituloDisco = sc.nextLine();
    System.out.print("Introduce el nombre del autor del disco (no puede dejarse en blanco): ");
    autorDisco = sc.nextLine();
    System.out.print("Introduce el año de publicación del disco (entero positivo): ");
    anyoPublicacion = Integer.parseInt(sc.nextLine());
    System.out.print("Introduce el precio del disco (real positivo): ");
    precioDisco = Double.parseDouble(sc.nextLine());
    System.out.print("¿Es el disco un CD? (s/n)");
    esDisco = sc.nextLine();

    if (esDisco.equalsIgnoreCase("s")) {
      disco = true;
    } else if (esDisco.equalsIgnoreCase("n")) {
      disco = false;
    }

    // Creamos el disco y lo metemos en una lista
    Disco discoAñadir = new Disco(tituloDisco, autorDisco, anyoPublicacion, precioDisco, disco);
    listaDiscos.add(discoAñadir);

    // Escribimos en el archivo
    // True para que NO se superponga
    try (PrintWriter flujoSalida = new PrintWriter(new FileWriter(rutaArchivo, true))) {
      for (Disco discoGuardado : listaDiscos) {
        String infoDisco = discoAñadir.imprimirDisco(discoAñadir);
        flujoSalida.println(infoDisco);
      }
    } catch (IOException e) {
      System.out.println("No se ha podido crear el archivo");
    }
  }

}
