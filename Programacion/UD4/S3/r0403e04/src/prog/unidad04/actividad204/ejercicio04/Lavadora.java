package prog.unidad04.actividad204.ejercicio04;

public class Lavadora {

  static final String COLOR_AZUL = "Azul";

  static final String COLOR_BLANCO = "Blanco";

  static final String COLOR_GRIS = "Gris";

  static final String COLOR_NEGRO = "Negro";

  static final String COLOR_ROJO = "Rojo";

  // Atributos
  private char consumoEnergetico;
  private double peso;
  private double carga;
  private double precioBase;
  private String color;
  private double precioFinal;

  /**
   * Constructores
   */
  public Lavadora() {
    this.precioBase = 200;
    this.color = COLOR_BLANCO;
    this.consumoEnergetico = 'F';
    this.peso = 15;
    this.carga = 5;
    this.consumoEnergetico = comprobarConsumo();
    this.color = comprobarColor();

    if (consumoEnergetico == 'A') {
      precioFinal = (precioBase + 100);
    } else if (consumoEnergetico == 'B') {
      precioFinal = (precioBase + 80);
    } else if (consumoEnergetico == 'C') {
      precioFinal = (precioBase + 60);
    } else if (consumoEnergetico == 'D') {
      precioFinal = (precioBase + 50);
    } else if (consumoEnergetico == 'E') {
      precioFinal = (precioBase + 30);
    } else {
      precioFinal = (precioBase + 10);
    }
    if (peso < 20) {
      precioFinal = (precioFinal + 10);
    } else if (peso >= 20 && peso <= 50) {
      precioFinal = (precioFinal + 50);
    } else if (peso > 50 && peso <= 80) {
      precioFinal = (precioFinal + 80);
    } else {
      precioFinal = (precioFinal + 100);
    }
    if (carga > 30) {
      precioFinal = (precioFinal + 50);
    }
  }

  public Lavadora(double precioBase, double peso) {
    this.precioBase = precioBase;
    this.peso = peso;
    this.color = COLOR_BLANCO;
    this.consumoEnergetico = 'F';
    this.carga = 5;
    this.consumoEnergetico = comprobarConsumo();
    this.color = comprobarColor();
    
    if (consumoEnergetico == 'A') {
      precioFinal = (precioBase + 100);
    } else if (consumoEnergetico == 'B') {
      precioFinal = (precioBase + 80);
    } else if (consumoEnergetico == 'C') {
      precioFinal = (precioBase + 60);
    } else if (consumoEnergetico == 'D') {
      precioFinal = (precioBase + 50);
    } else if (consumoEnergetico == 'E') {
      precioFinal = (precioBase + 30);
    } else {
      precioFinal = (precioBase + 10);
    }
    if (peso < 20) {
      precioFinal = (precioFinal + 10);
    } else if (peso >= 20 && peso <= 50) {
      precioFinal = (precioFinal + 50);
    } else if (peso > 50 && peso <= 80) {
      precioFinal = (precioFinal + 80);
    } else {
      precioFinal = (precioFinal + 100);
    }
    if (carga > 30) {
      precioFinal = (precioFinal + 50);
    }
  }

  public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, double carga) {
    this.precioBase = precioBase;
    this.color = color;
    this.consumoEnergetico = consumoEnergetico;
    this.peso = peso;
    this.carga = carga;
    this.consumoEnergetico = comprobarConsumo();
    this.color = comprobarColor();
    
    if (consumoEnergetico == 'A') {
      precioFinal = (precioBase + 100);
    } else if (consumoEnergetico == 'B') {
      precioFinal = (precioBase + 80);
    } else if (consumoEnergetico == 'C') {
      precioFinal = (precioBase + 60);
    } else if (consumoEnergetico == 'D') {
      precioFinal = (precioBase + 50);
    } else if (consumoEnergetico == 'E') {
      precioFinal = (precioBase + 30);
    } else {
      precioFinal = (precioBase + 10);
    }
    if (peso < 20) {
      precioFinal = (precioFinal + 10);
    } else if (peso >= 20 && peso <= 50) {
      precioFinal = (precioFinal + 50);
    } else if (peso > 50 && peso <= 80) {
      precioFinal = (precioFinal + 80);
    } else {
      precioFinal = (precioFinal + 100);
    }
    if (carga > 30) {
      precioFinal = (precioFinal + 50);
    }
  }
  
  /**
   * 
   * @return Devuelve el precio Base
   */

  public double getPrecioBase() {
    return precioBase;
  }
  
  /**
   * 
   * @return Devuelve el color
   */

  public String getColor() {
    return color;
  }
  
/**
 * 
 * @return Devuelve el consumo energetico
 */
  public char getConsumoEnergetico() {
    return consumoEnergetico;
  }

  /**
   * 
   * @return Devuelve el peso
   */
  public double getPeso() {
    return peso;
  }
/**
 * 
 * @return Devuelve la carga
 */
  public double getCarga() {
    return carga;
  }
  
/**
 * 
 * @return Devuelve el precio final 
 */
  public double getPrecioFinal() {
    return precioFinal;
  }

  private char comprobarConsumo() {
    if (consumoEnergetico == 'A' || consumoEnergetico == 'B' || consumoEnergetico == 'C' || consumoEnergetico == 'D'
        || consumoEnergetico == 'E' || consumoEnergetico == 'F') {
      return consumoEnergetico;
    } else {
      return 'F';
    }
  }
  
  private String comprobarColor() {
    if (color == COLOR_AZUL || color == COLOR_BLANCO || color == COLOR_GRIS || color == COLOR_NEGRO
        || color == COLOR_ROJO) {
      return color;
    } else {
      return COLOR_BLANCO;
    }
  }

}