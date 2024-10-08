package prog.unidad04.actividad204.ejercicio04.prueba;

import prog.unidad04.actividad204.ejercicio04.Zona;



import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class ZonasPrueba {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Varibales del numero de asientos que hay

    int seleccion;
    try {
      Zona zona1 = new Zona(-5);
      Zona zona2 = new Zona(50);
      Zona zona3 = new Zona(100);
    } catch (ZonaException) {
      
    }
    

    do {

      System.out.println("GESTION DE ENTRADAS");
      System.out.println("-------------------");

      System.out.println("1.- Mostrar asientos libres por zona");
      System.out.println("2.- Vender asientos");
      System.out.println("3.- Salir del programa");

      System.out.print("Elige una opción (1, 2, 3): ");
      seleccion = Integer.parseInt(sc.nextLine());

      if (seleccion == 1) {

        System.out.println("ASIENTOS LIBRES POR ZONA");
        System.out.println("------------------------");

        System.out.println("Zona Platea: " + zona1.getEntradasPorVender());
        System.out.println("Zona Palco: " + zona2.getEntradasPorVender());
        System.out.println("Zona Ático: " + zona3.getEntradasPorVender());

      }
      if (seleccion == 2) {
        System.out.println("");
        System.out.println("VENTA DE ENTRADAS");
        System.out.println("-----------------");
        System.out.print("Selecciona la zona en la que se localizan los asientos a vender"
            + "( 1 = Platea | 2 = Palco | 3 = Ático ): ");
        int zonaLocalizacion = Integer.parseInt(sc.nextLine());

        if (zonaLocalizacion == 1) {
          System.out.print("Introduzca el numero de asientos a vender: ");
          int entradasIniciales = Integer.parseInt(sc.nextLine());
          zona1.vender();
        } else if (zonaLocalizacion == 2) {
          zona2.vender();
        } else if (zonaLocalizacion == 3) {
          zona3.vender();
        }

      }

    } while (seleccion != 3);
    {
      System.out.println("------------------");
      System.out.println("PROGRAMA TERMINADO");
    }
    sc.close();
  }
}
