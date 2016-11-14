package logic;

import java.io.Serializable;

/**
 * Represents a seat in a theater.
 * @author Thanasis Tolikas
 *
 */
public class Seat  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int numOfRow;
	int seatNum;
	boolean isAvailable;
	Costumer cos;
	boolean isLux;
	
	
	public Seat(int row, int num,boolean isLux) {
		this.numOfRow = row;
		this.seatNum = num;
		this.isAvailable = true;
		this.isLux = isLux;
		cos = null;
	}
	
	/**
	 * return the row of which the seat is part of.
	 * @return
	 */
	public int getNumOfRow() {
		return numOfRow;
	}
	
	/**
	 * Sets the number of the row.
	 * @param row
	 */
	public void setRow(int row) {
		//method
		numOfRow = row;
	}
	
	/**
	 * return the number of the seat in the row.
	 * @return
	 */
	public int getSeatNum() {
		return seatNum;
	}
	
	/**
	 * Sets the number of the seat.
	 */
	public void setSeatNum(int num) {
		//method
		seatNum = num;
	}
	
	/**
	 * Return true is the seat is available (not reserved) or false otherwise.
	 * @return
	 */
	public boolean isAvailable() {
		return isAvailable;
	}
	
	/**
	 * Changes the availability of the seat.
	 * @param av
	 */
	public void setAvailability(boolean av) {
		//method
		this.isAvailable = av;
	}
	
	/**
	 * Return a Costumer object that hold the info of the costumer that reserved this seat. Null is the seat is not yet reserved. 
	 * @return
	 */
	public Costumer getCostumer() {
		return cos;
	}
	
	/**
	 * Sets the costumer that reserved this seat.
	 * @param c
	 */
	public void setCostumer(Costumer c) {
		//method
		cos = c;
	}
	
	/**
	 * Returns true is this seat is luxurious, false otherwise.
	 * @return
	 */
	public boolean isLux() {
		return isLux;
	}
	
	/**
	 * Changes the variable that holds the luxury of the seat.
	 * @param lux
	 */
	public void setLux(boolean lux) {
		//method
		isLux = lux;
	}
}
