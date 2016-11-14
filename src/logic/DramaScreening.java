package logic;

import java.io.Serializable;

/**
 * Extends Screening class and is used for Drama screenings.
 * @author Thanasis Tolikas
 *
 */
public class DramaScreening extends Screening   implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DramaTheater th;
	Drama drama;
	
	public DramaScreening(String day, String month, String year, String hour,
			String minutes) {
		super(day, month, year, hour, minutes);
		
		
		// TODO Auto-generated constructor stub
	}
	
	public DramaTheater getTheater() {
		return th;
	}
	
	/**
	 * Sets the theater of the screening/show.
	 * @param t
	 * @return
	 */
	public void setTheater(DramaTheater t) {
		//method
		th = t;
	}
	
	/**
	 * Return an object type Show of the show (movie/drama).
	 * @return
	 */
	public Drama getShow() {
		return drama;
	}
	
	/**
	 * Sets the show of the screening
	 */
	public void setShow(Drama s) {
		//method
		drama = s;
	}
	
	@Override
	public String toString() {
		return drama.getName() + " - " + getDate() + " - " + getTime() + " - " + th.getName(); 
	}
	
}
