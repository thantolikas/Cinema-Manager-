package logic;

import java.io.Serializable;

/**
 * Movie class extends the Show class. Holds extra info.
 * @author Thanasis Tolikas
 *
 */
public class Movie extends Show   implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int duration; //in minutes
	/**
	 * Constructor
	 */
	public Movie(String name, String desc, String dir) {
		super(name,desc,dir);
	}
	
	/**
	 * Return the duration of the movie.
	 * @return
	 */
	public int getDuration() {
		//method
		return duration;
	}
	
	/**
	 * Changes the duration of the movie.
	 * @param dur
	 */
	public void changeDuration(int dur) {
		//method
		this.duration = dur;
	}
	
	
}
