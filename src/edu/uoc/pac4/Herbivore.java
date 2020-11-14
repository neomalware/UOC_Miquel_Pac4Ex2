package edu.uoc.pac4;

public abstract class Herbivore extends Animal {

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
	public Herbivore(String name, int yearBirth, double weight, Gender gender) throws AnimalException {
		super(name, yearBirth, weight, gender);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Implemento el mètode abstracte Eat
	 */
	public void eat(Food food) throws AnimalException {
		if ( food.getType() == FoodType.PLANT ) {
			super.addEnergy(0.1*food.getKcal());
		} else {
			throw new AnimalException(AnimalException.MSG_ERR_HERBIVORE_FOOD);
		}		
	}
}
