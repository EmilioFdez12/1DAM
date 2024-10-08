package r03e10;

import java.util.Scanner;

public class AlumnoApruebaApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("APROBADOS Y SUSPENSOS");
		System.out.println("---------------------");
		
		System.out.print("Introduce la calificación de la primera evaluación: ");
			double ev1 = Double.parseDouble(sc.nextLine());
		System.out.print("Introduce la calificación de la segunda evaluación: ");
			double ev2 = Double.parseDouble(sc.nextLine());
		System.out.print("Introduce la calificación de la tercera evaluación: ");
			double ev3 = Double.parseDouble(sc.nextLine());
			
		double media = ((ev1 + ev2 + ev3) / 3);
		
		if (media >= 5) {
			System.out.println("El alumno ha aprobado con una media de: " + media);
		} else {
			System.out.println("El alumno ha suspendido con una media de: " + media);
		}
		
		sc.close();
	}

}
