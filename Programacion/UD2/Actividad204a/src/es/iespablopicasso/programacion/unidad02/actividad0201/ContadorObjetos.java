package es.iespablopicasso.programacion.unidad02.actividad0201;

public class ContadorObjetos {

	public static void main(String[] args) {
		
		GranHermano hermano1= new GranHermano(12);
		GranHermano hermano2 = new GranHermano(12);
		GranHermano hermano3 = new GranHermano(12);
		GranHermano hermano4 = new GranHermano(12);
		
		System.out.println("Se han creado " + GranHermano.getNumeroObjetosCreados() + " objetos");
		
		GranHermano hermano5 = new GranHermano(12);
		GranHermano hermano6 = new GranHermano(12);
		GranHermano hermano7 = new GranHermano(12);
		GranHermano hermano8 = new GranHermano(12);
		
		
		System.out.print("Se han creado " + GranHermano.getNumeroObjetosCreados() + " objetos");
		
	}

}
