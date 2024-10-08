package prog.unidad03.repeticion;

import java.util.Scanner;

public class MayorMenorMediaApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Cuantos numeros desea introducir: ");
		int numDeseados = Integer.parseInt(sc.nextLine());

		System.out.print("Introduce el numero 1: ");
		double primer = Double.parseDouble(sc.nextLine());

		double mayor = primer;
		double menor = primer;
		double suma = primer;

		for (int i = 2; i <= numDeseados; i++) {
			System.out.print("Introduce el numero " + i + ": ");
			double numero = Double.parseDouble(sc.nextLine());

			if (numero > mayor) {
				mayor = numero;
			}

			if (numero < menor) {
				menor = numero;
			}
			
			suma += numero;
		}
		
		double media =(suma / numDeseados) ;

		System.out.println("El número mayor es " + mayor);
		System.out.println("El número menor es " + menor);
		System.out.println("La media es " + media);
		
		
		sc.close();
	}

}

//el mayor es el primero mayor=primero
