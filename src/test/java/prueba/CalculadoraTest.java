package prueba;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class CalculadoraTest {
	private final Calculadora calc = new Calculadora();

	@Test
	void testSuma() {
		int resultado = calc.suma(1, 2);
		assertEquals(3, resultado);
	}

	@Test
	void testRest() {

		int resultado = calc.resta(2, 3);
		assertEquals(-1, resultado);
	}

	@Test
	void testMultiplicacion() {

		int resultado = calc.multiplicacion(3, 5);
		assertEquals(14, resultado);
	}

	@Test
	void testDivision() {

		int resultado = calc.division(9, 3);
		assertEquals(2, resultado);
	}

	@Test
	void testsumaVectores() {
		int[] vectorExpected = new int[] { 2, 4, 6, 8, 10 };
		int[] resultadoActual = calc.sumaVectores(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 3, 4, 5 });
		assertArrayEquals(vectorExpected, resultadoActual);
	}

	@Test
	void testAssertTrue() {
		assertTrue('c' < 'b', () -> "mensaje");

	}

	@Test
	void groupedAssertions() {
		assertAll("calc", () -> assertEquals(3, calc.suma(2, 1)), () -> assertEquals(3, calc.resta(5, 2)));
	}

	@Test
	void testOrdenarBurbuja() {
		int[] vectorAOrdenar = new int[] { 10, 8, 4, 6, 2 };
		int[] resultadoEsperado = new int[] { 2, 4, 6, 8, 10 };
		int[] resultadoActual = calc.ordenarBurbuja(vectorAOrdenar);
		assertArrayEquals(resultadoEsperado, resultadoActual);
	}

	@Test
	void testConexionBD() {
		String conexionEsperada = "jdbc:sqlserver://localhost;user=Qvision;password=Pa$$w0rd;";
		String serverName = "localhost";
		String user = "qvision";
		String password = "Pa$$w0rd";
		assertEquals(conexionEsperada, calc.conexionBD(serverName, user, password));
	}

	@Test
	void testOperacionNumeros() {
		int numero1 = 1;
		int numero2 = 2;
		int numero3 = 3;
		int numero4 = 4;
		int numeroEsperado = 5;
		int numeroActual = calc.operacionNumeros(numero1, numero2, numero3, numero4);
		assertEquals(numeroEsperado, numeroActual);
	}

	@Test
	void testEncontrarLetra() {
		char letra = 'v';
		String cadena = "Qvision";
		String respuestaEsperadaLetra = "No encontró la letra";
		assertEquals(respuestaEsperadaLetra, calc.encontrarLetra(letra, cadena));
	}

	@Test
	void testEncontrarBooleano() {
		boolean boolean1 = true;
		boolean boolean2 = false;
		boolean boolean3 = false;
		assertTrue(calc.encontrarBooleano(boolean1, boolean2, boolean3));
	}

	@Test
	void testEncontrarCompuerta() {
		boolean[] vectorBoolean = { true, true, false };
		int numero1 = 1;
		int numero2 = 2;
		assertTrue(calc.encontrarCompuerta(vectorBoolean, numero1, numero2));
	}

	@Test
	void testLogicaBooleana() {
		assertTrue(calc.logicaBooleana(false, false));
	}

	@Test
	void testEncontrarPalabra() {
		assertEquals(7, calc.encontrarPalabra("Qvision es la mejor empresa", "empresa"));
	}

	@Test
	void testConvertirPalabraANumero() {
		assertEquals("666-4242", calc.convertirPalabraANumero("666-HAHA"));
	}

	@Test
	void testNulos() {
		assertTrue(calc.nulos());
	}

	@Test
	void testMetodo() {
		assertEquals(null, calc.metodo());
	}

	@Test
	void testUbicacionLetra() {
		assertTrue(calc.ubicacionLetra('f'));
	}

	@Test
	void testCompararBooleano() {
		assertFalse(calc.compararBooleano("true", true));
	}

	@Test
	void testNumeroOculto() {
		assertEquals(13, calc.numeroOculto(3));
	}

	@Test
	void testLlaveSecreta() {
		assertTrue(calc.llaveSecreta(6));
	}

	@Test
	void principiosAAA() {
		// Arrange
		Calculadora calculadora = new Calculadora();

		// Act
		int resultado = calculadora.suma(1, 2);

		// Assert
		assertEquals(3, resultado);
	}

	@Test
	void malaPracticaPrincipiosAAA() {
		// Arrange
		Calculadora calculadora = new Calculadora();
		assertEquals(3, calculadora.suma(1, 2)); //Advertencia: estas realizando un assertEquals en la fase de Arrage
		
		// Act
		int resultadoSuma = calculadora.suma(1, 2);

		// Assert
		assertEquals(3, resultadoSuma);
		
		int resultadoResta = calculadora.resta(2, 1); //Advertencia: estas realizando una acción (Act) en la fase de Assert
		assertEquals(resultadoResta, 1); //Advertencia: porqué se realiza un assertEquals de nuevo
		assertEquals(2, resultadoSuma); //Advertencia: porque pruebas de nuevo el mismo resultado
	}
}
