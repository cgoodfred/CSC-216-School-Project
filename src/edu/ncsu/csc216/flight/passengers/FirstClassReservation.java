/**
 * 
 */
package edu.ncsu.csc216.flight.passengers;

import edu.ncsu.csc216.flight.plane.Flight;

/**
 * Class for a first class reservation
 * @author corey
 */
public class FirstClassReservation extends FlightReservation {
	
	/**
	 * Constructor for first class reservation
	 * @param s the seat to reserve
	 * @param f1 the flight the passenger is on
	 * @param b window preference
	 */
	public FirstClassReservation(String s, Flight f1, boolean b) {
		super(s, f1, b);
		// TODO Auto-generated constructor stub
	}

	/**
	 * finds the seat of the passenger
	 */
	@Override
	public void findSeat() {
		mySeat = this.getVehicle().reserveFirstClassSeat(this.wantsWindowSeat());
		if(mySeat == null){
			mySeat = this.getVehicle().reserveBusinessSeat(this.wantsWindowSeat());
		}
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
		return "First Class  " + super.stringForPrint();
	}

}
