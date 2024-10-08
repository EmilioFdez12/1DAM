package prog.unidad04.practica406.principal;

import java.time.LocalDate;

import java.util.Scanner;

import prog.unidad04.practica406.libreria.Automovil;
import prog.unidad04.practica406.libreria.Motocicleta;
import prog.unidad04.practica406.libreria.Fecha;
import prog.unidad04.practica406.libreria.Vehiculo;
import prog.unidad04.practica406.libreria.ConvertibleATexto;

public class VehiculosApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("PRÁCTICA DE EMILIO FERNÁNDEZ GALLARDO. GESTIÓN DE VEHÍCULOS");

		// Lo declaramos null para detectar coche(realmente estamos inicializando la
		// variable
		Automovil coche = null;
		Motocicleta moto = null;
		Fecha fechaMatriculacionCoche = null;
		Fecha fechaMatriculacionMoto = null;
		
		//Bucle do while, mientras el coche sea null repetimos las preguntas, si ponemos mal algun dato no se crea el coche por lo tanto se repiten las preguntas
		do {
			try {
				// Pedida de datos de automovil
				System.out.print("Introduce la matricula del automovil (4 números, 0 o mas espacios y tres letras mayusculas): ");
				String matriculaAutomovil = sc.nextLine();
				
				// Vemos si la fecha esta mal introducida
				try {
				System.out.print("Introduzca el día de la fecha de matriculación del automovil: ");
				int diaMatriculacionAutomovil = Integer.parseInt(sc.nextLine());
				System.out.print("Introduzca el mes de la fecha de matriculación del automovil: ");
				int mesMatriculacionAutomovil = Integer.parseInt(sc.nextLine());
				System.out.print("Introduzca el año de la fecha de matriculación del automovil: ");
				int añoMatriculacionAutomovil = Integer.parseInt(sc.nextLine());
				
				//Creamos la fecha si es correcta
				fechaMatriculacionCoche = new Fecha(diaMatriculacionAutomovil, mesMatriculacionAutomovil,añoMatriculacionAutomovil);
				} catch (IllegalArgumentException e) {
					System.out.println("La fecha no es una fecha válida. Revise los valores e inténtelo de nuevo");
				}
				
				//Pedimos la informacion adicional
				System.out.print("Introduzca el color del automovil (blanco, negro o azul): ");
				String colorAutomovil = sc.nextLine();
				System.out.print("Introduzca el número de plazas del vehículo: ");
				int plazasAutomovil = Integer.parseInt(sc.nextLine());

				// Creo el coche si todos los datos son correctos
				coche = new Automovil(matriculaAutomovil, fechaMatriculacionCoche, colorAutomovil, plazasAutomovil);

			} catch (IllegalArgumentException e) {
				System.out.println("No se pudo crear el automovil. Revise los datos para comprobar que todos son correctos");
			}
		} while (coche == null);

	do {	
		try {
		// Pedida de datos de la moto
		System.out.print("Introduce la matricula de la motocicleta (4 números, 0 o mas espacios y tres letras mayusculas): ");
		String matriculaMoto = sc.nextLine();
		 try {
		System.out.print("Introduzca el día de la fecha de matriculación de la motocicleta: ");
		int diaMatriculacionMoto = Integer.parseInt(sc.nextLine());
		System.out.print("Introduzca el mes de la fecha de matriculación de la motocicleta: ");
		int mesMatriculacionMoto = Integer.parseInt(sc.nextLine());
		System.out.print("Introduzca el año de la fecha de matriculación de la motocicleta: ");
		int añoMatriculacionMoto = Integer.parseInt(sc.nextLine());
		fechaMatriculacionMoto = new Fecha(diaMatriculacionMoto, mesMatriculacionMoto, añoMatriculacionMoto);
		} catch (IllegalArgumentException e) {
			System.out.println("La fecha no es una fecha válida. Revise los valores e inténtelo de nuevo");
		}
		
		System.out.print("Introduzca la cilindrada de la motocicleta: ");
		int cilindradaMoto = Integer.parseInt(sc.nextLine());
		// Creo la moto si todo los datos son correctos
		moto = new Motocicleta(matriculaMoto, fechaMatriculacionMoto, cilindradaMoto);
		
		} catch (IllegalArgumentException e) {
			System.out.println("No se pudo crear el automovil. Revise los datos para comprobar que todos son correctos");
		}
	} while (moto == null);
	
		// Utilizo el metodo para imprimir los datos de los vehículos
    imprimirDatos(coche, moto);

		sc.close();
	}

	public static void imprimirDatos(ConvertibleATexto vehiculo1, ConvertibleATexto vehiculo2) {
		System.out.println("Datos de Automóvil: " + vehiculo1.aTexto());
		System.out.println("Datos de Motocicleta: " + vehiculo2.aTexto());
		
		Fecha matriculacionCoche = ((Vehiculo) vehiculo1).getFechaMatriculacion();
		Fecha matriculacionMoto = ((Vehiculo) vehiculo2).getFechaMatriculacion();

		// Imprimimos información adicional
		// Comprobamos si es bisiesto y lo imprimmos por pantalla
		if (matriculacionCoche.esBisiesto()) {
			System.out.println("El automóvil se matriculó en un año bisiesto.");
		}
		if (matriculacionMoto.esBisiesto()) {
			System.out.println("La motocicleta se matriculó en un año bisiesto.");
		}

		// Conseguimos la fecha actual
		// Creamos fecha actual, y calculamos los dias que han pasado desde el dia de
		// hoy a 1900, (Epoch day es 1970 por eso se le suman 25567 dias(70 años))
		LocalDate fechaActual = LocalDate.now();
		long diasTranscurridosDesdeHoy = fechaActual.toEpochDay() + 25567;

		long diasMatriculacionCoche = diasTranscurridosDesdeHoy	- (((Vehiculo) vehiculo1).getFechaMatriculacion().diasTranscurridos());
		long diasMatriculacionMoto = diasTranscurridosDesdeHoy - (((Vehiculo) vehiculo2).getFechaMatriculacion().diasTranscurridos());

		// Lo que lleva matriculado el coche
		System.out.println("El automóvil lleva matriculado: " + diasMatriculacionCoche + " días.");
		// Lo que lleva matriculada la moto
		System.out.println("La moto lleva matriculada: " + diasMatriculacionMoto + " días.");

		// Comparamos fechas de matriculacion para saber cual se matriculó antes
		if (diasMatriculacionCoche > diasMatriculacionMoto) {
			System.out.println("El automovil se matriculo antes que la motocicleta");
		} else if (diasMatriculacionCoche < diasMatriculacionMoto) {
			System.out.println("La motocicleta se matriculo antes que el automovil");
		} else {
			System.out.println("El automovil y la motocicleta se matricularon el mismo día");
		}

		// Imprimimos por pantalla el numero de vehiculos matriculados
		System.out.println("Número de vehículos matriculados: " + Vehiculo.getVehiculosMatriculados());
	}
}
