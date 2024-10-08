package prog.unidad07.ejercicio02;

public class Comisionista extends EmpleadoFijo {
  
  // Porcentaje de comision
  protected Double porcentaje;
  // Ventas del mes
  protected Double ventas;
  

  protected Comisionista(String nombre, String dni, String telefono, double salario, double porcentaje, double ventas) {
    super(nombre, dni, telefono, salario);
    if (porcentaje >= 0 && porcentaje <= 1) {
      this.porcentaje = porcentaje;
    } else {
      throw new IllegalArgumentException("Porcentaje no válido. Debe ser un número real entre 0 y 1, ambos incluidos");
    }
    if (ventas >= 0) {
      this.ventas = ventas;
    } else {
      throw new IllegalArgumentException("Ventas no válidas. Deben ser un número positivo o cero");
    }    
  }

  @Override
  public double getSalario() {
    return redondea2Decimales(super.getSalario() + (porcentaje * ventas) );
  }

}
