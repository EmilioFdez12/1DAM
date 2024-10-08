package prog.unidad03.repeticion;

import java.util.Scanner;

public class NumerosParesImparesEntreApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int limiteInferior;
		int limiteSuperior;

		do {
			System.out.print("Introduce el número de comienzo del intervalo: ");
			limiteInferior = Integer.parseInt(sc.nextLine());
			System.out.print("Introduce el número de fin del intervalo: ");
			limiteSuperior = Integer.parseInt(sc.nextLine());
			if (limiteInferior > limiteSuperior) {
				System.out.println("Los números estan mal introducidos");
			}
		} while (limiteInferior > limiteSuperior);

		if (limiteInferior > limiteSuperior) {
			System.out.println("El número de inicio es mayor que el final. TERMINANDO");
		}
		for (int i = limiteInferior; i <= limiteSuperior; i++) {
			if ((i % 2) == 0) {
				System.out.println("El numero " + i + " es par");
			} else {
				System.out.println("El numero " + i + " es impar");
			}
			sc.close();
		}

	}
}
