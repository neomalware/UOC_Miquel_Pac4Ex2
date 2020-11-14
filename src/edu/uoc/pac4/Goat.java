package edu.uoc.pac4;

import java.time.LocalDateTime;

public class Goat extends Herbivore {
	int dim = 0;
	private int maxMilkPerDay = 6;
	public static final int PEAK_MILK = 80; 
	
	/**
	 * Constructor per defecte d'Animal
	 * @throws AnimalException
	 */
	public Goat() throws AnimalException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getter de Dim (days in milk)
	 * @return
	 */
	public int getDim() {
		return dim;
	}

	/**
	 * Setter de Dim (Days in milk)
	 * @param dim
	 */
	public void setDim(int dim) {
		this.dim = dim;
	}

	/**
	 * Getter de PeakMilk
	 * @return
	 */
	public static int getPeakMilk() {
		return PEAK_MILK;
	}

	/**
	 * Constructor paramètric de Goat
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Goat(String name, int yearBirth, Double weight, Gender gender) throws AnimalException {
		super(name, yearBirth, weight, gender);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Getter de la variable maxMilkPerDay
	 * @return
	 */
	public int getMaxMilkPerDay() {
		return maxMilkPerDay;
	}

	/**
	 * Setter de la variable maxMilkPerDay
	 * @param maxMilkPerDay
	 */
	public void setMaxMilkPerDay(int maxMilkPerDay) {
		this.maxMilkPerDay = maxMilkPerDay;
	}
	
	/**
	 * Override del mètode makeNoise()
	 */
	@Override
	public String makeNoise() {
		String crit;
		crit = String.format("Beeeeee!!!");
		return crit;
	}

	/**
	 * Override del mètode setGender per forçar que el sexe sempre sigui femení
	 */
	@Override
	public void setGender(Gender gender) {
		this.gender = Gender.FEMALE;
	}
	
	/**
	 * Override del mètode toString.
	 */
	@Override
	public String toString() {
		return String.format("My name is %s and I'm %d years old.\n" + "My gender is %s and my weight is %s kg.\n" + "I'm a goat.",
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
