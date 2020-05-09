/**
 * 
 */
package edu.ncsu.csc216.flight.passengers;

import edu.ncsu.csc216.flight.plane.Flight;

/**
 * creates a reservation for the flight
 * @author corey
 */
public abstract class FlightReservation {
	
	/** holds seat information */
	protected String mySeat;
	/** holds passenger name */
	private String name;
	/** holds whether or not the passenger wants a window */
	private boolean prefersWindow;
	/** holds the flight */
	private Flight myAirplane;
	
	/**
	 * Constructor for flight reservation
	 * @param s the name of the passenger
	 * @param f1 the flight the reservation is for
	 * @param b whether its a window or not
	 */
	public FlightReservation(String s, Flight f1, boolean b){
		name = s;
		if(name != null){
			name = name.trim();
		}
		prefersWindow = b;
		myAirplane = f1;
	}
	
	/**
	 * Returns the name of the passenger
	 * @return name of passenger
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Returns seat the passenger wants
	 * @return seat the passenger wants
	 */
	public String getSeat(){
		return mySeat;
	}
	
	/**
	 * Returns the flight the reservation is for
	 * @return the flight
	 */
	public Flight getVehicle(){
		return myAirplane;
	}
	
	/**
	 * Returns true if the passenger wants a window
	 * @return window or not
	 */
	public boolean wantsWindowSeat(){
		return prefersWindow;
	}
	
	/**
	 * The findSeat method to be implemented by the subclasses
	 */
	public abstract void findSeat();
	
	/**
	 * Returns the string for printing
	 * @return string for printing
	 */
	public String stringForPrint(){
		String label = "";
		if(mySeat == null){
			label = "none";
		} else {
			label = mySeat;
			if(label.length() == 2){
				label = "  " + mySeat;
			}
			else if(label.length() == 3){
				label = " " + mySeat;
			}
		}
		return label + "  " + name;
	}
	
	/**
	 * Returns flight number
	 * @param r the reservation
	 * @return flight number
	 */
	public int compareTo(FlightReservation r){
		return r.getName().toLowerCase().compareTo(name.toLowerCase());
	}
	
	/**
	 * cancels the reservation
	 */
	public void cancelReservation(){
		myAirplane.releaseSeat(mySeat);
		mySeat = null;
	}
	
	
}
