package logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Only used as a parent.
 * @author Thanasis Tolikas
 *
 */
public class Theater  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	int capacity;
	ArrayList<Row> rows;
	
	public Theater(String name,int cap) {
		this.name = name;
		this.capacity = cap;
		rows = new ArrayList<>();
	}
	
	/**
	 * Return the name of the theater.
	 * @return
	 */
	public String getName() {
		//method
		return name;
	}
	
	/**
	 * Changes the name of the theater.
	 * @param name
	 */
	public void changeName(String name) {
		//method
		this.name = name;
	}
	
	/**
	 * Returns the capacity of the theater.
	 * @return
	 */
	public int getCapacity(){
		//method
		return capacity;
	}
	
	/**
	 * Changes the capacity.
	 * @param cap
	 */
	public void changeCapacity(int cap) {
		//method
		this.capacity = cap;
	}
	
	/**
	 * Returns the list that holds the rows.
	 * @return
	 */
	public ArrayList<Row> getRows() {
		return rows;
	}
	
	/**
	 * Adds a row.
	 * @param row
	 */
	public void addRow(Row row) {
		rows.add(row);

	}
	
	/**
	 * Returns the number of the rows in the theater.
	 * @return
	 */
	public int getNumOfRows() {
		return rows.size();
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * Emtpies the list of the rows.
	 */
	public void emptyRows() {
		for (int i=0;i<rows.size();i++) {
			rows.remove(i);
		}
	}
}
