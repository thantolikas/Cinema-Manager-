package logic;

import java.io.Serializable;

/**
 * Holds the info of a screen. Used in movie theaters.
 * @author Thanasis Tolikas
 *
 */
public class Screen   implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double size; //in inches
	boolean is3D;
	public Screen(double size, boolean d) {
		this.size = size;
		this.is3D =d;
	}
	/**
	 * Return the size of the screen in inches.
	 * @return
	 */
	public double getSize() {
		return size;
	}
	
	/**
	 * changes the size of the screen.
	 * @param size
	 */
	public void changeSize(double size) {
		//method
		this.size = size;
	}
	
	/**
	 * Return if the screen supports 3d screenings.
	 * @return
	 */
	public boolean is3dCapable() {
		return is3D;
	}
	
	/**
	 * Changes the 3d capability of the screen.
	 * @param d
	 */
	public void change3d(boolean d) {
		//method
		is3D = d;
	}

}
