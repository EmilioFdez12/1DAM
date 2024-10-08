package prog.unidad07.actividad703.ejercicio1;

public class Potencia extends OperacionBinaria {

	public Potencia(Expresion operandoIzquierdo, Expresion operandoDerecho) {
		super(operandoIzquierdo, operandoDerecho);
	}

	@Override
	public int evaluar() {
		int exponente = operandoDerecho.evaluar();
		int resultado = 1;
		// Si el exponente es positivo
		if (exponente > 0) {
			int base = operandoIzquierdo.evaluar();
			resultado = base;
			for (int i = 1; i < exponente; i++) {
				resultado *= base;
			}
		} else if (exponente == 0) {
			resultado = 1;
		} else {
			throw new ExpresionException("Error. Las potencias no pueden tener exponentes negativos");
		}
		return resultado;
	}

}
