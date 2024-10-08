package prog.unidad08.relacion01.ejercicio04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import prog.unidad08.relacion01.common.Poblacion;

public class ConsultaPoblacionesConOrdenApp {
  // Constantes
  // URL de la base de datos
  private static final String URL = "jdbc:sqlite:db/poblaciones.db";
 

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Solicita los datos al usuario
    System.out.println("Introduzca los datos para la modificación");
    System.out.print("Código del pueblo a modificar: ");
    String codigo = sc.nextLine();
    System.out.print("¿Quiere modificar el número de vehiculos (v) o el de líneas telefónicas (l)?: ");
    char campo = sc.nextLine().toLowerCase().charAt(0);
    // Solicita el nuevo valor del campo
    // Primero muestra el prompt correspondiente al campo elegido o un error si la elección fue invalida
    if (campo == 'v') {
      System.out.print("Introduzca el nuevo valor para el campo vehiculos: ");
    } else if (campo == 'l') {
      System.out.print("Introduzca el nuevo valor para el campo líneas telefónicas: ");
    } else {
      // El campo no es válido. Terminamos
      System.err.println("Selección de campo inválida. Terminando");
      return;
    }
    // Y ahora solicita el valor
    int nuevoValor = Integer.parseInt(sc.nextLine());
    
    try {
      // Actualiza el valor del campo. Si se encontro?
      if (modificaPoblacion(codigo, campo, nuevoValor)) {
        System.out.println("El registro se actualizó con éxito");
      } else {
        System.err.println("No existe ninguna población con código " + codigo);
      }
    } catch (SQLException e) {
      // Si ocurrió error lo muestra
      System.err.println("Ocurrió un error actualizando la fila: " + e);
    }
  }

  private static boolean modificaPoblacion(String codigo, char campo, int nuevoValor)
      throws SQLException {
    try (Connection conexion = DriverManager.getConnection(URL);
        Statement sentencia = conexion.createStatement()) {
      // like de sql
      String sql = "UPDATE pueblos SET ";
      if (campo == 'v') {
        sql += "vehiculos = ";
      } else {
        sql += "lineas_tel = ";
      }
      sql += nuevoValor;
      sql +=  " WHERE codigo = " + sentencia.enquoteLiteral(codigo);
      
      int resultado = sentencia.executeUpdate(sql);
      
      return resultado == 1;
    }
  }


}
