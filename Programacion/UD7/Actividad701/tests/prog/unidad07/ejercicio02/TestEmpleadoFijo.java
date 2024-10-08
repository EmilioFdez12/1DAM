package prog.unidad07.ejercicio02;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

  public class TestEmpleadoFijo {

  @Test
  void testTodoNormal() {
  // Caso: Crear un empleado fijo con datos correctos y un salario de 1000 euros
  // RE  : El empleado se crea correctamente y su salario es de 1000 euros  
  Empleado empleado = null;
  try {
    empleado = new EmpleadoFijo("Pepe", "11111111A", "666666666", 1000.0);
  } catch (Exception e) {
    fail("Error al crear un empleado fijo con datos correctos");
  }
    assertEquals(1000.0, empleado.getSalario());
 }
  
  
}
