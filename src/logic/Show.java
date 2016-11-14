package logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Show class holds the info of a show (movie or drama).only used as a parent.
 * @author Thanasis Tolikas
 *
 */
public class Show  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String description;
	String director;
	ArrayList<String> actors;
	
	public Show(String name, String desc, String dir) {
		actors = new ArrayList<>();
		this.name = name;
		this.description = desc;
		this.director = dir;
	}
	
	/**
	 * Returns the name of the show.
	 * @return
	 */
	public String getName() {
		//method
		return name;
	}
	
	/**
	 * Changes the name of the show.
	 * @param name
	 */
	public void changeName(String name) {
		//method
		this.name = name;
	}
	
	/**
	 * Return the description of the show.
	 * @return
	 */
	public String getDescription() {
		//method
		return description;
	}
	/**
	 * Changes the description of the show.
	 * @param desc
	 */
	public void changeDescription(String desc) {
		//method
		this.description = desc;
	}
	
	/**
	 * Return the director of the show.
	 * @return
	 */
	public String getDirector() {
		//method
		return director;
	}
	
	/**
	 * Changes the director of the show.
	 * @param dir
	 */
	public void changeDirector(String dir) {
		//method
		this.director = dir;
	}
	
	/**
	 * Returns a list of the actors' names.
	 * @return
	 */
	public ArrayList<String> getActors() {
		//method
		return actors;
	}
	
	/**
	 * Adds an actor in the actors' list.
	 * @param name
	 */
	public void addActor(String name) {
		//method
		actors.add(name);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	/**
	 * Empties the array of actors.
	 */
	public void emptyActorsArray() {
		for (int i=0;i<actors.size();i++) {
			actors.remove(i);
		}
	}
}
