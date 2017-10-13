package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers() {
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testSplitByNewline() {
		assertEquals(6, Calculator.add("1,2\n3"));
	}

	@Test
	public void testNegativeNumbers(){
		try
		{
			Calculator.add("-1,-2");
		}
		catch(IllegalArgumentException e)
		{
			assertEquals("Negatives not allowed: -1,-2", e.getMessage());
		}
	}

	@Test
	public void testIgnoreLargeNumbers() {
		assertEquals(2, Calculator.add("1001,2"));
	}

	@Test
	public void testSplitOnDifferentDelimiters() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testDifferentDelimitersWithNegativeNumbers(){
		try
		{
			Calculator.add("//;\n1;-2");
		}
		catch(IllegalArgumentException e)
		{
			assertEquals("Negatives not allowed: -2", e.getMessage());
		}
	}
}