package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.AbsoluteDifference;
import main.Difference;
import main.Euclidian;
import main.Boolean;
import main.BooleanCompare;
public class BooleanCompareTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDistance() {
		
		BooleanCompare comp = new BooleanCompare();
		Boolean b1 = new Boolean("Sunny", new Difference(), "Nvidia");
		Boolean b2 = new Boolean("Eric", new Euclidian(), "Nvidia");
		Boolean b3 = new Boolean("Adam", new AbsoluteDifference(), "AMD");
		Boolean b4 = new Boolean("Andrew", new BooleanCompare(), "Nvidia");
		assertEquals(comp.getDistance(b1,b2), 0, 0);
		assertEquals(comp.getDistance(b3, b4), 0, 1);
	}
	
	public void testgetName() {
		BooleanCompare comp = new BooleanCompare();
		assertEquals("BooleanCompare", comp.getName());
	}
}
