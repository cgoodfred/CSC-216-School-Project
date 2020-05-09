/**
 * 
 */
package edu.ncsu.csc216.flight.passengers;

import edu.ncsu.csc216.flight.plane.Flight;

/**
 * class for an economy reservation
 * @author corey
 */
public class EconomyReservation extends FlightReservation {
	
	/**
	 * Constructor for economy reservation
	 * @param s the seat to reserve
	 * @param f1 the flight the passenger is on
	 * @param b window preference
	 */
	public EconomyReservation(String s, Flight f1, boolean b) {
		super(s, f1, b);
	}

	/**
	 * finds the seat of the passenger
	 */
	@Override
	public void findSeat() {
		if(!this.getVehicle().coachAtCap()){
			mySeat = this.getVehicle().reserveEconomySeat(this.wantsWindowSeat());
		}
	}

	/**
	 * returns the seat reservation in the form of a string
	 * @return seat information
	 */
	@Override
	public String stringForPrint(){
		return "Coach        " + super.stringForPrint();
	}
}
