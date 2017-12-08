package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.AbsoluteDifference;
import main.BooleanCompare;
import main.Difference;
import main.Euclidian;
import main.Number;

public class NumberTest {
	
	/**
	 * Test method for {@link Number#SetMetric()}.
	 */
	@Test
	public void testSetMetric() {
		Number n6 = new Number("Eric", new Difference(), 13.0);
		Number n7 = new Number("Adam", new Euclidian(), 20.0);
		Number n8 = new Number("Andrew", new BooleanCompare(), 15.0);
		Number n9 = new Number("Sunny", new AbsoluteDifference(), 8.0);
		n6.SetMetric(new Euclidian());
		n7.SetMetric(new Difference());
		n8.SetMetric(new AbsoluteDifference());
		n9.SetMetric(new BooleanCompare());
		assertEquals((n6.GetMetric() instanceof Euclidian), true);
		assertEquals((n7.GetMetric() instanceof Difference), true);
		assertEquals((n8.GetMetric() instanceof AbsoluteDifference), true);
		assertEquals((n9.GetMetric() instanceof BooleanCompare), true);
	}
	
	/**
	 * Test method for {@link Number#GetMetric()}.
	 */
	@Test
	public void testGetMetric() {
		Number n6 = new Number("Eric", new Difference(), 13.0);
		Number n7 = new Number("Adam", new Euclidian(), 20.0);
		Number n8 = new Number("Andrew", new BooleanCompare(), 15.0);
		Number n9 = new Number("Sunny", new AbsoluteDifference(), 8.0);
		assertEquals((n6.GetMetric() instanceof Difference), true);
		assertEquals((n7.GetMetric() instanceof Euclidian), true);
		assertEquals((n8.GetMetric() instanceof BooleanCompare), true);
		assertEquals((n9.GetMetric() instanceof AbsoluteDifference), true);
	}

	/**
	 * Test method for {@link Number#GetName()}.
	 */
	@Test
	public void testGetName() {
		Number n1 = new Number("Sunny", new Euclidian(), 15.0);
		assertEquals("Sunny", n1.GetName());
	}
	
	/**
	 * Test method for {@link Number#SetName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		Number n2 = new Number("Sunny",new AbsoluteDifference(), 32.0);
		n2.SetName("Adam");
		assertEquals("Adam", n2.GetName());
	}
	
	/**
	 * Test method for {@link Number#GetValue()}.
	 */
	@Test
	public void testGetValue() {
		Number n3 = new Number("Eric", new Difference(), 15.0);
		assertEquals(Double.valueOf(15), n3.GetValue());
	}
	
	/**
	 * Test method for {@link Number#SetValue(java.lang.Object)}.
	 */
	@Test
	public void testSetValue() {
		Number n4 = new Number("Sunny",new Difference(), 15.0);
		n4.SetValue(69.0);
		assertEquals(Double.valueOf(69), n4.GetValue());
	}

	@Test
	public void testToString() {
		Number n4 = new Number("Sunny",new Difference(), 15.0);
		Number n5 = new Number("Adam", new Euclidian(), null);
		assertEquals("15.0 (Sunny)", n4.toString());
		assertEquals("Adam (Number)(Euclidian)", n5.toString());
		//n5 asserts
	}
	
	/**
	 * Test method for {@link Number#getType()}.
	 */
	@Test
	public void testGetType() {
		Number n5 = new Number("Sunny", new Euclidian(), 15.0);
		assertEquals("Number", n5.getType());
	}

}
