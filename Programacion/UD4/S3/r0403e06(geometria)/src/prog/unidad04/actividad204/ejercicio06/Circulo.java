package prog.unidad04.actividad204.ejercicio06;

public class Circulo {

	private final static double PI = 3.1416;

	private Punto centro;
	private double radio;

	/**
	 * 
	 * @param centro Centro de la circunferencia
	 * @param radio Radio de la circunferencia
	 */
	public Circulo(Punto centro, double radio) {
		this.centro = centro;
		this.radio = radio;
	}

	/**
	 * 
	 * @return Area de un circulo
	 */

	public double area() {
		// Area = pi*(r*r)
		double area = (PI * (Math.pow(radio, 2)));
		return area;
	}
	/**
	 * 
	 * @return Devuelve el perimetro de una circunferencia
	 */

	public double perimetro() {
		// Perimetro = 2 * PI * r
		double perimetro = (2 * radio * PI);
		return perimetro;
	}


}
