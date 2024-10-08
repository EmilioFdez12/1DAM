package prog.unidad04.actividad405.ejercicio03;

public interface Cifra {
/**
 * 
 * @param mensaje
 * @return Mensaje cifrado
 */
  String cifra(String mensaje);
  
  /**
   * 
   * @param mensajeCifrado
   * @return Mensaje descifrado(original)
   */
  
  String descifra(String mensajeCifrado);
}
