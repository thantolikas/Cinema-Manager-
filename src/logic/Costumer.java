package logic;

import java.io.Serializable;


/**
 * Costumer class holds the info of a costumer that made a reservation.
 * @author Thanasis Tolikas
 *
 */
public class Costumer  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String telephone;
	Screening scrn;
	
	public Costumer (String name, String tel, Screening scrn) {
		this.name = name;
		telephone = tel;
		this.scrn = scrn;
	}
	
	
	/**
	 * Returns the name of the costumer.
	 * @return name
	 */
	public String getCostumerName() {
		//method
		return name;

	}
	/**
	 * Changes the name of the costumer.
	 * @param name
	 */
	public void changeName(String name) {
		//method
		this.name = name;
	}
	
	/**
	 * Return the telephone number of the costumer.
	 * @return telNum
	 */
	public String getTelNum() {
		//method
		return telephone;
	}
	
	/**
	 * Changes the telephone number of the costumer.
	 * @param tel
	 */
	public void changeTelNum(String tel) {
		//method
		this.telephone = tel;
	}
	
	/**
	 * Returns the screening information that the costumer made reservation.
	 * @return
	 */
	public Screening getReservedScreeningInfo() {
		//method
		return scrn;
	}
	
	/**
	 * Changes the reserved screening.
	 * @param s
	 */
	public void changeScreening(Screening s) {
		//method
		this.scrn = s;
	}
	
	
}
