package edu.uoc.pac4;

import java.time.LocalDateTime;

public class Hen extends Omnivore {
	private Gender gender;

	/**
	 * Constructor per defecte de Hen
	 * @throws AnimalException
	 */
	public Hen() throws AnimalException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor param�tric de Hen
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Hen(String name, int yearBirth, Double weight, Gender gender) throws AnimalException {
		super(name, yearBirth, weight, gender);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Override del m�tode makeNoise()
	 */
	@Override
	public String makeNoise() {
		String crit;
		crit = String.format("Co-co-co!!!");
		return crit;
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
		this.gender = Gender.FEMALE;
	}

}