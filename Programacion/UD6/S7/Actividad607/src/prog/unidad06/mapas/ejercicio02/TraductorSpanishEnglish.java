package prog.unidad06.mapas.ejercicio02;

import java.util.Scanner;

import prog.unidad06.mapas.ejercicio01.DiccionarioSpanishEnglish;

public class TraductorSpanishEnglish {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("TRADUCCIÓN ESPAÑOL - INGLÉS");

		DiccionarioSpanishEnglish diccionario = new DiccionarioSpanishEnglish();
		String palabraABuscar = "";
		String palabraTraducida = "";

		do {
			System.out.print("Introduzca una palabra a traducir al inglés (vacía para terminar): ");
			palabraABuscar = sc.nextLine();

			if (!palabraABuscar.isBlank()) {
				if (!diccionario.getPalabraSpanish().contains(palabraABuscar)) {
					System.out.println("Esta palabra no se encuentra en el diccionario");
				} else {
					palabraTraducida = diccionario.traducir(palabraABuscar);
					System.out.println("La palabra " + palabraABuscar + " es " + palabraTraducida + " en inglés");
				}
			}

		} while (!palabraABuscar.isBlank());{
			System.out.println("Programa Terminado");
		}

		sc.close();
	}
}