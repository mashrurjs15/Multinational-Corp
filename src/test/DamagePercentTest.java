/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.AbsoluteDifference;
import main.DamagePercent;
import main.Difference;


/**
 * @author MohammedSunny
 *
 */

public class DamagePercentTest {

	/**
	 * Test method for {@link main.DamagePercent#GetName()}.
	 */
	@Test
	public void testGetName() {
		DamagePercent d = new DamagePercent("Andrew",new Difference());
		DamagePercent d1 = new DamagePercent("Sunny", new AbsoluteDifference(), 2);
		assertEquals("Andrew", d.GetName());
		assertEquals("Sunny", d1.GetName());
	}

	/**
	 * Test method for {@link main.DamagePercent#SetName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		DamagePercent d2 = new DamagePercent("Sunny",new Difference());
		DamagePercent d3 = new DamagePercent("Eric",new AbsoluteDifference(),5);
		d2.SetName("ADAM");
		d3.SetName("Andrew");
		assertEquals("ADAM", d2.GetName());
		assertEquals("Andrew",d3.GetName());
	}

	/**
	 * Test method for {@link main.DamagePercent#GetValue()}.
	 */
	@Test
	public void testGetValue() {
		DamagePercent d1 = new DamagePercent("Andrew",new Difference());
		DamagePercent d2 = new DamagePercent("Sunny", new AbsoluteDifference(), 2);
		assertEquals(0,d1.GetValue());
		assertEquals(2,d2.GetValue());
	}

	/**
	 * Test method for {@link main.DamagePercent#SetValue(java.lang.Object)}.
	 */
	@Test
	public void testSetValue() {
		DamagePercent d1 = new DamagePercent("Kent",new Difference());
		DamagePercent d2 = new DamagePercent("Eric", new AbsoluteDifference(), 2);
		d1.SetValue(3);
		d2.SetValue(6);
		assertEquals(3,d1.GetValue());
		assertEquals(6,d2.GetValue());
	}

	/**
	 * Test method for {@link main.DamagePercent#SetMetric(main.Metric)}.
	 */
	@Test
	public void testSetMetric() {
		DamagePercent d1 = new DamagePercent("Kent",new Difference());
		DamagePercent d2 = new DamagePercent("Eric", new AbsoluteDifference(), 2);
		d1.SetMetric(new AbsoluteDifference());
		d2.SetMetric(new Difference());
		assertEquals(d1.GetMetric() instanceof AbsoluteDifference, true);
		assertEquals(d2.GetMetric() instanceof Difference, true);
	}

	/**
	 * Test method for {@link main.DamagePercent#GetMetric()}.
	 */
	@Test
	public void testGetMetric() {
		DamagePercent d1 = new DamagePercent("Kent",new AbsoluteDifference());
		DamagePercent d2 = new DamagePercent("Eric", new Difference(), 6);
		assertEquals(d1.GetMetric() instanceof AbsoluteDifference, true);
		assertEquals(d2.GetMetric() instanceof Difference, true);
	}

	/**
	 * Test method for {@link main.DamagePercent#getType()}.
	 */
	@Test
	public void testGetType() {
		DamagePercent d1 = new DamagePercent("Kent",new AbsoluteDifference());
		DamagePercent d2 = new DamagePercent("Eric", new Difference(), 6);
		assertEquals("DamagePercent", d1.getType());
		assertEquals("DamagePercent", d2.getType());
	}

	/**
	 * Test method for {@link main.DamagePercent#toString()}.
	 */
	@Test
	public void testToString() {
		DamagePercent d1 = new DamagePercent("Kent",new AbsoluteDifference());
		DamagePercent d2 = new DamagePercent("Eric", new Difference(), 6);
		assertEquals("Kent (Damage%)(AbsoluteDifference)",d1.toString());
		assertEquals("6% (Eric)",d2.toString());
	}

}
