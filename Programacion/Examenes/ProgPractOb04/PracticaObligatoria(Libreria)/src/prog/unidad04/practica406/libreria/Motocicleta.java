package prog.unidad04.practica406.libreria;

public class Motocicleta extends Vehiculo implements ConvertibleATexto {

	/**
	 * Cilindrada de la motocicleta
	 */
	protected int cilindrada;

	/**
	 * @param matricula Matricula de la motocicleta
	 * @param fechaMatriculacion Fecha de matriculacion de la Motocicleta
	 * @param cilindrada Cilindrada de la motocicleta
	 */
	public Motocicleta(String matricula, Fecha fechaMatriculacion, int cilindrada) {
		// Llamamos al constructor de vehiculo
		super(matricula, fechaMatriculacion);

		if (cilindrada >= 50) {
			this.cilindrada = cilindrada;
		} else {
			throw new IllegalArgumentException();
		}
	}

	public int getCilindrada() {
		return cilindrada;
	}

/**
 * Obtiene una representación en texto del contenido del objeto
 * 	El formato es:
 * Matricula: MMMM, Fecha Matriculacion: FFFF, Cilindrada: CCCC
 * donde MMMM es la matrícula, FFFF es la fecha de matriculación y CCCC es la cilindrada
 *  
 * @return Cadena con la información del objeto en formato texto
 */
	@Override
	public String aTexto() {
		
		return "Matricula: " + matricula + ", Fecha Matriculacion: " + fechaMatriculacion.aTexto() + ", cilindrada: " + cilindrada;
	}

}
