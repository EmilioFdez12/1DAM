package prog.unidad06.arraysuni.ejercicio03;

import java.util.Random;
import java.util.Scanner;

public class BusquedaNotasApp {

    public static final int NOTA_MAXIMA = 11; //11 porque si pongo 10, en el numero aleatorio se excluye al 10
    public static final int NOTA_MINIMA = 0;
    public static final int NUM_ALUMNOS = 30;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int[] arrayCalificaciones = new int[NUM_ALUMNOS];

        for (int i = 0; i < NUM_ALUMNOS; i++) {
            int numeroRandom = random.nextInt(NOTA_MINIMA,NOTA_MAXIMA);
            arrayCalificaciones[i] = numeroRandom;
        }

        System.out.println("BUSQUEDA DE CALIFICACIONES");
        int nota;
        int contadorAlumnos;

        do {
            System.out.print("Introduzca la calificación a buscar (0 a 10, negativa para terminar): ");
            nota = Integer.parseInt(sc.nextLine());

            contadorAlumnos = 0;

            for (int calificacion : arrayCalificaciones) {
                if (calificacion == nota) {
                    contadorAlumnos++;
                }
            }
            System.out.println("Con la calificación " + nota + " se han encontrado " + contadorAlumnos + " alumnos");

        } while (nota >= 0);

    }
}
