package prog.unidad05.ficheros2.ejercicio08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ListaPrimosBinariosApp {

	private static final String FICHERO = "C:\\Users\\Emi\\Desktop\\primos.bin";
	private static final int MAXIMO = 255;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.printf("Generando fichero \"%s\"%n", FICHERO);

		// Abrimos un archivo para leer y el otro se crea o sobreescribe
		// Ambos en modo binario
		try (FileInputStream flujoEntrada = new FileInputStream(FICHERO);) {
			int valor;

			do {
				valor = flujoEntrada.read();
				if (valor != -1) {
					// Lo imprime
					System.out.println(valor);
				}
			} while (valor != -1);

			// Hemos terminado la copia
			System.out.println("Finalizada la copia");
		} catch (FileNotFoundException e) {
			// Fichero no encontrado
			System.out.println("Error. No se encuentra el fichero de entrada o no se puede crear el fichero de salida");
		} catch (IOException e) {
			// Error de entrada / salida
			System.out.println("Error leyendo o escribiendo ficheros");
		}
	}

}
