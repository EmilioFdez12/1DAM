package prog.unidad04.actividad204.ejercicio05;

import java.util.Scanner;

public class Zona {
	Scanner sc = new Scanner(System.in);

	private int entradas;

	public Zona(int entradas) {
		this.entradas = entradas;
	}

	/**
	 * 
	 * @return El numero de pruebas
	 */
	public int getEntradasPorVender() {
		return entradas;
	}

	public int vender() {
		if (entradas < this.entradas) {
			System.out.print("El numero de entradas a vender es mayor de las entradas que disponemos");
		} else {
			System.out.println("Venta realizada correctamente");
			this.entradas -= entradas;
		}

		return entradas;
	}

}
