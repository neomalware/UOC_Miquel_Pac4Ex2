package edu.uoc.pac4;

import java.time.LocalDateTime;

public class KomodoDragon extends Carnivore implements EggLayer {

	/**
	 * Constructor per defecte de KomodoDragon
	 * @throws AnimalException
	 */
	public KomodoDragon() throws AnimalException {
		super();
	}
	
	/**
	 * Constructor param�tric de KomodoDragon
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public KomodoDragon(String name, int yearBirth, double weight, Gender gender) throws AnimalException {
		super(name, yearBirth, weight, gender);
	}

	/**
	 * Implementa el m�tode abstracte d'Animal makeNoise()
	 */
	@Override
	public void makeNoise() {
		System.out.print("Grrrrr!!!");
	}

	/**
	 * Override del m�tode toString.
	 */
	@Override
	public String toString() {
		return String.format("My name is %s and I'm %d years old.\n" + "My gender is %s and my weight is %s kg.\n" + "I'm a Komodo dragon.",
				this.getName(), calcYearsAge(), this.getGender(), this.getWeight());
	}
	
	/**
	 * M�tode auxiliar calcYearsAge. Serveix per calcular l'edat, i el farem servir en l'override del m�tode toString().
	 * @return
	 */
	private int calcYearsAge() {
		return LocalDateTime.now().getYear() - this.getYearBirth();
	}

	/**
	 * Implemento el m�tode abstracte lay() de la interf�cie EggLayer
	 */
	public boolean lay() {
		double random = Math.random();
		if ( random > 0.8 ) {
			return true;
		} else {
			return false;
		}
	}

}
