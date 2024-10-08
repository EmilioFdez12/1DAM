package prog.unidad07.actividad703.ejercicio1;

public abstract class OperacionBinaria extends Operacion {
	
	//Atributod
	protected Expresion operandoIzquierdo;
	protected Expresion operandoDerecho;
	
	protected OperacionBinaria(Expresion operandoIzquierdo, Expresion operandoDerecho) {
		this.operandoIzquierdo = operandoIzquierdo;
		this.operandoDerecho = operandoDerecho;
	}
}
