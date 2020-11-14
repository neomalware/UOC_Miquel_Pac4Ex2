package edu.uoc.pac4;

public class AnimalException extends Exception {
	public final static String MSG_ERR_YEAR_BIRTH = "[ERROR] Animal's birth year cannot be later than current year";
	public final static String MSG_ERR_WEIGTH = "[ERROR] Animal's weight cannot be smaller than 0.1 kg.";
	public final static String MSG_ERR_ENERGY = "[ERROR] Animal's energy cannot be negative value.";
	public final static String MSG_ERR_HERBIVORE_FOOD = "[ERROR] An herbivore animal cannot eat any food which is not a plant.";
	public final static String MSG_ERR_CARNIVORE_FOOD = "[ERROR] An carnivore animal cannot eat any food which is not meat.";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnimalException() {
		super();
	}
	
	public AnimalException(String msg) {
		super(msg);
	}
}
