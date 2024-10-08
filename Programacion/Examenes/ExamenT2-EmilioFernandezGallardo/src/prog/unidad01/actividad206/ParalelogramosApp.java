package prog.unidad01.actividad206;

import java.util.Scanner;
import java.util.Random;
import es.iespablopicasso.programacion.bloque02.figuras.Paralelogramo;

public class ParalelogramosApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("EXAMEN de Emilio_Fernández_Gallardo. PROPIEDADES DE LOS PARALELOGRAMOS");
		System.out.print("Introduzca la longitud de los lados horizontales: ");
		double ladoHorizontal = Double.parseDouble(sc.nextLine());
		System.out.print("Introduzca el límite mínimo de los posibles valoresde la longitud: ");
		double ladoVerticalMin = Double.parseDouble(sc.nextLine());
		System.out.print("Introduzca el límite máximo de los posibles valoresde la longitud: ");
		double ladoVerticalMax = Double.parseDouble(sc.nextLine());
		
		
		//Lo comento porque genera un numero entre 0 y 1 :(
//		Random random = new Random();
//		random.doubles(ladoVerticalMin,ladoVerticalMax);
//		
//		double ladoVertical = (random.nextDouble());
		
				
		System.out.println("La longitud del lado vertical obtenida al azar es de: " + ladoVerticalMax);
		
		//calcular area y perimetro
		//Creamos el paralelogramo
		Paralelogramo paralelogramo1 = new Paralelogramo(ladoHorizontal, ladoVerticalMax);
		
		//lo pasamos a cadena para despue poder dividir la cadena
		String cadena = paralelogramo1.getAreaPerimetro();
		
		//Lo mostramos en pantalla
		System.out.println("El area del paralelogramo es= " + cadena.substring(0,4));
		System.out.println("El perimetro del paralelogramo es= " + cadena.substring(5));
		
		
		System.out.println("Introduzca el factor real positivo por el que desea ampliar el paralelogramo: ");
		double escalado = Double.parseDouble(sc.nextLine());
		
		//Escalamos el paralelogramo en funcion de lo que diga el cliente
		paralelogramo1.escala(escalado);
		
		//Mostramos los atributos del paralelogramo escalado
		System.out.println("El area del paralelogramo escalado es de " + cadena.substring(0,4));
		System.out.println("El  perimetro del paralelogramo escalado es de " + cadena.substring(5));


		sc.close();
	}

}


