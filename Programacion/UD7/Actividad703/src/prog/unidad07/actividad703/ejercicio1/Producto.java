package prog.unidad07.actividad703.ejercicio1;

public class Producto extends OperacionBinaria {

	public Producto(Expresion operandoIzquierdo, Expresion operandoDerecho) {
		super(operandoIzquierdo, operandoDerecho);
	}

	@Override
	public int evaluar() {
		return operandoIzquierdo.evaluar() * operandoDerecho.evaluar();
	}

}
