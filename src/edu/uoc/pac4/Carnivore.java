package edu.uoc.pac4;

public abstract class Carnivore extends Animal {
	private String name;
	private int yearBirth;
	private double weight;
	private Gender gender;
	
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
	 * Sobrecàrrega del mètode eat.
	 */
	@Override
	public void eat(Food food) throws AnimalException {
		if ( getType(food) == "MEAT" ) {
			addEnergy(0.2*super.getKcal(food));
		} else {
			throw new AnimalException(AnimalException.MSG_ERR_CARNIVORE_FOOD);
		}
		
	}
	
}
