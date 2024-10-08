package prog.unidad06.arraysobjetos.ejercicio04;

import java.util.Scanner;

import prog.unidad06.arraysobjetos.Estudiante;
import prog.unidad06.arraysobjetos.Profesor;

public class GestionaCentroApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int eleccion;
    int capacidad = 10; // Capacidad inicial del array
    Estudiante[] arrayEstudiantes = new Estudiante[capacidad];
    Profesor[] arrayProfesor= new Profesor[capacidad];
    int numeroFilas = 0;
    String promptBusqueda;

    do {
      System.out.println("GESTIÓN DE ESTUDIANTES");
      System.out.println("----------------------");
      System.out.println("(1) Agregar estudiante");
      System.out.println("(2) Mostrar todos los estudiantes");
      System.out.println("(3) Eliminar estudiante");
      System.out.println("(4) Buscar estudiantes por nombre");
      System.out.println("(5) Buscar estudiante por DNI");
      System.out.println("(0) Salir de la aplicación");
      System.out.print("Introduzca una opción (0-5): ");
      eleccion = Integer.parseInt(sc.nextLine());

      if (eleccion == 1) {
        System.out.print("¿Que tipo de persona quieres añadir (1)Estudiante, (2)Profesor?");
          int eleccionPersona = Integer.parseInt(sc.nextLine());
                    
          if(eleccionPersona == 1) {
            
            
            if (numeroFilas == capacidad) {
                // If the array is full, double its capacity
                capacidad *= 2;
                Estudiante[] newArrayEstudiantes = new Estudiante[capacidad];
                // Copy existing data to the new array
                System.arraycopy(arrayEstudiantes, 0, newArrayEstudiantes, 0, numeroFilas);
                arrayEstudiantes = newArrayEstudiantes;
            }

            try {
                // Preguntamos para agregar el estudiante
                System.out.println();
                System.out.println("AGREGAR ESTUDIANTE");
                System.out.println("-------------");
                System.out.print("Introduzca el DNI del estudiante (sin espacios): ");
                String dni = sc.nextLine();

                // Verificar que el DNI tiene un formato válido
                if (dni.length() != 9 || !Character.isLetter(dni.charAt(8))) {
                    throw new IllegalArgumentException("Formato incorrecto de DNI");
                }

                // Verificar si el estudiante ya existe en el array
                boolean dniRepetido = false;
                for (int i = 0; i < numeroFilas; i++) {
                    if (arrayEstudiantes[i].getDni().equals(dni)) {
                        dniRepetido = true;
                    }
                }

                if (dniRepetido) {
                   System.out.println("El DNI ingresado ya pertenece a otro estudiante");
                }

                // Si el DNI no está repetido, continuar con la creación del estudiante
                System.out.print("Introduzca el nombre del estudiante: ");
                String nombreEstudiante = sc.nextLine();
                System.out.print("Introduzca el curso del estudiante (Primero/Segundo/Master): ");
                String curso = sc.nextLine();

                // Creamos el estudiante con los datos introducidos
                Estudiante nuevoEstudiante = new Estudiante(dni, nombreEstudiante, curso);
                // Rellena el array con el nuevo estudiante
                arrayEstudiantes[numeroFilas] = nuevoEstudiante;

                // Aumenta el número de filas
                numeroFilas++;
                System.out.println();

            } catch (IllegalArgumentException e) {
                System.out.println("Error");
            }
          } else if (eleccionPersona == 2) {    
            if (numeroFilas == capacidad) {
                // If the array is full, double its capacity
                capacidad *= 2;
                Profesor[] newArrayProfesores = new Profesor[capacidad];
                // Copy existing data to the new array
                System.arraycopy(arrayProfesor, 0, newArrayProfesores, 0, numeroFilas);
                arrayProfesor = newArrayProfesores;
            }

            try {
                // Preguntamos para agregar el estudiante
                System.out.println();
                System.out.println("AGREGAR PROFESOR");
                System.out.println("-------------");
                System.out.print("Introduzca el DNI del estudiante (sin espacios): ");
                String dni = sc.nextLine();

                // Verificar que el DNI tiene un formato válido
                if (dni.length() != 9 || !Character.isLetter(dni.charAt(8))) {
                    throw new IllegalArgumentException("Formato incorrecto de DNI");
                }

                // Verificar si el estudiante ya existe en el array
                boolean dniRepetido = false;
                for (int i = 0; i < numeroFilas; i++) {
                    if (arrayProfesor[i].getDni().equals(dni)) {
                        dniRepetido = true;
                    }
                }

                if (dniRepetido) {
                   System.out.println("El DNI ingresado ya pertenece a otro estudiante");
                }

                // Si el DNI no está repetido, continuar con la creación del estudiante
                System.out.print("Introduzca el nombre del estudiante: ");
                String nombreProfe = sc.nextLine();
                System.out.print("Introduzca el curso del estudiante (Primero/Segundo/Master): ");
                String materia = sc.nextLine();

                // Creamos el estudiante con los datos introducidos
                Profesor nuevoProfesor = new Profesor(dni, nombreProfe, materia);
                // Rellena el array con el nuevo estudiante
                arrayProfesor[numeroFilas] = nuevoProfesor;

                // Aumenta el número de filas
                numeroFilas++;
                System.out.println();

            } catch (IllegalArgumentException e) {
                System.out.println("Error");
            }
          }
        
     
    }


      if (eleccion == 2) {
        System.out.println();
        // Es estudiante
        for (int j = 0; j < numeroFilas; j++) {
          if(arrayEstudiantes[j] instanceof Estudiante) {
            Estudiante estudiante = (Estudiante) arrayEstudiantes[j];
          System.out.println("DNI: " + estudiante.getDni() + ", Nombre: " + estudiante.getNombre() + ", Curso: "
              + estudiante.getCurso());
          }
        }
        System.out.println();
        
        // Es profesor
        for (int j = 0; j < numeroFilas; j++) {
          if(arrayProfesor[j] instanceof Profesor) {
            Profesor profesor = (Profesor) arrayProfesor[j];
          System.out.println("DNI: " + profesor.getDni() + ", Nombre: " + profesor.getNombre() + ", Curso: "
              + profesor.getMateria());
          }
        }
        System.out.println();
      }

      if (eleccion == 3) {
        System.out.println();
        System.out.println("ELIMINAR ESTUDIANTE");
        System.out.println("-------------------");
        System.out.print("Introduzca el DNI del estudiante a eliminar (8 números y una letra): ");
        String dniEliminar = sc.nextLine();

        boolean encontrado = false;
        // Crear un nuevo array con un tamaño reducido
        Estudiante[] nuevoArrayEstudiantes = new Estudiante[arrayEstudiantes.length - 1];

        int nuevoIndice = 0;
        // Recorremos el array original
        for (int i = 0; i < numeroFilas; i++) {
          // Buscamos el estudiante con el DNI a eliminar
          if (arrayEstudiantes[i].getDni().equals(dniEliminar)) {
            encontrado = true;
          } else {
            // Copiamos los estudiantes que no deben ser eliminados al nuevo array
            nuevoArrayEstudiantes[nuevoIndice] = arrayEstudiantes[i];
            nuevoIndice++;
          }
        }

        if (encontrado) {
          // El estudiante fue encontrado y eliminado
          System.out.println("Estudiante eliminado con éxito.");
          // Actualizar el array original con el nuevo array
          arrayEstudiantes = nuevoArrayEstudiantes;
          // Reducir el número de filas
          numeroFilas--;
        } else {
          System.out.println("No se encontró ningún estudiante con ese DNI.");
        }
      }

      if (eleccion == 4) {

        System.out.println();
        System.out.println("BUSCAR ESTUDIANTES POR NOMBRE");
        System.out.println("-----------------------");
        System.out.print("Introduzca el texto de busqueda (no puede dejarse en blanco): ");
        promptBusqueda = sc.nextLine();

        boolean encontrado = false;
        // Recorremos el array
        for (int i = 0; i < numeroFilas; i++) {
          // Buscamos que el titulo de cada fila sea igual que el String prompBusqueda, si
          // es asi, se imprimirá la información del libro.
          if (arrayEstudiantes[i].getNombre().toLowerCase().contains(promptBusqueda.toLowerCase()) ) {
            System.out.println("Resultado busqeda");
            System.out.println("DNI: " + arrayEstudiantes[i].getDni() + ", Nombre: " + arrayEstudiantes[i].getNombre()
                + ", Curso: " + arrayEstudiantes[i].getCurso());
            encontrado = true;
          }
        }
        if (!encontrado) {
          System.out.println("No se ha encontrado ningun libro con este titulo");
        }
        System.out.println();
      }
      
      
      if (eleccion == 5) {

        System.out.println();
        System.out.println("BUSCAR ESTUDIANTES POR DNI");
        System.out.println("-----------------------");
        System.out.print("Introduzca el texto de busqueda (no puede dejarse en blanco): ");
        promptBusqueda = sc.nextLine();

        boolean encontrado = false;
        // Recorremos el array
        for (int i = 0; i < numeroFilas; i++) {
          // Buscamos que el titulo de cada fila sea igual que el String prompBusqueda, si
          // es asi, se imprimirá la información del libro.
          if (arrayEstudiantes[i].getDni().contains(promptBusqueda)) {
            System.out.println("Resultado busqeda");
            System.out.println("DNI: " + arrayEstudiantes[i].getDni() + ", Nombre: " + arrayEstudiantes[i].getNombre()
                + ", Curso: " + arrayEstudiantes[i].getCurso());
            encontrado = true;
          }
        }
        if (!encontrado) {
          System.out.println("No se ha encontrado ningun estudiante con este DNI");
        }
        System.out.println();
      }

    }while(eleccion!=0);

  {
    System.out.println("------------------");
    System.out.println("Programa Terminado");
  }
    
  sc.close();
}
  
}
