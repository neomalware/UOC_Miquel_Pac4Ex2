package edu.uoc.pac4;

import java.time.LocalDateTime;

public class Goat extends Herbivore implements Milkable  {
	public static final int PEAK_MILK = 80; 
	int dim = 0;
	private int maxMilkPerDay = 6;
	
	/**
	 * Constructor param�tric 1 de Goat
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Goat(String name, int yearBirth, double weight) throws AnimalException {
		super(name, yearBirth, weight, Gender.FEMALE);
	}
	
	/**
	 * Constructor param�tric 2 de Goat
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Goat(String name, int yearBirth, double weight, int maxMilkPerDay ) throws AnimalException {
		super(name, yearBirth, weight, Gender.FEMALE);
		setMaxMilkPerDay(maxMilkPerDay);
	}

	/**
	 * Getter de Dim (days in milk)
	 * @return
	 */
	public int getDaysInMilk() {
		return dim;
	}

	/**
	 * Setter de Dim (Days in milk)
	 * @param dim
	 */
	public void setDaysInMilk(int dim) {
		this.dim = dim;
	}

	/**
	 * Getter de PeakMilk
	 * @return
	 */
	public int getPeakMilk() {
		return PEAK_MILK;
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
	 * Implementa el m�tode abstracte d'Animal makeNoise()
	 */
	@Override
	public void makeNoise() {
		System.out.print("Beeeeee!!!");
	}

	/**
	 * Override del m�tode setGender per for�ar que el sexe sempre sigui femen�
	 */
	@Override
	public void setGender(Gender gender) {
		super.setGender(Gender.FEMALE);
	}
	
	/**
	 * Override del m�tode toString.
	 */
	@Override
	public String toString() {
		return String.format("My name is %s and I'm %d years old.\n" + "My gender is %s and my weight is %s kg.\n" + "I'm a goat.",
				this.getName(), calcYearsAge(), this.getGender(), this.getWeight());
	}
	
	/**
	 * M�tode auxiliar calcYearsAge. Serveix per calcular l'edat, i el farem servir en l'override del m�tode toString().
	 * @return
	 */
	private int calcYearsAge() {
		return LocalDateTime.now().getYear() - this.getYearBirth();
	}

}
