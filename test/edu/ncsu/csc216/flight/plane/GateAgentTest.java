/**
 * 
 */
package edu.ncsu.csc216.flight.plane;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * test class for the gate agent
 * @author corey
 *
 */
public class GateAgentTest {

	
	private final String validTestFile = "test-files/tiny-plane.txt";
	private GateAgent g;
	
	/**
	 * sets up the gate agent tests
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		g = new GateAgent(validTestFile);
	}

	/**
	 * Tests the gate agent
	 */
	@Test
	public void testGateAgent() {
		assertEquals("", g.printReservations());
		g.addPassenger(0, "1A", true);
		g.addPassenger(1, "2A", true);
		g.addPassenger(2, "15A", true);
		g.getSeatMap();
		g.getSeatOccupationMap();
		g.removePassenger(1);		
	}

}
