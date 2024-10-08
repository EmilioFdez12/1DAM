package prog.unidad04.actividad405.ejercicio03;

public class CifraPoliAlfabetica implements Cifra {

  private static final String ABECEDARIO = "abcdefghijklmnñopqrstuvwxyz";
  String clave;

  public CifraPoliAlfabetica(String clave) {
    if (clavePerita(clave)) {
      this.clave = clave;
    } else {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public String cifra(String mensaje) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String descifra(String mensajeCifrado) {
    // TODO Auto-generated method stub
    return null;
  }

  private boolean clavePerita(String mensaje) {
    if (clave.length() != ABECEDARIO.length()) {
      return false;
    }
    for (int i = 0; i <= ABECEDARIO.length(); i++) {
      char caracter = ABECEDARIO.charAt(i);
      // Si el caracter esta en la clave
      if (clave.contains("" + caracter)) {
        return false;
      }
    }
    // Si llegamos aqui lo hemos encotrado todo
    return true;
  }
}
