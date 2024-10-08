package prog.unidad04.actividad402.ejercicio08;

public class PruebaSuma {

  public static void main(String[] args) {
    IntervaloTiempo intervalo1 = new IntervaloTiempo(1, 20, 30);
    IntervaloTiempo intervalo2 = new IntervaloTiempo(2, 40, 50);
    
    IntervaloTiempo suma = intervalo1.suma(intervalo2);
    intervalo2 = intervalo2;
  }

}
