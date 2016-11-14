package logic;

import java.io.Serializable;

/**
 * Represents a theater used for movie screenings.
 * Extends the class Theater.
 * @author Thanasis Tolikas
 *
 */
public class MovieTheater extends Theater  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Screen scr;
	String soundSystem;
	double ticketPrice;
	
	public MovieTheater (String name,int cap,double screenSize,boolean is3d, String soundSystem) {
		super(name,cap);
		scr = new Screen(screenSize,is3d);
		this.soundSystem = soundSystem;
	}
	
	/**
	 * Return a Screen object with the screen info.
	 * @return
	 */
	public Screen getScreenInfo() {
		return scr;
	}
	
	/**
	 * Changes the screen.
	 * @param sc
	 */
	public void changeScreen(Screen sc) {
		//method
		this.scr = sc;
	}
	
	/**
	 * Returns the sound system of the theater.
	 * @return
	 */
	public String getSoundSystem() {
		return soundSystem;
	}
	
	/**
	 * Changes the sound system of the theater.
	 * @param ss
	 */
	public void changeSoundSystem(String ss) {
		//method
		this.soundSystem = ss;
	}
	
	public void setTicketPrice(double pr) {
		ticketPrice = pr;
	}
	
	public double getTicketPrice() {
		return ticketPrice;
	}
	
}
