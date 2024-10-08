
public class LapizApp {
	public static void main(String[] args) {

		Lapiz lapiz1 = new Lapiz();

		// Giramos el lapiz hacia abajo lo bajamos y lo movemos 20 puntos
		lapiz1.gira(270);
		lapiz1.baja();
		lapiz1.desplaza(20);

		// Giramos el hacia la derecha y lo movemos 20 puntos
		lapiz1.gira(90);
		lapiz1.desplaza(20);

		// Giramos el hacia la arriba y lo movemos 20 puntos
		lapiz1.gira(90);
		lapiz1.desplaza(20);

		// Giramos el hacia la izquierda y lo movemos 20 puntos
		lapiz1.gira(90);
		lapiz1.desplaza(20);

		double trazo1 = lapiz1.getNumTrazos();
		System.out.println("El numero de trazos es " + trazo1);
		
		
		//Punto punto1 = new Punto(0, 0);
		//Punto punto2 = new Punto(0, -20);
		//Punto punto3 = new Punto(20, -20);
		//Punto punto4 = new Punto(20, 0);
		  
		System.out.println(lapiz1.getTrazo(1));
		System.out.println(lapiz1.getTrazo(2));
		System.out.println(lapiz1.getTrazo(3));
		System.out.println(lapiz1.getTrazo(4));
		
		//Pasamos al triangulo
		
		Lapiz lapiz2 = new Lapiz();
				
		//movemos el lapiz al punto inicial
		
		lapiz2.desplaza(20);
		lapiz2.gira(90);
		lapiz2.desplaza(35);
		
		//dibujamos el triangulo
		lapiz2.gira(-90);
		lapiz2.baja();
		lapiz2.desplaza(30);
		
		lapiz2.gira(120);
		lapiz2.desplaza(30);
		
		lapiz2.gira(90);
		lapiz2.desplaza(30);
		
		lapiz2.sube();
		
		System.out.println( "El numero de trazos del triangulo es de: "+ lapiz2.getNumTrazos());
		
		
		
		//Pasamos al pentagono
		
				Lapiz lapiz3 = new Lapiz();
						
				//movemos el lapiz al punto inicial
				
				lapiz3.desplaza(25);
				lapiz3.gira(90);
				lapiz3.desplaza(55);
				
				//dibujamos el pentagono
				
				lapiz3.gira(-90);
				lapiz3.baja();
				lapiz3.desplaza(20);
				
				lapiz3.gira(72);
				lapiz3.desplaza(20);
				
				lapiz3.gira(72);
				lapiz3.desplaza(20);
				
				lapiz3.gira(72);
				lapiz3.desplaza(20);
				
				lapiz3.gira(72);
				lapiz3.desplaza(20);
				
				lapiz3.sube();
		
	}

}
