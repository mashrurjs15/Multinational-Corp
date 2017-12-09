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
public class EuclidianTest {

	/**
	 * Test method for {@link Euclidian#GetDistance()}.
	 */
	@Test
	public void testGetDistance() {
		Euclidian euc = new Euclidian();
		ArrayList<Number> list = new ArrayList<Number>();
		ArrayList<Number> list2 = new ArrayList<Number>();
		ArrayList<Number> list3 = new ArrayList<Number>();
		ArrayList<Number> list4 = new ArrayList<Number>();
		list.add(new Number(null, null,3.0));
		list.add(new Number(null, null,4.0));
		list2.add(new Number(null, null,7.0));
		list2.add(new Number(null, null,4.0));
		list3.add(new Number(null, null,-7.0));
		list3.add(new Number(null, null,11.0));
		list4.add(new Number(null, null,5.0));
		list4.add(new Number(null, null,6.0));
		Cartesian c1 = new Cartesian("Sunny", new Euclidian(), list, list.size());
		Cartesian c2 = new Cartesian("Eric", new Difference(), list2, list2.size());
		Cartesian c3 = new Cartesian("Eric", new Difference(), list3, list3.size());
		Cartesian c4 = new Cartesian("Eric", new Difference(), list4, list4.size());
		assertEquals(euc.getDistance(c1, c2),4,0);
		assertEquals(euc.getDistance(c3, c4),13,0);
	}

	/**
	 * Test method for {@link Euclidian#GetName()}.
	 */
	@Test
	public void testGetName() {
		AbsoluteDifference absdif = new AbsoluteDifference();
		assertEquals("AbsoluteDifference", absdif.getName());
	}
}
