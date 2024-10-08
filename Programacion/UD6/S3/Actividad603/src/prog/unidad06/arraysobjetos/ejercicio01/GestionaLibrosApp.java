package prog.unidad06.arraysobjetos.ejercicio01;

import prog.unidad06.arraysobjetos.Libro;

import java.util.Scanner;

public class GestionaLibrosApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int eleccion;
    int capacidad = 10; // Capacidad inicial del array
    Libro[] arrayLibros = new Libro[capacidad];
    int numeroFilas = 0;
    String promptBusqueda;
    int promptBusquedaAnyo;

    do {
      System.out.println("GESTIÓN DE LIBROS");
      System.out.println("-----------------");
      System.out.println("(1) Agregar libro");
      System.out.println("(2) Mostrar todos los libros");
      System.out.println("(3) Buscar libro por título");
      System.out.println("(4) Buscar libro por año de publicación");
      System.out.println("(0) Salir de la aplicación");
      System.out.print("Introduzca una opción (0-4): ");
      eleccion = Integer.parseInt(sc.nextLine());

      if (eleccion == 1) {
        if (numeroFilas == capacidad) {
          // If the array is full, double its capacity
          capacidad *= 2;
          Libro[] newArrayLibros = new Libro[capacidad];
          // Copy existing data to the new array
          System.arraycopy(arrayLibros, 0, newArrayLibros, 0, numeroFilas);
          arrayLibros = newArrayLibros;
        }

        // Preguntamos para agregar el libro
        System.out.println();
        System.out.println("AGREGAR LIBRO");
        System.out.println("-------------");
        System.out.print("Introduzca el título del libro: ");
        String tituloLibro = sc.nextLine();
        System.out.print("Introduzca el nombre del autor del libro: ");
        String autorLibro = sc.nextLine();
        System.out.print("Introduzca el año de publicación del libro: ");
        int anyoPublicacionLibro = Integer.parseInt(sc.nextLine());

        // Creamos el libro con los datos introducidos
        Libro nuevoLibro = new Libro(tituloLibro, autorLibro, anyoPublicacionLibro);
        // Rellena el array con el nuevo libro
        arrayLibros[numeroFilas] = nuevoLibro;

        // Aumenta el numero de
        numeroFilas++;
        System.out.println();
      }

      if (eleccion == 2) {
        System.out.println();
        for (int j = 0; j < numeroFilas; j++) {
          System.out.println("Titulo: " + arrayLibros[j].getTitulo() + ", Autor: " + arrayLibros[j].getAutor()
              + ", Año Publicacion: " + arrayLibros[j].getAnyoPublicacion());
        }
        System.out.println();
      }

      if (eleccion == 3) {

        System.out.println();
        System.out.println("BUSCAR LIBRO POR TÍTULO");
        System.out.println("-----------------------");
        System.out.print("Introduzca el texto de busqueda (no puede dejarse en blanco): ");
        promptBusqueda = sc.nextLine();

        boolean encontrado = false;
        // Recorremos el array
        for (int i = 0; i < numeroFilas; i++) {
          // Buscamos que el titulo de cada fila sea igual que el String prompBusqueda, si     
          // es asi, se imprimirá la información del libro.
          if (arrayLibros[i].getTitulo().equalsIgnoreCase(promptBusqueda)) {
            System.out.println("Resultado busqeda");
            System.out.println("Titulo: " + arrayLibros[i].getTitulo() + ", Autor: " + arrayLibros[i].getAutor()
                + ", Año Publicacion: " + arrayLibros[i].getAnyoPublicacion());
            encontrado = true;
          }
        }
        if (!encontrado) {
          System.out.println("No se ha encontrado ningun libro con este titulo");
        }
        System.out.println();
      }
      
      if (eleccion == 4) {

        System.out.println();
        System.out.println("BUSCAR LIBRO POR AÑO PUBLICACION");
        System.out.println("-----------------------");
        System.out.print("Introduzca el texto de busqueda (no puede dejarse en blanco): ");
        promptBusquedaAnyo = Integer.parseInt(sc.nextLine());

        boolean encontrado = false;
        // Recorremos el array
        for (int i = 0; i < numeroFilas; i++) {
          // Buscamos que el titulo de cada fila sea igual que el String prompBusqueda, si     
          // es asi, se imprimirá la información del libro.
          if (arrayLibros[i].getAnyoPublicacion()== promptBusquedaAnyo) {
            System.out.println("Resultado busqeda");
            System.out.println("Titulo: " + arrayLibros[i].getTitulo() + ", Autor: " + arrayLibros[i].getAutor()
                + ", Año Publicacion: " + arrayLibros[i].getAnyoPublicacion());
            encontrado = true;
          }
        }
        if (!encontrado) {
          System.out.println("No se ha encontrado ningun libro con este titulo");
        }
        System.out.println();
      }
      

    } while (eleccion != 0); {
      System.out.println("------------------");
      System.out.println("Programa Terminado");
    }
    sc.close();
  }
}
