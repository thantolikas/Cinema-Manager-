package logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a row of seats in a theater.
 * @author Thanasis Tolikas
 *
 */
public class Row  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int num;
	private int numOfSeats;
	private ArrayList<Seat> seats;
	
	public Row(int num, int numofseats) {
		this.num  = num;
		numOfSeats = numofseats;
		seats = new ArrayList<>();
		initSeats(numofseats);
	}
	
	private void initSeats(int snum) {
		for (int i=0;i<snum;i++) {
			Seat seat = new Seat(num,seats.size()+1,false);
			seats.add(seat);
		}
	}

	/**
	 * Returns the seats of the row.
	 * @return
	 */
	public ArrayList<Seat> getSeats() {
		return seats;
		
	}
	
	/**
	 * Adds a seat to the row.
	 * @param s
	 */
	public void addSeat(Seat s) {
		//method
		seats.add(s);
	}
	
	/**
	 * Returns a specific Seat depending on the parameter 'seat'. 
	 * @param at
	 * @return
	 */
	public Seat getSeatAt(int seat) {
		return seats.get(seat);
	}
	
	public int getNumOfRowAsInt() {
		return num;
	}
	
	public void setNumOfRow(int num) {
		this.num = num;
	}
	

	 public int getNumOfSeats() {
		return numOfSeats;
	}
	
	@Override
	public String toString() {
		return "Row " + num + "(" + seats.size() + " seats)";
	}
	
}

