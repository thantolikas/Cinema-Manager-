package logic;

import java.io.Serializable;

/**
 * Holds the info of a drama show.
 *
 * @author	Thanasis Tolikas
 *
 */
public class Drama extends Show  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double price;
	
	public Drama(String name, String desc, String dir) {
		super(name,desc,dir);
	}
	
	/**
	 * Sets the price.
	 * @param pr
	 */
	public void setPrice(double pr) {
		price= pr;
	}
	
	/**
	 * Returns the price.
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	
}
