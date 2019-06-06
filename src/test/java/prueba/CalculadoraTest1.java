package prueba;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculadoraTest1 {
	
	private final Calculadora calc = new Calculadora();
	
	@Test 
	void testSuma() {
		int resultado = calc.suma(1, 2);
		assertEquals(3, resultado);
	}

	@Test
	void testResta() {

		int resultado = calc.resta(2, 3);
		assertEquals(-1, resultado);
	}

	@Test
	void testMultiplicacion() {

		int resultado = calc.multiplicacion(3, 5);
		assertEquals(15, resultado);
	}

	@Test
	void testDivision() {

		int resultado = calc.division(9, 3);
		assertEquals(3, resultado);
	}

	@ParameterizedTest
	@ValueSource(strings= {"Prueba 1", "Prueba 2", "Prueba 3"})
	void parameterizedTestSuma(String prueba) {
		int resultado = calc.suma(1, 2);
		assertEquals(3, resultado);
	}
	
	@RepeatedTest(3)
	void repeatedTestResta() {
		int resultado = calc.resta(2, 3);
		assertEquals(-1, resultado);
	}
	
	@TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection() {
		int resultado = calc.division(9, 3);
		int resultado2 = calc.resta(2, 3);
        return Arrays.asList(
            dynamicTest("1st dynamic test", () -> assertEquals(3, resultado)),
            dynamicTest("2nd dynamic test", () -> assertEquals(-1, resultado2))
        );
    }
	
	final List<String> fruits = Arrays.asList("apple", "banana", "lemon");
	
	@TestTemplate
    @ExtendWith(CalculadoraProvider.class)
	void testTemplate(String fruit) {
		assertTrue(fruits.contains(fruit));
    }
	
	@Order(1)
	@Test	
	void order1() {
		System.out.println("Order 1");
	}
	
	@Order(2)
	@Test	
	void order2() {
		System.out.println("Order 2");
	}
	
	@Order(3)
	@Test	
	void order3() {
		System.out.println("Order 3");
	}
	

}
