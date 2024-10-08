import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import prog.unidad07.actividad703.ejercicio1.CambioSigno;
import prog.unidad07.actividad703.ejercicio1.Division;
import prog.unidad07.actividad703.ejercicio1.Expresion;
import prog.unidad07.actividad703.ejercicio1.ExpresionException;
import prog.unidad07.actividad703.ejercicio1.Literal;
import prog.unidad07.actividad703.ejercicio1.Suma;
import prog.unidad07.actividad703.ejercicio1.Variable;

public class PruebasActividad703 {

	@Test
	void testLiteral() {
		Expresion literal = null;
		literal = new Literal(3);

		assertEquals(3, literal.evaluar());
	}

	@Test
	void testVariable() {
		Expresion variable = null;
		variable = new Variable("Bottas", 3);

		assertEquals(3, variable.evaluar());
	}

	@Test
	void testCambioSignoPositivo() {
		Expresion literal = null;
		literal = new Literal(3);

		Expresion cambio = new CambioSigno(literal);

		assertEquals(-3, cambio.evaluar());
	}

	@Test
	void testCambioSignoNegativo() {
		Expresion literal = null;
		literal = new Literal(-3);

		Expresion cambio = new CambioSigno(literal);

		assertEquals(3, cambio.evaluar());
	}

	@Test
	void testSuma() {
		Expresion operandoIzquierdo = null;
		Expresion operandoDerecho = null;
		
		operandoIzquierdo = new Literal(-3);
		operandoDerecho = new Literal(4);
		
		Expresion operacion = null;
		operacion = new Suma(operandoIzquierdo, operandoDerecho);
		
		assertEquals(1, operacion.evaluar());

	}
	
	@Test
	void testDivision() {
		Expresion operandoIzquierdo = null;
		Expresion operandoDerecho = null;
		
		operandoIzquierdo = new Literal(4);
		operandoDerecho = new Literal(0);
		
		 final Expresion operacion = new Division(operandoIzquierdo, operandoDerecho);
		
		assertThrows(ExpresionException.class, () -> operacion.evaluar());

	}
	
}
