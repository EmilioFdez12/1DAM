package prog.unidad05.ficheros.ejercicio05;

public class Disco {

  private String titulo;
  private String autor;
  private int anyoPublicacion;
  private double precio;
  private boolean CD;

  public Disco(String titulo, String autor, int anyoPublicacion, double precio, boolean CD) {
    if (!titulo.isEmpty() || !titulo.isBlank()) {
      this.titulo = titulo;
    } else {
      throw new IllegalArgumentException();
    }

    if (!autor.isEmpty() || !autor.isBlank()) {
      this.autor = autor;
    } else {
      throw new IllegalArgumentException();
    }

    if (anyoPublicacion <= 0) {
      throw new IllegalArgumentException();
    } else {
      this.anyoPublicacion = anyoPublicacion;
    }

    if (precio <= 0) {
      throw new IllegalArgumentException();
    } else {
      this.precio = precio;
    }

    this.CD = CD;

  }

  public String getTitulo() {
    return titulo;
  }

  public String getAutor() {
    return autor;
  }

  public int getAnyoPublicacion() {
    return anyoPublicacion;
  }

  public double getPrecio() {
    return precio;
  }

  public String getCD(Disco disco) {
    if (disco.compruebaCD()) {
      return "si";
    } else {
      return "no";
    }
  }

  private boolean compruebaCD() {
    return CD;
  }

  public String imprimirDisco(Disco disco) {
    return "Titulo: " + disco.getTitulo() + ", Autor: " + disco.getAutor() + ", Año Publicación: "
        + disco.getAnyoPublicacion() + ", Precio: " + disco.getPrecio() + ", ¿Formato CD?: " + disco.getCD(disco);
  }

}
