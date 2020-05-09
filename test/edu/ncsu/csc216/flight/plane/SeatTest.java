/**
 * 
 */
package edu.ncsu.csc216.flight.plane;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the seat class
 * @author corey
 *
 */
public class SeatTest {

	/** the seat to be tested */
	private Seat s1;
	
	/**
	 * sets up the tests for the seat class
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		s1 = new Seat("A1", true, true);		
	}

	/**
	 * tests the seat class itself
	 */
	@Test
	public void testSeat() {
		assertFalse(s1.isOccupied());
		assertTrue(s1.isAisleSeat());
		assertTrue(s1.isWindowSeat());
		s1.occupy();
		assertTrue(s1.isOccupied());
		s1.release();
		assertFalse(s1.isOccupied());
		assertEquals("A1", s1.getLocation());
	}

}
