/**
 * 
 */
package edu.ncsu.csc216.flight.plane;

/**
 * The seat class which holds data for individual seats on the plane
 * @author corey
 * 
 */
public class Seat {

	/** holds seat information */
	private String location;
	/** holds seat occupancy */
	private boolean occupied;
	/** holds whether its a window or not */
	private boolean windowSeat;
	/** holds whether its an aisle or not */
	private boolean aisleSeat;
	
	/**
	 * Constructor for seat
	 * @param s the location of the seat
	 * @param b1 whether its a window or not
	 * @param b2 whether its an aisle or not
	 */
	public Seat(String s, boolean b1, boolean b2) {
		occupied = false;
		location = s.trim();
		windowSeat = b1;
		aisleSeat  = b2;
	}
	
	/**
	 * Returns true if the seat is occupied
	 * @return occupied or not
	 */
	public boolean isOccupied(){
		return occupied;
	}
	
	/**
	 * Returns true if the seat is a window seat
	 * @return window or not
	 */
	public boolean isWindowSeat(){
		return windowSeat;
	}
	
	/**
	 * Returns true if the seat is an aisle
	 * @return aisle or not
	 */
	public boolean isAisleSeat(){
		return aisleSeat;
	}
	
	/**
	 * Sets the seat to occupied
	 */
	public void occupy(){
		occupied = true;
	}
	
	/**
	 * Sets the seat to empty
	 */
	public void release(){
		occupied = false;
	}
	
	/**
	 * Returns the location of the seat as a string
	 * @return location
	 */
	public String getLocation(){
		return location;
	}

}
