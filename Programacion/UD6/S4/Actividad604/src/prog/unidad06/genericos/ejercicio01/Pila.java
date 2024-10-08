package prog.unidad06.genericos.ejercicio01;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Pila<T> {
  List<T> pila;
  
  public Pila() {
    pila = new ArrayList<T>();
  }
  
  public void push(T elemento) {
    pila.add(elemento);
  }
  
  public T pop() {
    int size = getNumeroElementos();
    
    if (size > 0) {
      T elemento = pila.get(size - 1);
      pila.remove(size - 1);
      return elemento;
    } else {
      throw new EmptyStackException();
    }
  }
  
  public boolean esVacia() {
    return getNumeroElementos() == 0;
  }
  
  
  public int getNumeroElementos() {
    return pila.size();
  }
}
