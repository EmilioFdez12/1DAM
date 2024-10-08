package prog.unidad05.ficheros2.ejercicio06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopiaFicherosApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		if (args.length < 2) {
			System.err.println(
					"Error. Es necesario proporcionar dos rutas al programa. La primera es la del archivo origen y la segunda la del destino");
			return;
		}

		String rutaOrigen = args[0];
		String rutaDestino = args[1];

		System.out.printf("Copiando fichero \"%s\" a \"%s\"", rutaOrigen, rutaDestino);

		// Abrimos un archivo para leer y el otro se crea o sobreescribe
		// Ambos en modo binario
		try (FileInputStream flujoEntrada = new FileInputStream(rutaOrigen);
				OutputStream flujoSalida = new FileOutputStream(rutaDestino);) {
			int valor;
			// Hacemos la copia
			do {
				// Leemos un valor
				valor = flujoEntrada.read();
				// Si no es fin de fichero
				if (valor != -1) {
					// Se almacena en el de salida
					flujoSalida.write(valor);
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
