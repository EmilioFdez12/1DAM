package Actividad205;

import java.util.Scanner;

public class NavajaSuizaApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Inserta una cadena: ");
			String cadena1= sc.nextLine();
		System.out.print("Inserta una cadena: ");
			String cadena2= sc.nextLine();
				
		
		System.out.println("La longitud de la cadena 1 es de " + cadena1.length() + "|" 
		+ " La cadena 1 tiene espacios en blanco " + cadena1.isBlank());
		System.out.println("La longitud de la cadena 2 es de " + cadena2.length() + "|"
		+" La cadena 2 tiene espacios en blanco " + cadena2.isBlank());
		
		
		//Boolean para ver si esta vacio
		System.out.println(cadena1.isEmpty());
		System.out.println(cadena1.isEmpty());
		
		//Concatenación
		System.out.println(cadena1 + cadena2);
		
		//Comparativa
		System.out.println("La cadena 1 es igual a la cadena 2 -->" + cadena1.equals(cadena2));
		
		
		//Con sensibilidad compareTo
				System.out.println("La cadena 1 es igual a la cadena 2 -->" + cadena1.compareTo(cadena2));
				
		
		//Sin sensibilidad compareTo
		System.out.println("La cadena 1 es igual a la cadena 2 -->" + cadena1.compareTo(cadena2));
		
		
		//La cadena 1 contiene la cadena 2?
		System.out.println("La cadena 1 contiene a la 2 -->" + cadena1.contains(cadena2));
		
		//La primera cadena empieza por la segunda
		System.out.println("La cadena 1 contiene a la 2 -->" + cadena1.startsWith(cadena2));
		
		//La primera cadena termina por la segunda
		System.out.println("La cadena 1 contiene a la 2 -->" + cadena1.endsWith(cadena2));
		
		//nose
		System.out.println("La cadena 1 contiene a la 2 -->" + cadena1.substring(1,2));
		
		
		
		
		sc.close(); 

	}

}
