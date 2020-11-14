package edu.uoc.pac4;

public abstract class Omnivore extends Animal {
	private String name;
	private int yearBirth;
	private double weight;
	private Gender gender;
	
	
	/**
	 * Constructor per defecte d'Omnivore
	 * @throws AnimalException
	 */
	public Omnivore() throws AnimalException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor paramètric d'Omnivore
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Omnivore(String name, int yearBirth, Double weight, Gender gender) throws AnimalException {
		super(name, yearBirth, weight, gender);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Sobrecàrrega del mètode eat per a la classe abstracte Omnivore.
	 */
	@Override
	public void eat(Food food) {
		// TODO Auto-generated method stub
		
	}

}
