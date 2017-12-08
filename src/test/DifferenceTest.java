package test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.AbsoluteDifference;
import main.BooleanCompare;
import main.Difference;
import main.Euclidian;
import main.Number;

public class DifferenceTest {

	@Before
	public void setUp() throws Exception {
	}
	
	/**
	 * Test method for {@link Differencer#GetDistance()}.
	 */
	@Test
	public void testGetDistance() {
		Difference differ = new Difference();
		Number N1 = new Number("Sunny", new Euclidian(), 22.0);
		Number N2 = new Number("Eric", new Difference(), 13.0);
		Number N3 = new Number("Adam", new BooleanCompare(), 18.0);
		Number N4 = new Number("Andrew", new AbsoluteDifference(), 23.0);
		assertEquals(differ.getDistance(N1, N2), 9.0, 0);
		assertEquals(differ.getDistance(N3, N4), -5.0, 0);
	}
}
