package logic;

import java.io.Serializable;



/**
 * Holds info for a movie screening or a drama show.
 * @author Thanasis Tolikas
 *
 */
public class Screening  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String day;
	String month;
	String year;
	String minutes;
	String hour;
	//LocalDate ld;
	//LocalTime lt;
	
	public Screening(String day,String month,String year, String hour, String minutes) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minutes = minutes;
		//LocalDate.of(year, month, day);
		//LocalTime.of(hour, minutes);

	}
	
	/**
	 * Returns the date of the screening.
	 * @return
	 */
	public String getDate() {
		return "" + day + "/" + month + "/" + year;
	}
	
	/**
	 * Sets the date of the screening.
	 * @param date
	 */
	public void setDate(String day, String month, String year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/**
	 * Return the starting time of the screening.
	 * @return
	 */
	public String getTime() {
		return "" + hour + ":" + minutes;
	}
	
	/**
	 * Sets the starting time of the screening.
	 * @param o
	 */
	public void setTime(String hour, String minutes) {
		this.hour = hour;
		this.minutes = minutes;
	}
	
	/**
	 * Returns the hour of the screening.
	 * @return
	 */
	public String getHour() {
		return hour;
	}
	
	/**
	 * Returns the minutes of the screening.
	 * @return
	 */
	public String getMinutes() {
		return minutes;
	}
}
