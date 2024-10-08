package prog.unidad05.consola.ejercicio02;

import java.util.Scanner;

import prog.unidad05.consola.ejercicio01.TablasMultiplicarModificada;

public class TablasMultiplicarModificadaApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("De que numero entero quieres mostrar su tabla de multiplicar: ");
    int numEntero = Integer.parseInt(sc.nextLine());

    TablasMultiplicarModificada tabla = new TablasMultiplicarModificada(numEntero);
    
    tabla.imprimeTabla();

    sc.close();
  }

}
