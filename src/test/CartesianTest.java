package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.AbsoluteDifference;
import main.BooleanCompare;
import main.Cartesian;
import main.Difference;
import main.Euclidian;


public class CartesianTest {

	/**
	 * Test method for {@link Cartesian#SetMetric()}.
	 */
	@Test
	public void testSetMetric() {
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(3.0);
		list.add(4.0);
		list.add(5.0);
		Cartesian c1 = new Cartesian("Sunny", new Euclidian(), list);
		Cartesian c2 = new Cartesian("Eric", new Difference(), list);
		Cartesian c3 = new Cartesian("Andrew", new AbsoluteDifference(), list);
		Cartesian c4 = new Cartesian("Adam", new BooleanCompare(), list);
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
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(3.0);
		list.add(4.0);
		list.add(5.0);
		Cartesian c1 = new Cartesian("Sunny", new Euclidian(), list);
		Cartesian c2 = new Cartesian("Eric", new Difference(), list);
		Cartesian c3 = new Cartesian("Andrew", new AbsoluteDifference(), list);
		Cartesian c4 = new Cartesian("Adam", new BooleanCompare(), list);
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
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(3.0);
		list.add(4.0);
		list.add(5.0);
		Cartesian c1 = new Cartesian("Sunny", new Euclidian(), list);
		Cartesian c2 = new Cartesian("Eric", new Difference(), list);
		assertEquals("Sunny", c1.GetName());
		assertEquals("Eric", c2.GetName());
	}

	/**
	 * Test method for {@link Cartesian#SetName()}.
	 */
	@Test
	public void testSetName() {
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(3.0);
		list.add(4.0);
		list.add(5.0);
		Cartesian c3 = new Cartesian("Andrew", new BooleanCompare(), list);
		c3.SetName("Adam");
		assertEquals("Adam", c3.GetName());
	}
	
	/*
	 * Test method for {@link Cartesian#GetValue()}.
	 */
	@Test
	public void testGetValue() {
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(3.0);
		list.add(4.0);
		list.add(5.0);
		ArrayList<Double> list2 = new ArrayList<Double>();
		list2.add(3.0);
		list2.add(4.0);
		list2.add(5.0);
		Cartesian c4 = new Cartesian("Sunny", new Difference(), list2);
		assertEquals(list.equals(c4.GetValue()), true);
	}

	/**
	 * Test method for {@link Cartesian#SetValue()}.
	 */
	@Test
	public void testSetValue() {
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(3.0);
		list.add(4.0);
		list.add(5.0);
		ArrayList<Double> list2 = new ArrayList<Double>();
		list2.add(3.0);
		list2.add(4.0);
		list2.add(13.0);
		Cartesian c5 = new Cartesian("Adam", new BooleanCompare(), list2);
		c5.SetValue(list);
		assertEquals(list.equals(c5.GetValue()), true);
	}

	/**
	 * Test method for {@link Cartesian#ToString()}.
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}


	/**
	 * Test method for {@link Cartesian#GetType()}.
	 */
	@Test
	public void testGetType() {
		ArrayList<Double> list = new ArrayList<Double>();
		list.add(3.0);
		list.add(4.0);
		list.add(5.0);
		Cartesian c1 = new Cartesian("Sunny", new Euclidian(), list);
		Cartesian c2 = new Cartesian("Eric", new Difference(), list);
		Cartesian c3 = new Cartesian("Andrew", new AbsoluteDifference(), list);
		Cartesian c4 = new Cartesian("Adam", new BooleanCompare(), list);
		assertEquals("Cartesian", c1.getType());
		assertEquals("Cartesian", c2.getType());
		assertEquals("Cartesian", c3.getType());
		assertEquals("Cartesian", c4.getType());
	}
}
