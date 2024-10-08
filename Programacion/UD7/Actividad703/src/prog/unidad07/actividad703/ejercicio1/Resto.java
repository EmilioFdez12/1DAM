package prog.unidad07.actividad703.ejercicio1;

public class Resto extends OperacionBinaria {

	public Resto(Expresion operandoIzquierdo, Expresion operandoDerecho) {
		super(operandoIzquierdo, operandoDerecho);
	}

	@Override
	public int evaluar() {
		int valorDerecho = operandoDerecho.evaluar();
		if (valorDerecho != 0) {
			return operandoIzquierdo.evaluar() % operandoDerecho.evaluar();
		} else {
			throw new ExpresionException("Error. Intento de dividir por cero");
		}
		
	}

}
