package prog.unidad06.arraysmulti.ejercicio07;

import prog.unidad06.arraysmulti.ejercicio06.TablaEnteraUtils;

public class DiagonalTabla {

	public static void main(String[] args) {

		int[][] tabla = TablaEnteraUtils.nuevaTablaAleatoria(10, 10, 200, 300);
		int minimo = tabla[0][0];
		int maximo = tabla[0][0];
		double suma = tabla[0][0];

		TablaEnteraUtils.imprimeTabla(tabla, 2);

		System.out.print("Los elementos que están en la diagonal son: ");

		int[][] arrayDiagonal = new int[10][10];

		for (int i = 0; i < 10; i++) {
			// Imprimir elemento diagonal
			System.out.print(", " + tabla[i][i]);
			arrayDiagonal[i][i] = tabla[i][i];

			if (tabla[i][i] < minimo) {
				// Ahora es el nuevo mínimo
				minimo = tabla[i][i];
			}
			// Añadimos a la suma de la media
			suma += tabla[i][i];
		}

		System.out.println();

		System.out.println("El máximo de los elementos de la diagonal es " + maximo + " el mínimo es " + minimo
				+ " y la media de todos los elementos de la diagonal es " + (suma / 10));
	}
}
