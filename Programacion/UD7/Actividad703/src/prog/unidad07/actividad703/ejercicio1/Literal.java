package prog.unidad07.actividad703.ejercicio1;

public class Literal extends Expresion {

	// Atributos
	// Valor
	private int valor;

	/**
	 * Constructor de un literal
	 * @param valor Valor del Literal
	 */
	public Literal(int valor) {
		this.valor = valor;
	}

	@Override
	public int evaluar() {
		return valor;
	}

}
