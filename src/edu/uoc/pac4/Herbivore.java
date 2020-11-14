package edu.uoc.pac4;

public abstract class Herbivore extends Animal {
	private String name;
	private int yearBirth;
	private double weight;
	private Gender gender;
	
	/**
	 * Constructor per defecte Hebivore
	 * @throws AnimalException
	 */
	public Herbivore() throws AnimalException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor paramètric Herbivore
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Herbivore(String name, int yearBirth, Double weight, Gender gender) throws AnimalException {
		super(name, yearBirth, weight, gender);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Sobrecàrrega del mètode eat per a la classe abstracte Herbivore.
	 */
	@Override
	public void eat(Food food) {
		// TODO Auto-generated method stub
		
	}

}
