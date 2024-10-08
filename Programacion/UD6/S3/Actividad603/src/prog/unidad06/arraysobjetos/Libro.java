package prog.unidad06.arraysobjetos;

public class Libro extends Publicacion {
  private String autor;


  public Libro(String titulo, String autor, int anyoPublicacion) {
    this.titulo = titulo;
    this.autor = autor;
    this.anyoPublicacion = anyoPublicacion;
  }


  public String getAutor() {
    return autor;
  }

}
