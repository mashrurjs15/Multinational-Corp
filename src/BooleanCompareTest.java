import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BooleanCompareTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDistance() {
		BooleanCompare comp = new BooleanCompare();
		Boolean b1 = new Boolean("Sunny","Nvidia");
		Boolean b2 = new Boolean("Eric","Nvidia");
		Boolean b3 = new Boolean("Adam", "AMD");
		Boolean b4 = new Boolean("Andrew", "Nvidia");
		assertEquals(comp.getDistance(b1,b2), 0, 0);
		assertEquals(comp.getDistance(b3, b4), 0,1);
	}

}
