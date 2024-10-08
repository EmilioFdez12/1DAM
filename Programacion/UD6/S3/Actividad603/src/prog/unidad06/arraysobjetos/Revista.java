package prog.unidad06.arraysobjetos;

public class Revista extends Publicacion {
  private int numero;


  public Revista(String titulo,  int numero, int anyoPublicacion) {
    this.titulo = titulo;
    this.numero = numero;
    this.anyoPublicacion = anyoPublicacion;
  }


  public int getNumero() {
    return numero;
  }

}
