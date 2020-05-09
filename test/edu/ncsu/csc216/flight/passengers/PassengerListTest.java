/**
 * 
 */
package edu.ncsu.csc216.flight.passengers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.flight.plane.Flight;

/**
 * test class for passenger list
 * @author corey
 *
 */
public class PassengerListTest {

	
	PassengerList list;
	Flight f1;
	/**
	 * sets up the tests
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list = new PassengerList();
		f1 = new Flight("test-files/tiny-plane.txt");
	}

	/**
	 * tests my passengerlist class
	 */
	@Test
	public void test() {
		FirstClassReservation fr = new FirstClassReservation("Jim", f1, true);
		FirstClassReservation fr1 = new FirstClassReservation("Jim", f1, true);
		FirstClassReservation fr2 = new FirstClassReservation("Jim", f1, true);
		FirstClassReservation fr3 = new FirstClassReservation("Jim", f1, true);
		FirstClassReservation fr4 = new FirstClassReservation("Jim", f1, true);
		FirstClassReservation fr5 = new FirstClassReservation("Jim", f1, true);
		FirstClassReservation fr6 = new FirstClassReservation("Jim", f1, true);
		FirstClassReservation fr7 = new FirstClassReservation("Jim", f1, true);
		FirstClassReservation fr8 = new FirstClassReservation("Jim", f1, true);
		FirstClassReservation fr9 = new FirstClassReservation("Jim", f1, true);
		FirstClassReservation fr10 = new FirstClassReservation("Jim", f1, true);
		FirstClassReservation fr11 = new FirstClassReservation("Jim", f1, true);
		FirstClassReservation fr12 = new FirstClassReservation("Jim", f1, true);
		BusinessClassReservation br1 = new BusinessClassReservation("John", f1, true);
		
		EconomyReservation er = new EconomyReservation("Jim", f1, true);
		fr.stringForPrint();
		list.add(fr);
		list.add(br1);
		list.add(er);
		list.add(fr1);
		list.add(fr2);
		list.add(fr3);
		list.add(fr4);
		list.add(fr5);
		list.add(fr6);
		list.add(fr7);
		list.add(fr8);
		list.add(fr9);
		list.add(fr10);
		list.add(fr11);
		list.add(fr12);
		list.report();
		fr.getSeat();
		fr.compareTo(fr);
		assertTrue(fr.equals(fr));
		
	}

}
