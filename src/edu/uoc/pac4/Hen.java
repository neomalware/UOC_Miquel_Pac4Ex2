package edu.uoc.pac4;

import java.time.LocalDateTime;

public class Hen extends Omnivore {
	
	/**
	 * Constructor param�tric de Hen
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Hen(String name, int yearBirth, Double weight) throws AnimalException {
		super(name, yearBirth, weight, Gender.FEMALE);
	}

	/**
	 * Implementa el m�tode abstracte d'Animal makeNoise()
	 */
	@Override
	public void makeNoise() {
		System.out.print("Co-co-co!!!");
	}

	/**
	 * Override del m�tode toString.
	 */
	@Override
	public String toString() {
		return String.format("My name is %s and I'm %d years old.\n" + "My gender is %s and my weight is %s kg.\n" + "I'm a hen.",
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
	 * Override del m�tode setGender per for�ar que el sexe sempre sigui femen�
	 */
	@Override
	public void setGender(Gender gender) {
		super.setGender(Gender.FEMALE);
	}

}
