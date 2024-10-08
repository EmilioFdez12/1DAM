package prog.unidad04.actividad405.ejercicio03;

public class PruebaCifras {

  public static void main(String[] args) {
    // Construimos el objeto cifra
    Cifra cifraCesar3 = new CifraCesar(3);

    String mensaje = "agua";

    String mensajeCifrado = cifraCesar3.cifra(mensaje);
    System.out.println(mensajeCifrado);
    
    String mensajeOriginal = cifraCesar3.descifra(mensajeCifrado);
    
    System.out.println(mensajeOriginal);
    }
  
}
