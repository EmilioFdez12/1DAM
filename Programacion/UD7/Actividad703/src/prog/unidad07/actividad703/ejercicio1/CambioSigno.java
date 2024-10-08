package prog.unidad07.actividad703.ejercicio1;

public class CambioSigno extends OperacionUnaria {

	public CambioSigno(Expresion operando) {
		super(operando);	
	}

	@Override
	public int evaluar() {	
		return -operando.evaluar();
	}

}
