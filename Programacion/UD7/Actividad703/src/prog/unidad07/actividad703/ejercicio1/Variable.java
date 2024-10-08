package prog.unidad07.actividad703.ejercicio1;

public class Variable extends Expresion {
	
	//Atributos
	private String nombre;
	private int valor;
	
	public Variable(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	

	@Override
	public int evaluar() {
		return valor;
	}

}
