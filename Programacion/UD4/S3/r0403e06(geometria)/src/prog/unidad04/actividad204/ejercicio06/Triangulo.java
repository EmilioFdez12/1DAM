package prog.unidad04.actividad204.ejercicio06;

public class Triangulo {

	private Punto vertice1;
	private Punto vertice2;
	private Punto vertice3;

	/**
	 * 
	 * @param vertice1 Primer vértice del triangulo
	 * @param vertice2 Segundo vértice del triangulo
	 * @param vertice3 Tercer vértice del triangulo
	 */

	public Triangulo(Punto vertice1, Punto vertice2, Punto vertice3) {
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
		this.vertice3 = vertice3;
	}

	// Hallamos la manera de calcular el perimetro, una vez tengamos esto podemos
	// usar este mismo metodo, pero con retoques para calcular el area
	public double perimetro() {
		// Ecuacion para hallar la distancia entre dos puntos
		// Lado A-B
		double lado1 = Math.sqrt((Math.pow(vertice2.getX() - vertice1.getX(), 2)) + (Math.pow(vertice2.getY() - vertice1.getY(), 2)));
		// Lado B-C
		double lado2 = Math.sqrt((Math.pow(vertice3.getX() - vertice2.getX(), 2)) + (Math.pow(vertice3.getY() - vertice2.getY(), 2)));
		// Lado A-C
		double lado3 = Math.sqrt((Math.pow(vertice3.getX() - vertice1.getX(), 2)) + (Math.pow(vertice3.getY() - vertice1.getY(), 2)));
		// Perimetro
		double perimetro = lado1 + lado2 + lado3;

		return perimetro;
	}
	/**
	 * 
	 * @return Devuelve el area del Triangulo
	 */

//Primero tenemos que calcular la distancia entre cada punto para sumarla
	// Area del triangulo es la suma de todos sus lados partido 2 --> (a+b+c)/2
	public double area() {
		double area = (perimetro() / 2);

		return area;
	}

}
