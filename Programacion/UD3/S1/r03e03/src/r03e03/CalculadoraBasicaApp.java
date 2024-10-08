package r03e03;

import java.util.Scanner;

public class CalculadoraBasicaApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("CALCULADORA BASICA");
		System.out.println("------------------");
		
		
		System.out.print("Que operacion quieres realizar: S para Suma, R para Resta,"
				+ " D para division o M para multiplicar: ");
			String operacion = sc.nextLine();
			
			
			System.out.print("Introduce el primero operando: ");
			double operando1 = Double.parseDouble(sc.nextLine());
			System.out.print("Introduce el segundo operando: ");
			double operando2 = Double.parseDouble(sc.nextLine());
			
			
			if (operacion.equalsIgnoreCase("S")){
				double suma = (operando1 + operando2);
				System.out.println("El resultado de Sumar " + operando1 + " y " + operando2 +  "es = " + suma);		
			} else if (operacion.equalsIgnoreCase("R")){
				double resta = (operando1 - operando2);
				System.out.println("El resultado de Restar " + operando1 + " y " + operando2 + " es = " + resta);			
			} else if (operacion.equalsIgnoreCase("R")){
				double dividir = (operando1 / operando2);
				System.out.println("El resultado de Dividir " + operando1 + " y " + operando2 + " es = " + dividir);			
			} else if (operacion.equalsIgnoreCase("M")){
				double multiplicar = (operando1 * operando2);
				System.out.println("El resultado de Multiplicar " + operando1 + " y " + operando2 + " es = " + multiplicar);		
			}	
			
		sc.close();	

	}

}
