package ejercicio2;

import java.util.Scanner;
import paquete1.Fraccion;

public class FraccionApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Pedimos los datos
		System.out.print("Inserte el numerador de la fracción 1:");
		int numerador1 = scan.nextInt();
		System.out.print("Inserte el denominador de la fracción 1:");
		int denominador1 = scan.nextInt();

		System.out.print("Inserte el numerador de la fracción 2:");
		int numerador2 = scan.nextInt();
		System.out.print("Inserte el denominador de la fracción 2:");
		int denominador2 = scan.nextInt();

		// Utilizamos los datos que hemos pedido
		Fraccion fraccion1 = new Fraccion(numerador1, denominador1);
		Fraccion fraccion2 = new Fraccion(numerador2, denominador2);

		// Creamos las operaciones
		Fraccion sumar = fraccion1.suma(fraccion2);
		Fraccion restar = fraccion1.resta(fraccion2);
		Fraccion dividir = fraccion1.division(fraccion2);
		Fraccion multiplicar = fraccion1.producto(fraccion2);

		// Imprimimos por pantalla el resultado
		System.out.println("La suma de las 2 fracciones es = " + sumar.getNumerador() + "/" + sumar.getDenominador());
		System.out.println("La resta de las 2 fracciones es = " + restar.getNumerador() + "/" + sumar.getDenominador());
		System.out.println(
				"La division de las 2 fracciones es = " + dividir.getNumerador() + "/" + sumar.getDenominador());
		System.out.println("La multiplicacion de las 2 fracciones es = " + multiplicar.getNumerador() + "/"
				+ sumar.getDenominador());

		// Recreamos las opreciones
		paquete2.Fraccion sumar2 = new paquete2.Fraccion(sumar.getNumerador(), sumar.getDenominador());
		paquete2.Fraccion restar2 = new paquete2.Fraccion(restar.getNumerador(), restar.getDenominador());
		paquete2.Fraccion dividir2 = new paquete2.Fraccion(dividir.getNumerador(), dividir.getDenominador());
		paquete2.Fraccion multiplicar2 = new paquete2.Fraccion(multiplicar.getNumerador(),
				multiplicar.getDenominador());

		// Lo simplificamos
		paquete2.Fraccion sumaSimplificada = sumar2.simplifica();
		paquete2.Fraccion restaSimplificada = restar2.simplifica();
		paquete2.Fraccion dividirSimplificada = dividir2.simplifica();
		paquete2.Fraccion multiplicarSimplificada = multiplicar2.simplifica();

		System.out.println("La suma de las 2 fracciones es = " + sumaSimplificada.getNum() + "/" + sumaSimplificada.getDen());
		System.out.println("La resta de las 2 fracciones es = " + restaSimplificada.getNum() + "/" + restaSimplificada.getDen());
		System.out.println("La division de las 2 fracciones es = " + dividirSimplificada.getNum() + "/" + dividirSimplificada.getDen());
		System.out.println("La multiplicacion de las 2 fracciones es = " + multiplicarSimplificada.getNum() + "/"
				+ multiplicarSimplificada.getDen());

		scan.close();
	}
}