package r03e04;

import java.util.Scanner;

public class ClasificaTriangulosApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("Clasificadora de Triangulos");
		System.out.println("---------------------------");
		
		System.out.print("Introduce la longitud de lado 1: ");
		double long1 = Double.parseDouble(sc.nextLine());
		System.out.print("Introduce la longitud de lado 2: ");
		double long2 = Double.parseDouble(sc.nextLine());
		System.out.print("Introduce la longitud de lado 3: ");
		double long3 = Double.parseDouble(sc.nextLine());
		
		if (long1 == long2 && long2 == long3) {
			System.out.println("El triangulo es equilatero");	
		}else if (long1 == long2 || long1 == long3 || long2 == long3){
			System.out.println("El triangulo es isosceles");
		}else if (long1 != long2 && long2 != long3 && long1 != long3){
		System.out.println("El triangulo es escaleno");
		}
		
		sc.close();
		}
	}

