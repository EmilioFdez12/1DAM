package prog.unidad07.actividad703.ejercicio1;

public abstract class OperacionUnaria extends Operacion {

	// Atributo
	protected Expresion operando;

	protected OperacionUnaria(Expresion operando) {
		this.operando = operando;
	}

}
