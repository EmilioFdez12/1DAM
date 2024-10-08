package r03e09;

import java.util.Scanner;

public class NumeroCifrasApp {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Introduce un numero entero y te dire cuantas cifras tiene: ");
			int cifra = Integer.parseInt(sc.nextLine()); 
			
			if (cifra < 10 ) {
				System.out.println("El número " + cifra + " tiene una cifra");
			
			}else if ((cifra >= 10) &&( cifra < 100 )) {
				System.out.println("El número " + cifra + " tiene dos cifras");
		
			}else if (cifra >= 100 && cifra <1000 ) {
				System.out.println("El número " + cifra + " tiene tres cifras");
			
			}else 
				System.out.println("El número " + cifra + " tiene mas de tres cifras");
			
			sc.close();
			}
	
	}

			
	
			
			

			
			
