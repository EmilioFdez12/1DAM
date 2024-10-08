package r03e12;

import java.util.Scanner;

public class SituacionAlumnoApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("PROMOCIONA O NO PROMOCIONA");
		System.out.println("--------------------------");
		
		System.out.print("Introduce la calificación de Matemáticas: ");
		double notaMates = Double.parseDouble(sc.nextLine());
		System.out.print("Introduce la calificación de Matemáticas: ");
		double notaLengua = Double.parseDouble(sc.nextLine());
		
		if (notaMates >= 5 && notaLengua >= 5){
			System.out.println("El alumno promociona sin ninguna asignatura pendiente");
		} else if ( notaMates >=5 && notaLengua < 5 || notaMates < 5 && notaLengua >= 5)
			System.out.println("El alumno promociona con una asignatura pendiente");
		else if ( notaMates < 5 && notaLengua < 5 )
			System.out.println("El alumno  no promociona");
			
		sc.close();	
	}
}
