package prog.unidad05.consola.ejercicio03;

import java.util.Scanner;

public class ImpresorTablaRealApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Introduzca el número de filas:");
    int filas = Integer.parseInt(sc.nextLine());
    System.out.print("Introduzca el número de columnas:");
    int columnas = Integer.parseInt(sc.nextLine());
    
    ImpresorTablaReal tabla = new ImpresorTablaReal(filas, columnas);
   
    System.out.println();
    System.out.println("Tabla " + filas + "x" + columnas);
    System.out.println("-----------");
    tabla.imprimeTabla(2);
  }
}
