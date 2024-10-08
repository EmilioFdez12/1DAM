package prog.unidad04.practica406.libreria;

/**
 * Clase que representa un automovil
 */
public class Automovil extends Vehiculo implements ConvertibleATexto {

	/**
	 * Plazad del automovil
	 */
	protected int plazas;
	
	/**
	 * Color del automovil
	 */
	protected String color;
	
	/**
	 * Color Azul
	 */
	public static final String COLOR_AZUL = "azul";
	
	/**
	 * Color negro
	 */
	public static final String COLOR_NEGRO = "negro";
	
	/**
	 * Color blanco
	 */
	public static final String COLOR_BLANCO = "blanco";

	public Automovil(String matricula, Fecha fechaMatriculacion, String color, int plazas) {
		//LLamo a los constructores de la clase vehiculo
		super(matricula, fechaMatriculacion);

		if (COLOR_AZUL.equals(color) || COLOR_BLANCO.equals(color) || COLOR_NEGRO.equals(color)) {
			this.color = color;
		} else {
			throw new IllegalArgumentException();
		}

		if (plazas > 0) {
			this.plazas = plazas;
		} else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * Obtiene el color del automovil
	 * @return Color del automovil
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Obtiene el número de plazas del automóvil
	 * @return Número de plazas del automóvil
	 */
	public int getPlazas() {
		return plazas;
	}

	/**
	 * Obtiene una representación en texto del automóvil El formato es Matricula:
	 * MMMM, Fecha Matriculacion: FFFF, Color: CCCC, Num. Plazas: PPPPP donde MMMM
	 * es la matricula, FFFF es la fecha de matriculacion, CCCC es el color, PPPP es
	 * el número de plazas
	 * 
	 * @return Cadena con la información del objeto en formato texto
	 */
	@Override
	public String aTexto() {
		return "Matricula: " + matricula+", Fecha Matriculacion: " + fechaMatriculacion.aTexto() + ", color: " + color +", Num. Plazas: "+ plazas;
	}          
}
