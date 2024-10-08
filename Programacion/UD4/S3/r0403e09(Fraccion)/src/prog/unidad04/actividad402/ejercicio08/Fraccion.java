package prog.unidad04.actividad402.ejercicio08;

public class Fraccion {

  private int numerador;
  private int denominador;

  public Fraccion(int numerador, int denominador) {
    this.numerador = numerador;
    this.denominador = denominador;
  }

  public Fraccion suma(Fraccion otra) {
    int numeradorSuma = 0;
    int denominadorResta = 0;
    // Hay que hacer minimo comun multiplo, o otra manera.
    if (this.denominador == otra.denominador) {
      this.numerador = this.numerador + otra.numerador;
    } else {
      // manera rapida de sumar fracciones
      numeradorSuma = (this.numerador * otra.denominador) + (otra.numerador * this.denominador);
      denominadorResta = this.denominador * otra.denominador;
    }

    return new Fraccion(numeradorSuma, denominadorResta);
  }

  public Fraccion resta(Fraccion otra) {
    int nuevoNumerador;
    int nuevoDenominador = 0;
    // Hay que hacer minimo comun multiplo, o otra manera.
    if (denominador == otra.denominador) {
      nuevoNumerador = numerador - otra.numerador;
    } else {
      // manera rapida de restar fracciones
      nuevoNumerador = (numerador * otra.denominador) - (otra.numerador * denominador);
      nuevoDenominador = denominador * otra.denominador;
    }
    return new Fraccion(nuevoNumerador, nuevoDenominador);
  }

  public Fraccion multiplica(Fraccion otra) {

    int productoNumerador = (numerador * otra.numerador);
    int productoDenominador = (denominador * otra.denominador);

    return new Fraccion(productoNumerador, productoDenominador);
  }

  public Fraccion divide(Fraccion otra) {
    int divideNumerador = (numerador * otra.denominador);
    int divideDenominador = (denominador * otra.numerador);

    return new Fraccion(divideNumerador, divideDenominador);
  }

  public void simplifica() {
    int factor = 2;
    // Mientras el factor sea menor que el numerador y el denominador
    while ((factor <= numerador) && (factor <= denominador)) {
      // Si se pueden dividir ambos por el factor
      if ((numerador % factor == 0) && (denominador % factor == 0)) {
        // Se dividen
        numerador /= factor;
        denominador /= factor;
      } else {
        // Este factor no vale, probamos el siguiente
        factor++;
      }
    }
  }

  public int getNumerador() {
    return numerador;
  }

  public int getDenominador() {
    return denominador;
  }

  public String obtieneString() {
    return this.numerador + " / " + this.denominador;
  }

}
