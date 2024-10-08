package ejentornos;

import java.util.Scanner;

public class ParImpar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Inserte un número: ");
		int numero = Integer.parseInt(sc.nextLine());
		

		//Agrego el metodo
		if ( (numero % 2 ) == 0) {
			System.out.println("El numero es par");
		}else {
			System.out.println("El numero es impar");
		}
		
		sc.close();
		
	}

}