/**
 * 
 */
package edu.ncsu.csc216.flight.passengers;

import edu.ncsu.csc216.flight.plane.Flight;

/**
 * The class for the business seat
 * @author corey
 */
public class BusinessClassReservation extends FlightReservation {
	
	/**
	 * Constructs a business class reservation
	 * @param s the seat to reserve
	 * @param f1 the flight they are on
	 * @param b window preferred or not
	 */
	public BusinessClassReservation(String s, Flight f1, boolean b) {
		super(s, f1, b);
	}

	/**
	 * finds the seat of the passenger
	 */
	@Override
	public void findSeat() {
		mySeat = this.getVehicle().reserveBusinessSeat(this.wantsWindowSeat());
		if(mySeat == null){
			mySeat = this.getVehicle().reserveEconomySeat(this.wantsWindowSeat());
		}

	}
	
	/**
	 * returns the seat reservation in the form of a string
	 * @return seat information
	 */
	@Override
	public String stringForPrint(){
		return "Business     " + super.stringForPrint();
	}
}
