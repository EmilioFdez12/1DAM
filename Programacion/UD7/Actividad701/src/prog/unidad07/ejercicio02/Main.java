package prog.unidad07.ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    
    Empleado empleado1 = new EmpleadoFijo("Manolo", "77687482C", "679266870", 20000.0);

    CalculadorNomina calculadora = new CalculadorNomina();
    
    List<Empleado> listaEmpleados = new ArrayList<>();
    listaEmpleados.add(empleado1);
    
   System.out.println(calculadora.calculaNominaCompleta(listaEmpleados)); 
    
  }

}
