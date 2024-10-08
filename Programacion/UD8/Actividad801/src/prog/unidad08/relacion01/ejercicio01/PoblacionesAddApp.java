package prog.unidad08.relacion01.ejercicio01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PoblacionesAddApp {
  // Constantes
  // URL de la base de datos
  private static final String URL = "jdbc:sqlite:db/poblaciones.db";
  private static final String SQL_INSERT = "INSERT INTO pueblos (codigo, nombre, extension, pob_total,"
      + "pob_hombres, pob_mujeres, vehiculos, lineas_tel) VALUES ('%s','%s','%f','%d' ,'%d','%d','%d','%d')";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Solicita los datos al usuario
    System.out.println("Introduzca los datos de la nueva población");
    System.out.print("Código: ");
    String codigo = sc.nextLine();
    System.out.print("Nombre de la población: ");
    String nombre = sc.nextLine();
    System.out.print("Extensión (en km2): ");
    double extension = Double.parseDouble(sc.nextLine());
    System.out.print("Población (Hombres): ");
    int hombres = Integer.parseInt(sc.nextLine());
    System.out.print("Población (Mujeres): ");
    int mujeres = Integer.parseInt(sc.nextLine());
    System.out.print("Número de vehiculos: ");
    int vehiculos = Integer.parseInt(sc.nextLine());
    System.out.print("Número de líneas telefónicas: ");
    int lineas = Integer.parseInt(sc.nextLine());
    
    // Inserta el registro en la base de datos
    try (Connection conexion = DriverManager.getConnection(URL);
        Statement sentencia = conexion.createStatement();){
      String sql = String.format(SQL_INSERT, codigo, nombre, extension, (hombres + mujeres), hombres, mujeres,
          vehiculos, lineas );
      
      sentencia.executeUpdate(sql);
      System.out.println("La población se insertó con éxito");
      
    } catch (SQLException e) {
      System.out.printf("Ocurrió un error añadiendo la población: %s%n", e.getMessage());
    }
  }
}
