import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbsoluteDifferenceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDistance() {
		AbsoluteDifference absdiffer = new AbsoluteDifference();
		Number N1 = new Number("Sunny", 22.0);
		Number N2 = new Number("Eric", 13.0);
		Number N3 = new Number("Adam", 18.0);
		Number N4 = new Number("Andrew", 23.0);
		assertEquals(absdiffer.getDistance(N1,N3),4,0);
		assertEquals(absdiffer.getDistance(N2,N4),10,0);
	}

}
