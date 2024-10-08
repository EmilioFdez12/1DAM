package prog.unidad06.arraysuni.ejercicio07;

import java.util.Scanner;

public class SuperArrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese un número entero
        System.out.print("Introduce un número entero: ");
        int numero = scanner.nextInt();

        // Crear un array de 30 elementos
        int[] array = new int[30];

        // Llenar el array con los valores requeridos
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                array[i] = numero;
            } else {
                array[i] = (array[i - 1] + 1) * 2;
            }
        }
        
        System.out.println(array[27]);

        // Mostrar el array en orden inverso
        System.out.println("Array en orden inverso:");
        for (int i = array.length - 1; i >= 0; i--) {
                  System.out.print(array[i] + " ");
        }

        scanner.close();
    }
}
