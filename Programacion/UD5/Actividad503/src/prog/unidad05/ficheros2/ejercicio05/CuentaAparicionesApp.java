package prog.unidad05.ficheros2.ejercicio05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CuentaAparicionesApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String ficheroQuijote = null;
		String palabraABuscar = null;
		List<String> textoQuijote = new ArrayList<>();

		if (args.length > 1) {
			ficheroQuijote = args[0];
			palabraABuscar = args[1];
		} else {
			System.out.println("Faltan argumentos. Se necesitan 2 el nombre del fichero y la palabra");
			return;
		}

		// Leemos el primer archivo y almacenamos en una lista cada palabra
		try (BufferedReader flujoEntrada = new BufferedReader(new FileReader(ficheroQuijote))) {
			String linea;
			while ((linea = flujoEntrada.readLine()) != null) {
				// tenemos las lineas, guardamos las palabras cada vez que haya un espacio
				String[] palabrasQuijote = linea.split(" ");
				for (String palabraTexto : palabrasQuijote) {
					textoQuijote.add(palabraTexto);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
			return;
		} catch (IOException e) {
			System.out.println("No se puede leer el archivo");
			return;
		}

		int contadorPalabraABuscar = 0;
		for (String palabra : textoQuijote) {
			if (palabra.equalsIgnoreCase(palabraABuscar)) {
				contadorPalabraABuscar++;
			}
		}

		System.out.printf("Contando las apariciones de la palabra \"%s\" en el fichero %s%n", palabraABuscar, ficheroQuijote);
		System.out.printf("La palabra \"%s\" aparece %d veces en el archivo %s%n", palabraABuscar, contadorPalabraABuscar, ficheroQuijote);
	}
}
