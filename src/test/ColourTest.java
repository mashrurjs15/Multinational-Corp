
package test;

import static org.junit.Assert.*;

import org.junit.Test;
import main.Colour;
import main.Colour.COLOURS;
import main.Difference;
import main.AbsoluteDifference;

/**
 * @author MohammedSunny
 *
 */

public class ColourTest {

	/**
	 * Test method for {@link Colour#GetName()}.
	 */
	@Test
	public void testGetName() {
		Colour c = new Colour("Sunny",new Difference());
		Colour c1 = new Colour("Eric",new AbsoluteDifference(),COLOURS.ORANGE);
		assertEquals("Sunny", c.GetName());
		assertEquals("Eric",c1.GetName());
	}

	/**
	 * Test method for {@link Colour#SetName()}.
	 */
	@Test
	public void testSetName() {
		Colour c2 = new Colour("Sunny",new Difference());
		Colour c3 = new Colour("Eric",new AbsoluteDifference(),COLOURS.ORANGE);
		c2.SetName("ADAM");
		c3.SetName("Andrew");
		assertEquals("ADAM", c2.GetName());
		assertEquals("Andrew",c3.GetName());
	}
	
	/**
	 * Test method for {@link Colour#GetValue()}.
	 */
	@Test
	public void testGetValue() {
		Colour c = new Colour("Sunny",new Difference(),COLOURS.RED);
		Colour c1 = new Colour("Andrew",new Difference(),COLOURS.ORANGE);
		Colour c2 = new Colour("Eric",new Difference(),COLOURS.YELLOW);
		Colour c3 = new Colour("Adam",new AbsoluteDifference(),COLOURS.GREEN);
		Colour c4 = new Colour("Kent",new Difference(),COLOURS.BLUE);
		Colour c5 = new Colour("Duc",new AbsoluteDifference(),COLOURS.INDIGO);
		Colour c6 = new Colour("Ali",new Difference(),COLOURS.VIOLET);
		Colour c7 = new Colour("Babak",new AbsoluteDifference(),COLOURS.UNKNOWN);
		assertEquals(0, c.GetValue());
		assertEquals(1, c1.GetValue());
		assertEquals(2, c2.GetValue());
		assertEquals(3, c3.GetValue());
		assertEquals(4, c4.GetValue());
		assertEquals(5, c5.GetValue());
		assertEquals(6, c6.GetValue());
		assertEquals(7, c7.GetValue());
	}

	/**
	 * Test method for {@link Colour#SetValue()}.
	 */
	@Test
	public void testSetValue() {
		Colour c = new Colour("Sunny",new Difference(),COLOURS.RED);
		Colour c1 = new Colour("Andrew",new Difference(),COLOURS.ORANGE);
		Colour c2 = new Colour("Eric",new Difference(),COLOURS.YELLOW);
		Colour c3 = new Colour("Adam",new AbsoluteDifference(),COLOURS.GREEN);
		Colour c4 = new Colour("Kent",new Difference());
		c.SetValue(COLOURS.BLUE);
		c1.SetValue(COLOURS.GREEN);
		c2.SetValue(COLOURS.RED);
		c3.SetValue(COLOURS.ORANGE);
		c4.SetValue(COLOURS.UNKNOWN);
		assertEquals(4, c.GetValue());
		assertEquals(3, c1.GetValue());
		assertEquals(0, c2.GetValue());
		assertEquals(1, c3.GetValue());
		assertEquals(7, c4.GetValue());
	}

	/**
	 * Test method for {@link Colour#SetMetric()}.
	 */
	@Test
	public void testSetMetric() {
		Colour c = new Colour("Sunny",new Difference(),COLOURS.RED);
		Colour c1 = new Colour("Andrew",new Difference(),COLOURS.ORANGE);
		Colour c2 = new Colour("Eric",new Difference(),COLOURS.YELLOW);
		c.SetMetric(new AbsoluteDifference());
		c1.SetMetric(new AbsoluteDifference());
		c2.SetMetric(new Difference());
		assertEquals(c.GetMetric() instanceof AbsoluteDifference, true);
		assertEquals(c1.GetMetric() instanceof AbsoluteDifference, true);
		assertEquals(c2.GetMetric() instanceof Difference, true);
	}

	/**
	 * Test method for {@link Colour#GetMetric()}.
	 */
	@Test
	public void testGetMetric() {
		Colour c5 = new Colour("Duc",new AbsoluteDifference(),COLOURS.INDIGO);
		Colour c6 = new Colour("Ali",new Difference(),COLOURS.VIOLET);
		Colour c7 = new Colour("Babak",new AbsoluteDifference(),COLOURS.UNKNOWN);
		assertEquals(c5.GetMetric() instanceof AbsoluteDifference, true);
		assertEquals(c6.GetMetric() instanceof Difference, true);
		assertEquals(c7.GetMetric() instanceof AbsoluteDifference, true);
	}

	/**
	 * Test method for {@link Colour#GetType()}.
	 */
	@Test
	public void testGetType() {
		Colour c6 = new Colour("Ali",new Difference(),COLOURS.VIOLET);
		assertEquals("Colour", c6.getType());
	}

	/**
	 * Test method for {@link Colour#ToString()}.
	 */
	@Test
	public void testToString() {
		Colour c2 = new Colour("Sunny",new Difference());
		Colour c3 = new Colour("Eric",new AbsoluteDifference(),COLOURS.ORANGE);
		assertEquals("Sunny (Colour)(Difference)",c2.toString());
		assertEquals("ORANGE (Eric)",c3.toString());
	}

}
