package prog.unidad06.arraysmulti.ejercicio08;

import prog.unidad06.arraysmulti.ejercicio06.TablaEnteraUtils;

public class MiPrimerCuboApp {

	private static final int PLANOS = 3;
	private static final int FILAS = 4;
	private static final int COLUMNAS = 5;

	public static void main(String[] args) {

		int[][][] primerCubo = new int[PLANOS][FILAS][COLUMNAS];

		// Plano 1
		primerCubo[0][0][0] = 18;
		primerCubo[0][0][2] = 36;
		primerCubo[0][0][3] = 67;

		primerCubo[0][1][1] = 59;
		primerCubo[0][1][2] = 6;
		primerCubo[0][1][3] = 40;

		primerCubo[0][2][0] = 74;
		primerCubo[0][2][2] = 59;
		primerCubo[0][2][4] = 11;

		primerCubo[0][3][1] = 51;
		primerCubo[0][3][2] = 85;
		primerCubo[0][3][3] = 62;

		// Plano 2
		primerCubo[1][0][1] = 25;
		primerCubo[1][0][2] = 38;
		primerCubo[1][0][3] = 99;

		primerCubo[1][1][0] = 92;
		primerCubo[1][1][2] = 31;
		primerCubo[1][1][4] = 74;

		primerCubo[1][2][1] = 78;
		primerCubo[1][2][2] = 81;
		primerCubo[1][2][4] = 76;

		primerCubo[1][3][0] = 1;
		primerCubo[1][3][1] = 26;
		primerCubo[1][3][4] = 96;

		// Plano 3
		primerCubo[2][0][2] = 17;
		primerCubo[2][0][3] = 42;
		primerCubo[2][0][4] = 82;

		primerCubo[2][1][1] = 95;
		primerCubo[2][1][2] = 8;
		primerCubo[2][1][3] = 50;

		primerCubo[2][2][0] = 2;
		primerCubo[2][2][1] = 96;
		primerCubo[2][2][2] = 29;

		primerCubo[2][3][0] = 21;
		primerCubo[2][3][1] = 74;
		primerCubo[2][3][4] = 48;

		System.out.println("MI PRIMER CUBO");

		for (int i = 0; i < PLANOS; i++) {
			System.out.println("--------------------");
			System.out.println("Plano " + (i + 1));
			System.out.println("--------------------");
			TablaEnteraUtils.imprimeTabla(primerCubo[i], 2);
		}
		System.out.println("--------------------");
	}
}
