package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.AbsoluteDifference;
import main.BooleanCompare;
import main.Cartesian;
import main.Difference;
import main.Euclidian;
import main.Number;

/**
 * @author MohammedSunny
 *
 */

public class CartesianTest {
	
	/**
	 * Test method for {@link Cartesian#SetMetric()}.
	 */
	
	@Test
	public void testSetMetric() {
		ArrayList<Number> list = new ArrayList<Number>();
		list.add(new Number(null, null,3.0));
		list.add(new Number(null, null,4.0));
		list.add(new Number(null, null,5.0));
		Cartesian c1 = new Cartesian("Sunny", new Euclidian(), list, list.size());
		Cartesian c2 = new Cartesian("Eric", new Difference(), list, list.size());
		Cartesian c3 = new Cartesian("Andrew", new AbsoluteDifference(), list, list.size());
		Cartesian c4 = new Cartesian("Adam", new BooleanCompare(), list, list.size());
		c1.SetMetric(new Difference());
		c2.SetMetric(new AbsoluteDifference());
		c3.SetMetric(new BooleanCompare());
		c4.SetMetric(new Euclidian());
		assertEquals((c1.GetMetric() instanceof Difference), true);
		assertEquals((c2.GetMetric() instanceof AbsoluteDifference), true);
		assertEquals((c3.GetMetric() instanceof BooleanCompare), true);
		assertEquals((c4.GetMetric() instanceof Euclidian), true);
	}
	
	/**
	 * Test method for {@link Cartesian#GetMetric()}.
	 */
	
	@Test
	public void testGetMetric() {
		ArrayList<Number> list = new ArrayList<Number>();
		list.add(new Number(null, null,3.0));
		list.add(new Number(null, null,4.0));
		list.add(new Number(null, null,5.0));
		Cartesian c1 = new Cartesian("Sunny", new Euclidian(), list, list.size());
		Cartesian c2 = new Cartesian("Eric", new Difference(), list.size());
		Cartesian c3 = new Cartesian("Andrew", new AbsoluteDifference(), list, list.size());
		Cartesian c4 = new Cartesian("Adam", new BooleanCompare(), list, list.size());
		assertEquals((c1.GetMetric() instanceof Euclidian), true);
		assertEquals((c2.GetMetric() instanceof Difference), true);
		assertEquals((c3.GetMetric() instanceof AbsoluteDifference), true);
		assertEquals((c4.GetMetric() instanceof BooleanCompare), true);
	}

	/**
	 * Test method for {@link Cartesian#GetName()}.
	 */
	
	@Test
	public void testGetName() {
		ArrayList<Number> list = new ArrayList<Number>();
		list.add(new Number(null, null,3.0));
		list.add(new Number(null, null,4.0));
		list.add(new Number(null, null,5.0));
		Cartesian c1 = new Cartesian("Sunny", new Euclidian(), list, list.size());
		Cartesian c2 = new Cartesian("Eric", new Difference(), list, list.size());
		assertEquals("Sunny", c1.GetName());
		assertEquals("Eric", c2.GetName());
	}

	/**
	 * Test method for {@link Cartesian#SetName()}.
	 */
	
	@Test
	public void testSetName() {
		ArrayList<Number> list = new ArrayList<Number>();
		list.add(new Number(null, null,3.0));
		list.add(new Number(null, null,4.0));
		list.add(new Number(null, null,5.0));
		Cartesian c3 = new Cartesian("Andrew", new BooleanCompare(), list, list.size());
		c3.SetName("Adam");
		assertEquals("Adam", c3.GetName());
	}
	
	/**
	 * Test method for {@link Cartesian#GetValue()}.
	 */
	@Test
	public void testGetValue() {
		ArrayList<Number> list = new ArrayList<Number>();
		list.add(new Number(null, null,3.0));
		list.add(new Number(null, null,4.0));
		list.add(new Number(null, null,5.0));
		ArrayList<Number> list2 = new ArrayList<Number>();
		list2.add(new Number(null, null,3.0));
		list2.add(new Number(null, null,4.0));
		list2.add(new Number(null, null,5.0));
		Cartesian c1 = new Cartesian("Sunny", new Euclidian(), list, list.size());
		Cartesian c2 = new Cartesian("Eric", new Difference(), list2, list2.size());
		for(int i = 0; i < list.size(); i++)
			if(c1.GetValue().get(i).GetValue() == c2.GetValue().get(i).GetValue()) {
				assertEquals(true,true);
			}else {
				assertEquals(false,false);
			}	
	}

	/**
	 * Test method for {@link Cartesian#SetValue()}.
	 */
	
	@Test
	public void testSetValue() {
		ArrayList<Number> list = new ArrayList<Number>();
		list.add(new Number(null, null,3.0));
		list.add(new Number(null, null,4.0));
		list.add(new Number(null, null,5.0));
		ArrayList<Number> list2 = new ArrayList<Number>();
		list.add(new Number(null, null,3.0));
		list.add(new Number(null, null,4.0));
		list.add(new Number(null, null,13.0));
		Cartesian c5 = new Cartesian("Adam", new BooleanCompare(), list2, list.size());
		c5.SetValue(list);
		assertEquals(list.equals(c5.GetValue()), true);
	}

	/**
	 * Test method for {@link Cartesian#ToString()}.
	 */
	
	@Test
	public void testToString() {
		ArrayList<Number> list = new ArrayList<Number>();
		list.add(new Number(null, null,3.0));
		list.add(new Number(null, null,4.0));
		list.add(new Number(null, null,5.0));
		ArrayList<Number> list2 = new ArrayList<Number>();
		list2.add(new Number(null, null, null));
		Cartesian c4 = new Cartesian("Andrew", new BooleanCompare(), list, list.size());
		assertEquals(("<3.0 (null), 4.0 (null), 5.0 (null)> (Andrew)"),c4.toString());
	}


	/**
	 * Test method for {@link Cartesian#GetType()}.
	 */
	
	@Test
	public void testGetType() {
		ArrayList<Number> list = new ArrayList<Number>();
		list.add(new Number(null, null,3.0));
		list.add(new Number(null, null,4.0));
		list.add(new Number(null, null,5.0));
		Cartesian c1 = new Cartesian("Sunny", new Euclidian(), list, list.size());
		Cartesian c2 = new Cartesian("Eric", new Difference(), list, list.size());
		Cartesian c3 = new Cartesian("Andrew", new AbsoluteDifference(), list, list.size());
		Cartesian c4 = new Cartesian("Adam", new BooleanCompare(), list, list.size());
		assertEquals("Cartesian", c1.getType());
		assertEquals("Cartesian", c2.getType());
		assertEquals("Cartesian", c3.getType());
		assertEquals("Cartesian", c4.getType());
	}
	
}

