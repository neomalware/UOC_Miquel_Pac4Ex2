package edu.uoc.pac4;

public abstract class Carnivore extends Animal {
	
	/**
	 * Constructor per defecte de Carnivore
	 * @throws AnimalException
	 */
	public Carnivore() throws AnimalException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor paramètric de Carnivore
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Carnivore(String name, int yearBirth, Double weight, Gender gender) throws AnimalException {
		super(name, yearBirth, weight, gender);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Implemento el mètode abstracte Eat
	 */
	public void eat(Food food) throws AnimalException {
		if ( food.getType() == FoodType.MEAT ) {
			super.addEnergy(0.2*food.getKcal());
		} else {
			throw new AnimalException(AnimalException.MSG_ERR_CARNIVORE_FOOD);
		}		
	}
}
