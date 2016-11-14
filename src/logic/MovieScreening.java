package logic;

import java.io.Serializable;

/**
 * Extends the class Screening and is used for the movie screenings.
 * @author Thanasis Tolikas
 *
 */
public class MovieScreening extends Screening   implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MovieTheater th;
	Movie movie;
	
	public MovieScreening(String day, String month, String year, String hour,
			String minutes) {
		super(day, month, year, hour, minutes);
		
		
		// TODO Auto-generated constructor stub
	}
	
	public MovieTheater getTheater() {
		return th;
	}
	
	/**
	 * Sets the theater of the screening/show.
	 * @param t
	 * @return
	 */
	public void setTheater(MovieTheater t) {
		//method
		th = t;
	}
	
	/**
	 * Return an object type Show of the show (movie/drama).
	 * @return
	 */
	public Movie getShow() {
		return movie;
	}
	
	/**
	 * Sets the show of the screening
	 */
	public void setShow(Movie s) {
		//method
		movie = s;
	}
	

	@Override
	public String toString() {
		return movie.getName() + " - " + getDate() + " - " + getTime() + " - " + th.getName(); 
	}
	

}
