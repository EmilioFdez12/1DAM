package prog.unidad04.actividad405.ejercicio03;

public class CifraCesar implements Cifra {

  private static int CLAVE_MINIMA = -27;
  private static int CLAVE_MAXIMA = 27;

  // Abecedario
  private static final String ABECEDARIO = "abcdefghijklmnñopqrstuvwxyz";
  private int clave;

  /**
   * Constructor
   * 
   * @param Clave de cifrado.Debe valer entre -27 y 27, ambos incluidos.
   * @throws IllegalArgumentException Si la clave no esta dentro del rango.
   */
  public CifraCesar(int clave) {
    // La guardamos
    if (clave >= CLAVE_MINIMA && clave <= CLAVE_MAXIMA) {
      this.clave = clave;
    } else {
      // Lanzamos excepcion
      throw new IllegalArgumentException();
    }
  }

  @Override
  public String cifra(String mensaje) {
    String cadenaSalida = "";
    for (int i = 0; i < mensaje.length(); i++) {
      char caracter = mensaje.charAt(i);
      int posicionCarcter = ABECEDARIO.indexOf(caracter);
      // Si la posicion es positiva
      char caracterNuevo;
      if (posicionCarcter >= 0) {
        int posicionNuevoCaracter = posicionCarcter + clave;
        if(posicionNuevoCaracter >= ABECEDARIO.length()) {
          posicionNuevoCaracter -= ABECEDARIO.length();
        } else if (posicionNuevoCaracter < 0){
          posicionNuevoCaracter += ABECEDARIO.length();
        } else {
         caracterNuevo = caracter;
        }
        caracterNuevo = ABECEDARIO.charAt(posicionNuevoCaracter);
      } else {
        caracterNuevo = caracter;
      }
      cadenaSalida += caracterNuevo;
    }
    return cadenaSalida;
  }

  @Override
  public String descifra(String mensajeCifrado) {
    String cadenaSalida = "";
    for (int i = 0; i < mensajeCifrado.length(); i++) {
      char caracter = mensajeCifrado.charAt(i);
      int posicionCarcter = ABECEDARIO.indexOf(caracter);
      // Si la posicion es positiva
      char caracterNuevo;
      if (posicionCarcter >= 0) {
        int posicionNuevoCaracter = posicionCarcter - clave;
        if(posicionNuevoCaracter >= ABECEDARIO.length()) {
          posicionNuevoCaracter -= ABECEDARIO.length();
        } else if (posicionNuevoCaracter < 0){
          posicionNuevoCaracter += ABECEDARIO.length();
        } else {
         caracterNuevo = caracter;
        }
        caracterNuevo = ABECEDARIO.charAt(posicionNuevoCaracter);
      } else {
        caracterNuevo = caracter;
      }
      cadenaSalida += caracterNuevo;
    }
    return cadenaSalida;
  }
  

}
