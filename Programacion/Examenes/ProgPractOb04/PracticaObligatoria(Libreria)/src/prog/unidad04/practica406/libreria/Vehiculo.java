package prog.unidad04.practica406.libreria;

/**
 * Clase que representa un vehículo
 */
public class Vehiculo implements ConvertibleATexto {

	/**
	 * Fecha de matriculación del vehiculo
	 */
	protected Fecha fechaMatriculacion;

	/**
	 * Matricula del vehículo
	 */
	protected String matricula;

	/**
	 * Número de vehiculos matriculados hasta el momento
	 */
	protected static int vehiculosMatriculados = 0;

	/**
	 * Constructor protegido para que no pueda usarse para crear objetos desde
	 * clases que no hereden de esta 
	 * @param matricula Matricula del vehículo
	 * @param fechaMatriculacion Fecha de matriculacion del vehículo
	 * @throws IllegalArgumentException - Si alguno de los parametros no es valido
	 */
	protected Vehiculo(String matricula, Fecha fechaMatriculacion) {
		// Contamos el numero de matriculaciones
		if (validarMatricula(matricula) == true) {
			vehiculosMatriculados++;
			this.matricula = matricula;
			if (fechaMatriculacion == null) {
			  throw new IllegalArgumentException();
			  } else {
			    this.fechaMatriculacion = fechaMatriculacion;
			  }	
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Obtiene la fecha de matriculacion del vehículo
	 * @return La fecha de la Matriculacion
	 */
	public Fecha getFechaMatriculacion() {      
		return fechaMatriculacion;
	}

	/**
	 * Obtiene la matricula del vehículo
	 * @return La matricula
	 */
	public String getMatricula() {
		return matricula;

	}

	/**
	 * Número de vehiculos matriculados hasta el momento
	 * @return El numero de vehiculos matriculados
	 */
	public static int getVehiculosMatriculados() {
		return vehiculosMatriculados;
	}

	// Metodo privado para validar las matriculas
	private boolean validarMatricula(String matricula) {

    String matriculaAValidar = matricula;

    int contadorCaracteres = 0;
    boolean caracterCorrecto = true;

    matriculaAValidar = matriculaAValidar.replace(" ", "");

    while (caracterCorrecto && contadorCaracteres < 7) {
      if (contadorCaracteres <= 3) {
        if (!Character.isDigit(matriculaAValidar.charAt(contadorCaracteres))) {
          caracterCorrecto = false;
        }
      } else {
        if (!Character.isUpperCase(matriculaAValidar.charAt(contadorCaracteres))) {
          caracterCorrecto = false;
        }

        if(matriculaAValidar.length() != 7) {
          caracterCorrecto = false;
        }
      }
      contadorCaracteres++;
    }
    return caracterCorrecto;
  }

	@Override
	public String aTexto() {
		return matricula;
	}
}
