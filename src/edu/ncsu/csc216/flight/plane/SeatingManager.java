package edu.ncsu.csc216.flight.plane;

/**
 * Behaviors required for an entity that manages seating reservations (for flight, <br/>
 * theater, etc). Seats are classified as First Class, Business, or Economy, and each <br/>
 * has a unique label.
 * 
 * @author Jo Perry
 * @version 1.0
 */
public interface SeatingManager {
	/**
	 * Types of possible reservations.
	 */
	String[] RESERVATION_TYPES = {"First Class", "Business Class", "Coach"};
	
	/**
	 * Reserve a seat for a business class reservation, applying the seat<br/>
	 *    preference if possible. The chosen seat is marked occupied.
	 * @param prefersWindow indicates seating preference
	 * @return the reserved seat or null if no such seat is available
	 */
	public String reserveBusinessSeat(boolean prefersWindow);
	
	/**
	 * Reserve a seat for a first class reservation, applying the seat<br/>
	 *    preference if possible. The chosen seat is marked occupied.
	 * @param prefersWindow indicates seating preference
	 * @return the reserved seat or null if no such seat is available
	 */
	public String reserveFirstClassSeat(boolean prefersWindow);
	
	/**
	 * Reserve a seat for an economy class reservation, applying the seat<br/> 
	 *   preference if possible. The chosen seat is marked occupied.
	 * @param prefersWindow indicates seating preference
	 * @return the reserved seat or null if no such seat is available
	 */
	public String reserveEconomySeat(boolean prefersWindow);
	
	/**
	 * Get a seat map, where a seat in position [row, col] is represented by <br/>
	 *    its row and seat label or by null if there is no seat at the position. <br/>
	 * @return the seat map showing seat labels
	 */
	public String[][] getSeatMap();
	
	/**
	 * Get a map showing which seats are occupied. <br/>
	 *   A map element is true if its [row, col] correspond to an occupied seat <br/>
	 *   or false if the seat is not occupied or if there is no seat at that position.
	 * @return the seat map showing which seats are occupied
	 */
	public boolean[][] getSeatOccupationMap(); 
}