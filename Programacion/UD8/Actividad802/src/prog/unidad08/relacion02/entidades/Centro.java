package prog.unidad08.relacion02.entidades;

public class Centro {
	
	// Atributos
	private int codigo;
	private String nombre;
	
	public Centro( int codigo, String nombre) {
		this.codigo = codigo;
		
		if (nombre == null) {
			throw new NullPointerException();
		} else if (nombre.isBlank() && nombre.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.nombre = nombre;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
}
