package prog.unidad04.actividad204.ejercicio06;

public class Rectangulo {
	
	private Punto esquina1;
	private Punto esquina2;
	


	/**
	 * @author Emi
	 * @version 1.0
	 * 
	 * Construye un rectangulo, obteniendo dos de los vertices.
	 * @param esquina1
	 * @param esquina2
	 */
	public Rectangulo(Punto esquina1, Punto esquina2) {
		this.esquina1 = esquina1;
		this.esquina2 = esquina2;		
	}
	
	
	
	/**
	 * 
	 * @return Devuelve el area del Rectangulo
	 */
	public double area() {
		//Area = base * altura
		//Para hallar la altura ya la base simplemente tenemos que ver la diferencia entre el eje x de un punto y del otro y el eje y
		//Valor absoluto
		double altura = Math.abs(esquina2.getY() - esquina1.getY()) ;
		double base = Math.abs(esquina2.getX() - esquina1.getX()) ;
		
		double area = (base * altura) ;
		return area;	
	}
	/**
	 * 
	 * @return Devuelve el perimetro de un rectangulo
	 */
	public double perimetro() {
		//Como el perimetro es 2 (base * altura) y  (base * altura) = area, (2 * area), es igual al perimetro.
		double perimetro = (2 * area());	
		return perimetro;
	}
	
	/**
	 * 
	 * @return Si el rectangulo es realmente un rectangulo o un cuadrado.
	 */
	
	public boolean esCuadrado() {
		//Calculamos altura y base.
		double altura = Math.abs(esquina2.getY() - esquina1.getY()) ;
		double base = Math.abs(esquina2.getX() - esquina1.getX()) ;
		
		if(altura == base) {
			return true;
		} else {
			return false;
		}
	}
	
}
