/**
 * 
 */
package edu.ncsu.csc216.flight.plane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * The flight that reservations will be made for
 * @author corey
 *
 */
public class Flight implements SeatingManager {

	private static final int COACH_CAP = 80;

	private Seat[][] map;

	private String seatLabels;

	private int numRows;

	private int numColumns;

	private int startFirstClass;

	private int startBusiness;

	private int startEconomy;

	private int mostRecentEconomyRow;

	private int economySeatsReserved;

	private int economyCapacity;

	/**
	 * Constructor for the flight
	 * @param s string of the filename 
	 * @throws FileNotFoundException 
	 */
	public Flight(String s) throws IllegalArgumentException{
		try(FileInputStream io = new FileInputStream(s)){
			try(Scanner fs = new Scanner(io)){
				numRows = fs.nextInt();
				seatLabels = fs.next();
				int numAisles = fs.nextInt();
				numColumns = seatLabels.length() + numAisles;
				startFirstClass = fs.nextInt();
				startBusiness = fs.nextInt();
				startEconomy = fs.nextInt();
				map = new Seat[numRows][numColumns];
				fs.nextLine();
				int row = 0;
				while(fs.hasNextLine()){
					String plane = fs.nextLine();
					map[row] = planeSeats(plane.trim().split("\\s+"));
					row++;
				}
			} catch(NoSuchElementException e) {
				throw new IllegalArgumentException();
			}			
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException();	
		} catch (IOException e) {
			throw new IllegalArgumentException();
		}
		economyCapacity = 0;
		int[] r = seatRange(startEconomy);
		for(int i = r[0]; i <= r[1]; i++){
			for(int j = 0; j < map[i].length; j++){
				if(map[i][j] != null){
					this.economyCapacity++;
				}
			}
		}
		mostRecentEconomyRow = startEconomy;
		economySeatsReserved = 0;
		
	}

	private int currentRow(Seat s){
		if(s == null){
			return -1;
		}
		return Integer.parseInt(s.getLocation().trim().split("[A-Za-z]")[0]);
	}
	
	private int[] seatRange(int start){
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				if(currentRow(map[i][j]) == start){
					return new int[] {i, map.length - 1};
				}
			}
		}
		return new int[] {-1, -1};
	}
	
	private int[] seatRange(int start, int end){
		int rStart = -1;
		int rEnd = -1;
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				if(currentRow(map[i][j]) == start){
					rStart = i;
				}
				if(rEnd == -1){
					if(currentRow(map[i][j]) == end){
						rEnd = i;
					}
					if(currentRow(map[i][j]) > end){
						rEnd = i - 1;
					}
				}
			}
		}
		return new int[] {rStart, rEnd};
	}
	
	private Seat[] planeSeats(String[] str){
		Seat[] r = new Seat[str.length];
		for(int i = 0; i < str.length; i++){
			if(str[i].equals("XXX")){
				r[i] = null;
			}
			else{
				boolean window = false;
				boolean aisle = false;
				if(i == 0 || i == str.length - 1){
					window = true;
				}
				if(i < str.length - 1 && str[i + 1].equals("XXX")){
					aisle = true;
				}
				if(i != 0 && str[i - 1].equals("XXX")){
					aisle = true;
				}
				r[i] = new Seat(str[i], window, aisle);
			}
		}
		return r;
	}
	
	private Seat findSeat(int[] range, boolean window){
		for(int i = range[0]; i <= range[1]; i++){
			for(int j = 0; j < map[i].length; j++){
				if(map[i][j] != null && !map[i][j].isOccupied()){
					if((map[i][j].isAisleSeat() && !window) || (map[i][j].isWindowSeat() && window)){
						return map[i][j];
					}
				}
			}
		}
		for(int i = range[0]; i <= range[1]; i++){
			for(int j = 0; j < map[i].length; j++){
				if(map[i][j] != null && !map[i][j].isOccupied()){
					return map[i][j];
				}
			}
		}
		return null;
	}
	
	/**
	 * Returns a string of the business seat reserved
	 * @param prefersWindow
	 * @return the string of the seat information
	 */
	@Override
	public String reserveBusinessSeat(boolean prefersWindow) {
		Seat s = findSeat(seatRange(startBusiness, startEconomy - 1), prefersWindow);
		if(s != null){
			s.occupy();
			return s.getLocation();
		}
		return null;
	}

	/**
	 * Returns a string of the first class seat reserved
	 * @param prefersWindow
	 * @return the string of the seat information
	 */
	@Override
	public String reserveFirstClassSeat(boolean prefersWindow) {
		Seat s = findSeat(seatRange(startFirstClass, startBusiness - 1), prefersWindow);
		if(s != null){
			s.occupy();
			return s.getLocation();
		}
		return null;
	}

	/**
	 * Returns a string of the economt seat reserved
	 * @param prefersWindow
	 * @return the string of the seat information
	 */
	@Override
	public String reserveEconomySeat(boolean prefersWindow) {
		Seat s;
		Seat seat1 = findSeat(seatRange(startEconomy), prefersWindow);
		Seat seat2 = findSeat(seatRange(mostRecentEconomyRow), prefersWindow);
		if(seat2 == null){
			s = seat1;
		}
		else{
			if((seat2.isWindowSeat() && prefersWindow) || (seat2.isAisleSeat() && !prefersWindow)){
				s = seat2;
			} 
			else if((seat1.isWindowSeat() && prefersWindow) || (seat1.isAisleSeat() && !prefersWindow)){
				s = seat1;
			}
			else{
				s = seat2;
			}
		}
		if(s != null){
			economySeatsReserved++;
			mostRecentEconomyRow = currentRow(s);
			s.occupy();
			return s.getLocation();
		}
		return null;
	}

	/**
	 * returns the seat map for the flight
	 * @return the seat map of the flight
	 */
	@Override
	public String[][] getSeatMap() {
		String[][] locations = new String[numRows][numColumns];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				if(map[i][j] == null){
					locations[i][j] = null;
				}
				else {
					locations[i][j] = map[i][j].getLocation();
				}
			}
		}
		return locations;
	}

	/**
	 * returns the occupation map of the seats on the flight
	 * @return the map of occupancy
	 */
	@Override
	public boolean[][] getSeatOccupationMap() {
		boolean[][] locations = new boolean[numRows][numColumns];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				if(map[i][j] == null){
					locations[i][j] = false;
				}
				else {
					locations[i][j] = map[i][j].isOccupied();
				}
			}
		}
		return locations;
	}

	/**
	 * returns true if coach is at capacity
	 * @return true if at capacity
	 */
	public boolean coachAtCap(){
		return (double)economySeatsReserved / (double)economyCapacity >= (double)COACH_CAP / 100.0;
	}

	/**
	 * empties a reservation
	 * @param s the seat to be emptied
	 */
	public void releaseSeat(String s){
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				if(currentRow(map[i][j]) >= startEconomy){
					economySeatsReserved--;
				}
				if(map[i][j] != null && map[i][j].getLocation().equals(s))
					map[i][j].release();
			}
		}
	}

}
