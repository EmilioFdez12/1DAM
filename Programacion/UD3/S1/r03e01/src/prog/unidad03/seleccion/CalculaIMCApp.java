package prog.unidad03.seleccion;

import java.util.Scanner;

public class CalculaIMCApp {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Inserte su peso en Kilogramos: ");
		double peso = Double.parseDouble(sc.nextLine());
		
		System.out.print("Inserte su altura en metros: ");
		double altura = Double.parseDouble(sc.nextLine());
		sc.close();
		
		double imc = (peso / (altura * altura ));
		
		System.out.println("Su indice de masa corporal es de: " + imc);
		
		//If primero
		
		//segun el valor del IMC
		//si es menor  de 16
		
		if (imc < 16) {
			System.out.println("Su IMC es de: " + imc + " con un diagnostico de infrapeso (Inrese en el hospital)"); //se puede simplificar el else if
		}else if (16 <= imc && imc < 17) {
			System.out.println("Su IMC es de: " + imc + " con un diagnostico de infrapeso");
		}else if (17 <= imc && imc < 18) {
			System.out.println("Su IMC es de: " + imc + " con un diagnostico de Bajo Peso");
		}else if (18 <= imc && imc < 25) {
			System.out.println("Su IMC es de: " + imc + " con un diagnostico de Peso Normal");
		}else if (25 <= imc && imc < 30) {
			System.out.println("Su IMC es de: " + imc + " con un diagnostico de Sobre Peso (Obesidad de Grado I)");
		}else if (30 <= imc && imc < 35) {
			System.out.println("Su IMC es de: " + imc + " con un diagnostico de Sobre Peso Crónico (Obesidad de Grado II)");
		}else if (35 <= imc && imc <= 40) {
			System.out.println("Su IMC es de: " + imc + " con un diagnostico de Obesidad Premórbida (Obesidad de Grado III)");
		}else{
			System.out.println("Su IMC es de: " + imc + " con un diagnostico de Obesidad Mórbidad (Obesidad de Grado IV)");
		}
	}
}
