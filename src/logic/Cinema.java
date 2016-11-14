package logic;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * This is the main class. Holds all the info about Theaters, Shows, Screenings and Costumers
 * @author Thanasis Tolikas
 *
 */
public class Cinema implements Serializable{

	private static final long serialVersionUID = 1L;
	ArrayList<Movie> movies;
	ArrayList<Drama> dramas;
	ArrayList<MovieTheater> movieTheaters;
	ArrayList<DramaTheater> dramaTheaters;
	ArrayList<MovieScreening> movieScreenings;
	ArrayList<DramaScreening> dramaScreenings;
	ArrayList<Costumer> costumers;
	
	public Cinema() {
		movies = new ArrayList<>();
		dramas = new ArrayList<>();
		movieTheaters = new ArrayList<>();
		dramaTheaters = new ArrayList<>();
		movieScreenings= new ArrayList<>();
		dramaScreenings = new ArrayList<>();
		costumers = new ArrayList<>();
		
	}
	/**
	 * Adds a Movie to the list.
	 * @param m
	 */
	public void addMovie(Movie m) {
		movies.add(m);
	}
	/**
	 * Adds a Drama to the list.
	 * @param d
	 */
	public void addDrama(Drama d) {
		dramas.add(d);
	}
	
	/**
	 * Adds a Movie Theater to the list.
	 * @param mt
	 */
	public void addMovieTheater(MovieTheater mt) {
		movieTheaters.add(mt);
	}
	
	/**
	 * Adds a Drama Theater to the list.
	 * @param dt
	 */
	public void addDramaTheater(DramaTheater dt) {
		dramaTheaters.add(dt);
	}
	
	/**
	 * Adds a movie screening to the list.
	 * @param s
	 */
	public void addMovieScreening(MovieScreening s) {
		movieScreenings.add(s);
	}
	
	/**
	 * Adds a drama screening to the list.
	 * @param s
	 */
	public void addDramaScreening(DramaScreening s) {
		dramaScreenings.add(s);
	}
	
	/**
	 * Return the list that holds the movies.
	 * @return an ArrayList of type Movie.
	 */
	public ArrayList<Movie> getMovies() {
		return movies;
	}
	
	/**
	 * Returns the list the holds the dramas.
	 * @return ArrayList of type Drama.
	 */
	public ArrayList<Drama> getDramas() {
		return dramas;
	}

	/**
	 * Removes the Movie from the list specified by index.
	 * @param index
	 */
	public void removeMovie(int index) {
		// TODO Auto-generated method stub
		movies.remove(index);
	}

	/**
	 * Removes the Drama from the list specified by index
	 * @param index
	 */
	public void removeDrama(int index) {
		// TODO Auto-generated method stub
		dramas.remove(index);
	}
	
	/**
	 * Returns the list that holds the Movie Theaters.
	 * @return
	 */
	public ArrayList<MovieTheater> getMovieTheaters() {
		return movieTheaters;
	}
	
	/**
	 * Returns the list that holds the Drama Theaters.
	 * @return
	 */
	
	public ArrayList<DramaTheater> getDramaTheaters() {
		return dramaTheaters;
	}
	
	/**
	 * Removes the Movie theater from the list specified by index.
	 * @param index
	 */
	
	public void removeMovieTheater(int index) {
		movieTheaters.remove(index);
	}
	/**
	 * Removes the Drama theater from the list specified by index.
	 * @param index
	 */
	public void removeDramaTheater(int index) {
		dramaTheaters.remove(index);
	}
	
	/**
	 * Returns the list that holds the Movie Screenings.
	 * @return
	 */
	public ArrayList<MovieScreening> getMovieScreenings() {
		return movieScreenings;
	}
	
	/**
	 * Returns the list that holds the Drama Screenings.
	 * @return
	 */
	public ArrayList<DramaScreening> getDramaScreenings() {
		return dramaScreenings;
	}
	
	/**
	 * Removes the Movie Screening from the list specified by index.
	 * @param index
	 */
	public void removeMovieScreening(int index) {
		movieScreenings.remove(index);
	}
	
	/**
	 * Removes the Drama Screening from the list specified by index.
	 * @param index
	 */
	public void removeDramaScreening(int index) {
		dramaScreenings.remove(index);
	}
	
	/**
	 * Adds a costumer to the list.
	 * @param c
	 */
	public void addCostumer (Costumer c) {
		costumers.add(c);
	}
	
	/**
	 * Returns the list that holds the Costumers.
	 * @return
	 */
	public ArrayList<Costumer> getCostumers() {
		return costumers;
	}
	
	/**
	 * Finds and returns the costumer with the specified telephone number. 
	 * @param tel
	 * @return
	 */
	public Costumer findCostumer (String tel) {
		for (Costumer c : costumers) {
			if (c.getTelNum().equals(tel)) {
				return c;
			}
		}
		return null;
	}
	
	/**
	 * Cancels the reservation of a costumer specified by the telephone number.
	 * @param tel
	 * @return True is the costumer exists, false otherwise.
	 */
	public boolean cancelCostumerReservation(String tel) {
		for (Costumer c : costumers) {
			if (c.getTelNum().equals(tel)) {
				Screening s= c.getReservedScreeningInfo();
				if ((s instanceof MovieScreening)) {
					for (Row r : ((MovieScreening)s).getTheater().getRows()) {
						for (Seat st : r.getSeats()) {
							if (st.getCostumer() != null && (st.getCostumer()).equals(c)) {
								st.setAvailability(true);
							}
						}
					}
					
				}
				else {
					for (Row r : ((DramaScreening)s).getTheater().getRows()) {
						for (Seat st : r.getSeats()) {
							if (st.getCostumer() != null && (st.getCostumer()).equals(c)) {
								st.setAvailability(true);
							}
						}
					}
				}
				costumers.remove(c);
				return true;
			}
			
		}
		return false;
	}
}
