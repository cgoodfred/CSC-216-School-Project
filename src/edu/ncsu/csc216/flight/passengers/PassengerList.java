/**
 * 
 */
package edu.ncsu.csc216.flight.passengers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * creates the list of passengers on the plane
 * @author corey
 */
public class PassengerList {

	/** the list created for the reservations */
	private ArrayList<FlightReservation> list;
	
	/**
	 * constructs the passenger list
	 */
	public PassengerList() {
		list = new ArrayList<FlightReservation>();
	}
	
	/**
	 * adds the reservation to the flight
	 * @param f the flight reservation to add to the list
	 */
	public void add(FlightReservation f){
		if(f == null || f.getName() == null || f.getName().trim().equals("")){
			throw new IllegalArgumentException();
		}
		list.add(f);
		Collections.sort(list, new Comparator<FlightReservation>() {
			public int compare(FlightReservation f1, FlightReservation f2){
				return f1.getName().toLowerCase().compareTo(f2.getName().toLowerCase());
			}
		});
	}
	
	/**
	 * removes the passenger from the flight
	 * @param i the passenger
	 */
	public void removePassenger(int i){
		try{
			list.get(i).cancelReservation();
			list.remove(i);
		} catch(IndexOutOfBoundsException e){
			throw new IllegalArgumentException();
		} catch(NullPointerException e){
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * returns the report
	 * @return report in string form
	 */
	public String report(){
		String reported = "";
		for(FlightReservation p : list){
			reported += p.stringForPrint() + "\n";
		}
		return reported;
	}

}
