import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DifferenceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDistance() {
		Difference differ = new Difference();
		Number N1 = new Number("Sunny", 22.0);
		Number N2 = new Number("Eric", 13.0);
		Number N3 = new Number("Adam", 18.0);
		Number N4 = new Number("Andrew", 23.0);
		assertEquals(differ.getDistance(N1, N2), 9.0, 0);
		assertEquals(differ.getDistance(N3, N4), -5.0, 0);
	}

}
