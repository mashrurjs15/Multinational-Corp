import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CartesianTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetName() {
		Cartesian c1 = new Cartesian("Sunny", new ArrayList<Double> (5));
		Cartesian c2 = new Cartesian("Eric", new ArrayList<Double> (4));
		assertEquals("Sunny", c1.GetName());
		
	}

	@Test
	public void testSetName() {
		Cartesian c3 = new Cartesian("Sunny", new ArrayList<Double> (5));
		c3.SetName("Adam");
		assertEquals("Adam", c3.GetName());
	}

	@Test
	public void testGetValue() {
		Cartesian c4 = new Cartesian("Sunny", new ArrayList<Double> (10));
		assertEquals(10, c4.GetValue());
	}

	@Test
	public void testSetValue() {
		Cartesian c5 = new Cartesian("Adam", new ArrayList<Double> (10));
		c5.SetValue(13);
		assertEquals(13, c4.GetValue());
	}

	@Test
	public void testGetType() {
		Cartesian c6 = new Cartesian("Adam", new ArrayList<Double> (25));
		assertEquals("Cartesian", c6.getType());
	}

}
