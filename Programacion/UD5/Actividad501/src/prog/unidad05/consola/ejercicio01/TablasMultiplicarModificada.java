package prog.unidad05.consola.ejercicio01;

public class TablasMultiplicarModificada {

    private int numero;

    public TablasMultiplicarModificada(int numero) {
      this.numero = numero;

      if (numero <= 0) {
        throw new IllegalArgumentException();
      }
    }

    public void imprimeTabla() {
      System.out.println("Tabla del " + numero);

      int longitudMaxima = 0;

      for (int i = 1; i <= 10; i++) {
        int multiplicacion = numero * i;
        int longitudMultiplicacion = String.valueOf(multiplicacion).length();
        if (longitudMultiplicacion > longitudMaxima) {
          longitudMaxima = longitudMultiplicacion;
        }
      }

      for (int i = 1; i <= 10; i++) {
        int multiplicacion = (numero * i);
        System.out.printf("%2d X %2d = %" + longitudMaxima + "d%n", numero, i, multiplicacion);

      }
    }

  }

