package r03e11;

import java.util.Scanner;

public class CalculaImporteApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("DESCUENTOS AL COMPRAR");
		System.out.println("---------------------");
		
		System.out.print("Introduce el importe de la compra en euros: ");
			double importe = Double.parseDouble(sc.nextLine());
		
		if (importe >= 100) {
			double descontado = (importe - (importe * 0.20));
			System.out.println("Como la compra es superior a 100€ se le aplicara un descuento del 20%. "
					+ "El importe a pagar es de " + descontado + "€");
		}
		sc.close();
	}
}
