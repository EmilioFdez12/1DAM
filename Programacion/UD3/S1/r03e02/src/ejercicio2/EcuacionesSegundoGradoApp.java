package ejercicio2;

import java.util.Scanner;
import java.lang.Math;

public class EcuacionesSegundoGradoApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("CALCULADORA ECUACIONES DE SEGUNDO GRADO");
		System.out.println("---------------------------------------");
		
		System.out.print("Introduce el valor de a: ");
		double valorA = Double.parseDouble(sc.nextLine());	
		System.out.print("Introduce el valor de b: ");
		double valorB = Double.parseDouble(sc.nextLine());	
		System.out.print("Introduce el valor de c: ");
		double valorC = Double.parseDouble(sc.nextLine());
		
		double raiz = Math.sqrt((valorB * valorB) - (4 * valorA * valorC));
		System.out.println("la raiz es= " + raiz);
		
		if (raiz > 0) {
			double raiz1 = ((( -valorB ) + raiz ) / ( 2 * valorA ));
			System.out.println("Las Raiz 1 de la ecuacion es: " + raiz1);
			
			//La segunda raiz se saca restando
			double raiz2 = ((( -valorB ) - raiz ) / ( 2 * valorA ));
			System.out.println("Las Raiz 1 de la ecuacion es: " + raiz2);
			
			//Decimos si son reales etc			
			if(raiz1 > 0 && raiz2 > 0) {
				System.out.println("Las dos soluciones son reales");
			}else{
				System.out.println("Las dos soluciones no son reales");
			}
			
			if(raiz1 > 0 && raiz2 > 0 && raiz1 == raiz2) {
				System.out.println("Las dos soluciones son reales y son iguales");
			}else{
				System.out.println("Las dos soluciones son reales pero no iguales");
			}
			
		//si la raiz de la ecuacion da 0 ponemos esto
		} else if (raiz < 0){
			System.out.println("Las ecuacion no tiene raices reales: ");			
		}
				
		sc.close();
	}

}
