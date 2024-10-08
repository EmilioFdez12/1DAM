package prog.unidad06.mapas.ejercicio04;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TerminalVentaApp {

  public static final String CODIGO_DESCUENTO = "ECODTO";

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Map<String, Double> mapaSuperMercado = new HashMap<>();
    mapaSuperMercado.put("avena", 2.21);
    mapaSuperMercado.put("garbanzos", 2.39);
    mapaSuperMercado.put("tomates", 1.59);
    mapaSuperMercado.put("jengibre", 3.13);
    mapaSuperMercado.put("quinoa", 4.50);
    mapaSuperMercado.put("guisantes", 1.60);

    String productoAComprar;
    int cantidadAComprar;
    double precioProducto;

    Map<String, Integer> productosAVender = new HashMap<>();

    System.out.println("TERMINAL DEL PUNTO DE VENTA");

    do {

      System.out.print("Introduzca el nombre del producto (vacío para terminar): ");
      productoAComprar = sc.nextLine();
      

      if (!productoAComprar.isBlank() && mapaSuperMercado.containsKey(productoAComprar)) {
        System.out.print("Introduzca la cantidad del producto comprada (número entero): ");
        cantidadAComprar = Integer.parseInt(sc.nextLine());

        productosAVender.put(productoAComprar, cantidadAComprar);
      }
    } while (!productoAComprar.isBlank());

    System.out.print("Introduzca el código de descuento (vacío si no tiene ninguno): ");
    String codigo = sc.nextLine();

    double subtotal = 0;
    System.out.println("Producto  Precio Cantidad Subtotal");
    System.out.println("----------------------------------");
    for (Map.Entry<String, Integer> elemento : productosAVender.entrySet()) {
      String producto = elemento.getKey();
      int cantidad = elemento.getValue();
      double precio = mapaSuperMercado.get(producto);
      double subtotalProducto = precio * cantidad;      
      subtotalProducto = Math.round(subtotalProducto * 100) / 100.0;
     

      // Producto
      System.out.print(justificaIzquierda(producto, 8));
      System.out.print(" ");
      // Precio
      System.out.print(justificaDerecha(precio, 7));
      System.out.print(" ");
      // Cantidad
      System.out.print(justificaDerecha(cantidad, 8));
      System.out.print(" ");
      // Subtotal
      System.out.print(justificaDerecha(subtotalProducto, 8));
      System.out.println();
      
      // Sumamos el subtotal
      subtotal += subtotalProducto;
    }
    double descuento = 0;
    System.out.println("----------------------------------");
    System.out.print("Subtotal: ");
    System.out.println(" " +subtotal);
    System.out.print("Descuento: ");
    if (codigo.equals(CODIGO_DESCUENTO)) {
      descuento = (subtotal * 0.1);
      descuento = Math.round(descuento * 100) / 100.0;
      System.out.println(descuento);
    } else {
      System.out.println("0");
    }
    System.out.println("----------------------------------");
    System.out.print("Total: ");
    double total = (subtotal - descuento);
    total = Math.round(total * 100) / 100.0;
    System.out.print(total);
    
  }

  private static String justificaDerecha(double valor, int longitud) {
    // Convertimos el número a cadena
    String resultado = String.valueOf(valor);
    // Y lo rellena
    return rellena(resultado, longitud, true);
  }

  private static String justificaIzquierda(String valor, int longitud) {
    return rellena(valor, longitud, false);
  }

  private static String rellena(String valor, int longitud, boolean inicio) {
    // Mientras que no tenga la longitud requerida
    while (valor.length() < longitud) {
      // Según por donde haya que rellenar añade un espacio por esa zona
      if (inicio) {
        valor = " " + valor;
      } else {
        valor += " ";
      }
    }
    // Devolvemos el resultado
    return valor;
  }
}
