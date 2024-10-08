package prog.unidad08.relacion02.entidades;

public class Departamento {
		
	private int numeroDepartamento;
	private String nombre;
	private int codigoCentro;
	private String direccion;
	private int codigoDirector;
	private double presupuesto;
	private int codigoDepartamentoSuperior;

	public Departamento(int numeroDepartamento, String nombre, int codigoCentro, String direccion, int codigoDirector, double presupuesto,
			int codigoDepartamentoSuperior) {
		this.numeroDepartamento = numeroDepartamento;
		this.nombre = nombre;
		this.codigoCentro = codigoCentro;
		this.direccion = direccion;
		this.codigoDirector = codigoDirector;
		this.presupuesto = presupuesto;
		this.codigoDepartamentoSuperior = codigoDepartamentoSuperior;
		
	}
	
	
	
	

}
