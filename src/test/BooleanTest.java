package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.AbsoluteDifference;
import main.Boolean;
import main.BooleanCompare;
import main.Difference;
import main.Euclidian;


public class BooleanTest {
	
	/**
	 * Test method for {@link Boolean#SetMetric()}.
	 */
	@Test
	public void testSetMetric() {
		Boolean b1 = new Boolean("Eric", new Difference(), "Nvidia");
		Boolean b2 = new Boolean("Adam", new Euclidian(), "Nvidia");
		Boolean b3 = new Boolean("Sunny", new Difference(), "Nvidia");
		Boolean b4 = new Boolean("Andrew", new BooleanCompare(), "Nvidia");
		b1.SetMetric(new Difference());
		b2.SetMetric(new AbsoluteDifference());
		b3.SetMetric(new BooleanCompare());
		b4.SetMetric(new Euclidian());
		assertEquals((b1.GetMetric() instanceof Difference), true);
		assertEquals((b2.GetMetric() instanceof AbsoluteDifference), true);
		assertEquals((b3.GetMetric() instanceof BooleanCompare), true);
		assertEquals((b4.GetMetric() instanceof Euclidian), true);
	}

	/**
	 * Test method for {@link Boolean#GetMetric()}.
	 */
	@Test
	public void testGetMetric() {
		Boolean b6 = new Boolean("Eric", new Difference(), "AMD");
		Boolean b7 = new Boolean("Adam", new Euclidian(), "Nvidia");
		Boolean b8 = new Boolean("Andrew", new BooleanCompare(), "House");
		Boolean b9 = new Boolean("Sunny", new AbsoluteDifference(), "Life" );
		assertEquals((b6.GetMetric() instanceof Difference), true);
		assertEquals((b7.GetMetric() instanceof Euclidian), true);
		assertEquals((b8.GetMetric() instanceof BooleanCompare), true);
		assertEquals((b9.GetMetric() instanceof AbsoluteDifference), true);
	}

	/**
	 * Test method for {@link Boolean#GetName()}.
	 */
	@Test
	public void testGetName() {
		Boolean b6 = new Boolean("Eric", new Difference(), "AMD");
		Boolean b7 = new Boolean("Adam", new Euclidian(), "Nvidia");
		Boolean b8 = new Boolean("Andrew", new BooleanCompare(), "House");
		Boolean b9 = new Boolean("Sunny", new AbsoluteDifference(), "Life" );
		assertEquals("Eric", b6.GetName());
		assertEquals("Adam", b7.GetName());
		assertEquals("Andrew", b8.GetName());
		assertEquals("Sunny", b9.GetName());
	}

	/**
	 * Test method for {@link Boolean#SetName()}.
	 */
	@Test
	public void testSetName() {
		Boolean b6 = new Boolean("Eric", new Difference(), "AMD");
		Boolean b7 = new Boolean("Adam", new Euclidian(), "Nvidia");
		Boolean b8 = new Boolean("Andrew", new BooleanCompare(), "House");
		Boolean b9 = new Boolean("Sunny", new AbsoluteDifference(), "Life" );
		assertEquals("Eric", b6.GetName());
		assertEquals("Adam", b7.GetName());
		assertEquals("Andrew", b8.GetName());
		assertEquals("Sunny", b9.GetName());
	}

	/**
	 * Test method for {@link Boolean#GetValue()}.
	 */
	@Test
	public void testGetValue() {
		Boolean b6 = new Boolean("Eric", new Difference(), "AMD");
		Boolean b7 = new Boolean("Adam", new Euclidian(), "Nvidia");
		Boolean b8 = new Boolean("Andrew", new BooleanCompare(), "House");
		Boolean b9 = new Boolean("Sunny", new AbsoluteDifference(), "Life" );
		assertEquals("AMD", b6.GetValue());
		assertEquals("Nvidia", b7.GetValue());
		assertEquals("House", b8.GetValue());
		assertEquals("Life", b9.GetValue());
	}
	
	/**
	 * Test method for {@link Boolean#SetValue()}.
	 */
	@Test
	public void testSetValue() {
		Boolean b1 = new Boolean("Eric", new Difference(), "Nvidia");
		Boolean b2 = new Boolean("Adam", new Euclidian(), "Nvidia");
		Boolean b3 = new Boolean("Sunny", new Difference(), "Nvidia");
		Boolean b4 = new Boolean("Andrew", new BooleanCompare(), "Nvidia");
		b1.SetValue("House");
		b2.SetValue("AMD");
		b3.SetValue("True");
		b4.SetValue("Hoe");
		assertEquals("House", b1.GetValue());
		assertEquals("AMD", b2.GetValue());
		assertEquals("True", b3.GetValue());
		assertEquals("Hoe", b4.GetValue());
	}

	/**
	 * Test method for {@link Boolean#ToString()}.
	 */
	@Test
	public void testToString() {
		Boolean b6 = new Boolean("Eric", new Difference(), "AMD");
		Boolean b7 = new Boolean("Adam", new Euclidian(), null);
		assertEquals("AMD (Eric)", b6.toString());
		assertEquals("Adam (Boolean)(Euclidian)", b7.toString());
	}

	/**
	 * Test method for {@link Boolean#GetType()}.
	 */
	@Test
	public void testGetType() {
		Boolean b1 = new Boolean("Eric", new Difference(), "Nvidia");
		assertEquals("Boolean", b1.getType());
	}

}
