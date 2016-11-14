package logic;

import java.io.Serializable;

/**
 * Represents a theater used for drama shows.
 * Extends the class Theater.
 * @author Thanasis Tolikas
 *
 */
public class DramaTheater extends Theater   implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int dressingRooms;
	public DramaTheater(String name,int cap,int dr) {
		super(name,cap);
		this.dressingRooms = dr;
	}
	
	/**
	 * Return the number of the dressing rooms that are available in this theater.
	 * @return
	 */
	
	public int getNumOfDressingRooms() {
		return dressingRooms;
	}
	
	/**
	 * Changes the number of the dressing rooms.
	 * @param num
	 */
	
	public void changeNoDR(int num) {
		//method
		this.dressingRooms = num;
	}
}
