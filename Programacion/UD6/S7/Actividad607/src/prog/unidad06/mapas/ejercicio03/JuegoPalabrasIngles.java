package prog.unidad06.mapas.ejercicio03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import prog.unidad06.mapas.ejercicio01.DiccionarioSpanishEnglish;

public class JuegoPalabrasIngles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		System.out.println("¿CÚANTO SABES DE INGLÉS?");

		DiccionarioSpanishEnglish diccionario = new DiccionarioSpanishEnglish();
		
		List<String> listaPalabrasAleatorias = new ArrayList<>(diccionario.getPalabraSpanish());
		int contadorAciertos = 0;
		
		for (int i = 1; i <= 5; i++) {
			int indiceRandom = random.nextInt(0, 30);
			String palabraRandom = listaPalabrasAleatorias.get(indiceRandom);	
			String intento;
			
				System.out.println("Palabra nº" + i + ". Dime cual es la traducción al inglés de " + "\""  + palabraRandom + "\"" +": " );
				intento = sc.nextLine();
				
				if (intento.toLowerCase().equals(diccionario.traducir(palabraRandom))) {
					System.out.println("¡ACERTASTE!");
					contadorAciertos++;
				} else {
					System.out.println("¡FALLASTE! La respuesta correcta es " + diccionario.traducir(palabraRandom));
				}						
		}
		System.out.println("Acertaste " + contadorAciertos + " de 5.");
	}
}
