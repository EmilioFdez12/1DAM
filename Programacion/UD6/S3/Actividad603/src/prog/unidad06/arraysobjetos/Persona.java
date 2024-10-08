package prog.unidad06.arraysobjetos;

public class Persona {
  
  protected String dni;
  protected String nombre;

  
  public Persona() {
        
   if(validarDni(dni)) {
     this.dni = dni;
   } else {
     throw new IllegalArgumentException("Dni incorrecto");
   }
    
    
    if (validarNombre(nombre)) {
      this.nombre = nombre;
    } else {
      throw new IllegalArgumentException("Formato incorrecto para el nombre");
    } 

  }

  public String getDni() {
    return dni;
  }

  public String getNombre() {
    return nombre;
  }
  
  private boolean validarNombre(String nombre) {
    return nombre.length() > 1 && nombre.length() < 100;
  }
  
  private boolean validarDni(String dni) {
    boolean validaDni = false;
    
    if (dni.length() > 9) {
      System.out.println("Ingrese de nuevo el dni");
    } else if (Character.isLetter(dni.charAt(8))) {
      this.dni = dni;
      validaDni = true;
    } else {
      System.out.println("Ingrese de nuevo el dni");
    }
    return validaDni;
  }

}
