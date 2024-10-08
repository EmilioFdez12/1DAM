package prog.ud07.juego;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestGuerrero {

  @Test
  void testGuerrero1() {
    Personaje guerrero = new Guerrero("Juan", 100, true, true);
    guerrero.serCurado(10);
    
    assertTrue(guerrero.estaVivo());
    assertTrue(guerrero.tieneArmadura());
    assertEquals(100, guerrero.getSalud());
    assertEquals(50, guerrero.getAtaqueActual());
    assertEquals(0, guerrero.getCuracionActual());     
  }
  
  @Test
  void testGuerrero2() {
    Personaje guerrero = new Guerrero("Jose", 100, false, true);
    guerrero.serAtacado(50);
    
    assertTrue(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(50, guerrero.getSalud());
    assertEquals(25, guerrero.getAtaqueActual());
    assertEquals(0, guerrero.getCuracionActual());     
  }
  
  @Test
  void testGuerrero3() {
    Personaje guerrero = new Guerrero("Lolito", 100, true, true);
    guerrero.serAtacado(200);
    
    assertFalse(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(0, guerrero.getSalud());
    assertEquals(0, guerrero.getAtaqueActual());
    assertEquals(0, guerrero.getCuracionActual());     
  }
  
  @Test
  void testGuerrero4() {
    Personaje guerrero = new Guerrero("Pepe", 100, false, false);
    guerrero.serAtacado(50);
    guerrero.serCurado(10);
    
    assertTrue(guerrero.estaVivo());
    assertFalse(guerrero.tieneArmadura());
    assertEquals(70, guerrero.getSalud());
    assertEquals(70, guerrero.getAtaqueActual());
    assertEquals(0, guerrero.getCuracionActual());     
  }
}
