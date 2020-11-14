package edu.uoc.pac4;

import java.time.LocalDateTime;

public class Elephant extends Herbivore {
	
	public Elephant() throws AnimalException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Elephant(String name, int yearBirth, double weight, Gender gender) throws AnimalException {
		super(name, yearBirth, weight, gender);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Implementa el mètode abstracte d'Animal makeNoise()
	 */
	@Override
	public void makeNoise() {
		System.out.print("Brrrrr!!!");
	}
	
	/**
	 * Override del mètode toString.
	 */
	@Override
	public String toString() {
		return String.format("My name is %s and I'm %d years old.\n" + "My gender is %s and my weight is %s kg.\n" + "I'm an elephant.",
				this.getName(), calcYearsAge(), this.getGender(), this.getWeight());
	}
	
	/**
	 * Mètode auxiliar calcYearsAge. Serveix per calcular l'edat, i el farem servir en l'override del mètode toString().
	 * @return
	 */
	private int calcYearsAge() {
		return LocalDateTime.now().getYear() - this.getYearBirth();
	}
}
