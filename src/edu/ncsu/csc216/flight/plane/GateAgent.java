/**
 * 
 */
package edu.ncsu.csc216.flight.plane;

import java.io.FileNotFoundException;

import edu.ncsu.csc216.flight.passengers.BusinessClassReservation;
import edu.ncsu.csc216.flight.passengers.EconomyReservation;
import edu.ncsu.csc216.flight.passengers.FirstClassReservation;
import edu.ncsu.csc216.flight.passengers.FlightReservation;
import edu.ncsu.csc216.flight.passengers.PassengerList;

/**
 * The class for the Gate Agent
 * @author corey
 *
 */
public class GateAgent {
	
	
	
	private SeatingManager plane;
	
	private PassengerList manifest;

	/**
	 * Constructor for GateAgent
	 * @param s filename of empty seating chart
	 * @throws FileNotFoundException 
	 */
	public GateAgent(String s) throws IllegalArgumentException{
		plane = new Flight(s);
		manifest = new PassengerList();
	}

	/**
	 * Removes the passenger from the list
	 * @param i the passenger to be removed
	 */
	public void removePassenger(int i){
		manifest.removePassenger(i);
	}
	
	/**
	 * Adds the passenger to the list
	 * @param i the index of passenger to be added
	 * @param s the string of information
	 * @param b window or not
	 */
	public void addPassenger(int i, String s, boolean b){
		if(s == null || s.trim().equals("")){
			throw new IllegalArgumentException();
		}
		FlightReservation res = null;
		if(i == 0){
			res = new FirstClassReservation(s, (Flight)plane, b);
		}
		else if(i == 1){
			res = new BusinessClassReservation(s, (Flight)plane, b);
		}
		else {
			res = new EconomyReservation(s, (Flight)plane, b);
		}
		res.findSeat();
		manifest.add(res);
	}
	
	/**
	 * Returns the seat map of the plane
	 * @return seat map of plane
	 */
	public String[][] getSeatMap(){
		return plane.getSeatMap();
	}
	
	/**
	 * Returns seat map that tells if occupied or not
	 * @return seat map of occupancy
	 */
	public boolean[][] getSeatOccupationMap(){
		return plane.getSeatOccupationMap();
	}
	
	/**
	 * Returns the list of reservations
	 * @return reservations
	 */
	public String printReservations(){
		return manifest.report();
	}
}
