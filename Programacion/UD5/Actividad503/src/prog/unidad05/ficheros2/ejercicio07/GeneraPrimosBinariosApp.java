package prog.unidad05.ficheros2.ejercicio07;

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

public class GeneraPrimosBinariosApp {
	
	private static final String FICHERO = "C:\\Users\\Emi\\Desktop\\primos.bin";
	private static final int MAXIMO = 255;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		
		System.out.printf("Generando fichero \"%s\"%n", FICHERO);

		// Abrimos un archivo para leer y el otro se crea o sobreescribe
		// Ambos en modo binario
		try (OutputStream flujoSalida = new FileOutputStream(FICHERO);) {
			int primo = 1;

			flujoSalida.write(primo);
		
			while (primo < MAXIMO) {
				primo = siguientePrimo(primo);
				
				if (primo < MAXIMO) {
					flujoSalida.write(primo);
				}
				
			}

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
	
	 private static int siguientePrimo(int primo) {
	    // Hasta que encontremos uno y lo devolvamos
	    while (true) {
	      // Prueba el siguiente
	      primo++;
	      // Si es primo hemos terminado
	      if (esPrimo(primo)) {
	        // Se devuelve
	        return primo;
	      }
	    }
	 }
	
	private static boolean esPrimo(int numero) {
    // Probamos todos los divisores desde 2 hasta la mitad del valor.
    // Si alguno de ellos divide terminamos inmediatamente con false
    // Si no se termina al final con true
    for (int i = 2; i <= (numero / 2);i++) {
      if ((numero % i) == 0) {
        return false;
      }
    }
    // No hemos conseguido dividirlo por ninguno
    return true;
  }
	
}



