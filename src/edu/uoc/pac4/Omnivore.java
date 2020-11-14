package edu.uoc.pac4;

public abstract class Omnivore extends Animal {

	
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
	 * Implemento el mètode abstracte Eat
	 */
	public void eat(Food food) throws AnimalException {
		if ( food.getType() == FoodType.PLANT ) {
			super.addEnergy(0.05*food.getKcal());
		} else if ( food.getType() == FoodType.MEAT ) {
			super.addEnergy(0.15*food.getKcal());
		}
	}
}
