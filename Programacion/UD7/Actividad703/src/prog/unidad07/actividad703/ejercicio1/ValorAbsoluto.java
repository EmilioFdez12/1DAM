package prog.unidad07.actividad703.ejercicio1;

public class ValorAbsoluto extends OperacionUnaria {

	public ValorAbsoluto(Expresion operando) {
		super(operando);
	}

	@Override
	public int evaluar() {
		int valor = operando.evaluar();

		if (valor < 0) {
			valor = -valor;
		}
		return valor;
	}

}
