package prog.unidad06.arraysobjetos.ejercicio02;

import java.util.Scanner;

import prog.unidad06.arraysobjetos.Libro;
import prog.unidad06.arraysobjetos.Publicacion;
import prog.unidad06.arraysobjetos.Revista;

public class GestionaPublicacionesApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int eleccion;
    String eleccionPublicacion;
    int capacidad = 10; // Capacidad inicial del array
    Publicacion[] arrayLibros = new Publicacion[capacidad];
    int numeroFilas = 0;
    String promptBusqueda;
    int promptBusquedaAnyo;

    do {
      System.out.println("GESTIÓN DE LIBROS");
      System.out.println("-----------------");
      System.out.println("(1) Agregar publicacion");
      System.out.println("(2) Mostrar todos los libros");
      System.out.println("(3) Buscar libro por título");
      System.out.println("(4) Buscar libro por año de publicación");
      System.out.println("(0) Salir de la aplicación");
      System.out.print("Introduzca una opción (0-4): ");
      eleccion = Integer.parseInt(sc.nextLine());

      if (eleccion == 1) {
        System.out.print("¿Que tipo de publicación quieres agregar Libro o Revista l/r ?: ");
        eleccionPublicacion = sc.nextLine();

        if (eleccionPublicacion.equalsIgnoreCase("l")) {
          if (numeroFilas == capacidad) {
            // Si el array esta lleno, dobla su capacidad
            capacidad *= 2;
            Publicacion[] newArrayLibros = new Publicacion[capacidad];
            // Copiamos todo al nuevo array
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
          int añoPublicacionLibro = Integer.parseInt(sc.nextLine());

          // Creamos el libro con los datos introducidos
          Libro nuevoLibro = new Libro(tituloLibro, autorLibro, añoPublicacionLibro);
          // Rellena el array con el nuevo libro
          arrayLibros[numeroFilas] = nuevoLibro;

          // Aumenta el numero de
          numeroFilas++;
          System.out.println();

        } else if (eleccionPublicacion.equalsIgnoreCase("r")) {
          if (numeroFilas == capacidad) {
            // Si el array esta lleno, dobla su capacidad
            capacidad *= 2;
            Libro[] newArrayLibros = new Libro[capacidad];
            // Copiamos todo al nuevo array
            System.arraycopy(arrayLibros, 0, newArrayLibros, 0, numeroFilas);
            arrayLibros = newArrayLibros;
          }

          // Preguntamos para agregar el libro
          System.out.println();
          System.out.println("AGREGAR REVISTA");
          System.out.println("-------------");
          System.out.print("Introduzca el título de la revista: ");
          String tituloRevista = sc.nextLine();
          System.out.print("Introduzca numero de la revista: ");
          int numeroRevista = Integer.parseInt(sc.nextLine());
          System.out.print("Introduzca el año de publicación del libro: ");
          int añoPublicacionLibro = Integer.parseInt(sc.nextLine());

          // Creamos el libro con los datos introducidos
          Revista nuevaRevista = new Revista(tituloRevista, numeroRevista, añoPublicacionLibro);
          // Rellena el array con el nuevo libro
          arrayLibros[numeroFilas] = nuevaRevista;

          // Aumenta el numero de
          numeroFilas++;
          System.out.println();

        }

      }

      if (eleccion == 2) {
        System.out.println();
        for (int j = 0; j < numeroFilas; j++) {
          if (arrayLibros[j] instanceof Libro) {
            // Es un libro
            Libro libro = (Libro) arrayLibros[j];
            System.out.println("Tipo: Libro, Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor()
                + ", Año Publicación: " + libro.getAnyoPublicacion());
          } else if (arrayLibros[j] instanceof Revista) {
            // Es una revista
            Revista revista = (Revista) arrayLibros[j];
            System.out.println("Tipo: Revista, Título: " + revista.getTitulo() + ", Número: " + revista.getNumero()
                + ", Año Publicación: " + revista.getAnyoPublicacion());
          }
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
          if (arrayLibros[i].getTitulo().toLowerCase().contains(promptBusqueda.toLowerCase())) {
            System.out.println("Resultado búsqueda");

            if (arrayLibros[i] instanceof Libro) {
              // Es un libro
              Libro libro = (Libro) arrayLibros[i];
              System.out.println("Tipo: Libro, Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor()
                  + ", Año Publicación: " + libro.getAnyoPublicacion());
            } else if (arrayLibros[i] instanceof Revista) {
              // Es una revista
              Revista revista = (Revista) arrayLibros[i];
              System.out.println("Tipo: Revista, Título: " + revista.getTitulo() + ", Número: " + revista.getNumero()
                  + ", Año Publicación: " + revista.getAnyoPublicacion());
            }
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
          if (arrayLibros[i].getAnyoPublicacion() == promptBusquedaAnyo ) {
            System.out.println("Resultado búsqueda");

            if (arrayLibros[i] instanceof Libro) {
              // Es un libro
              Libro libro = (Libro) arrayLibros[i];
              System.out.println("Tipo: Libro, Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor()
                  + ", Año Publicación: " + libro.getAnyoPublicacion());
            } else if (arrayLibros[i] instanceof Revista) {
              // Es una revista
              Revista revista = (Revista) arrayLibros[i];
              System.out.println("Tipo: Revista, Título: " + revista.getTitulo() + ", Número: " + revista.getNumero()
                  + ", Año Publicación: " + revista.getAnyoPublicacion());
            }
            encontrado = true;
          }
        }
        if (!encontrado) {
          System.out.println("No se ha encontrado ningun libro con este titulo");
        }
        System.out.println();
      }

    } while (eleccion != 0);
    {
      System.out.println("------------------");
      System.out.println("Programa Terminado");
    }
    sc.close();
  }
}
