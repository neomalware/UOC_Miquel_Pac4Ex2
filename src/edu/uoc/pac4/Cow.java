package edu.uoc.pac4;

import java.time.LocalDateTime;

public class Cow extends Herbivore implements Milkable {
	public static final int PEAK_MILK = 90; 
	int dim = 0;
	private int maxMilkPerDay = 35;
	
	/**
	 * Constructor paramètric 1 de Cow
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Cow(String name, int yearBirth, double weight) throws AnimalException {
		super(name, yearBirth, weight, Gender.FEMALE);
	}
	
	/**
	 * Constructor paramètric 2 de Cow
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Cow(String name, int yearBirth, double weight, int maxMilkPerDay ) throws AnimalException {
		super(name, yearBirth, weight, Gender.FEMALE);
		setMaxMilkPerDay(maxMilkPerDay);
	}

	/**
	 * Getter de PeakMilk
	 * @return
	 */
	public int getPeakMilk() {
		return PEAK_MILK;
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
		if (dim < 0 ) {
			throw new IllegalArgumentException(MSG_ERR_DAYS_IN_MILK_NEGATIVE);
		} else if (dim > MAX_DIM ) {
			throw new IllegalArgumentException(MSG_ERR_DAYS_IN_MILK_GREATER);
		} else {
			this.dim = dim;
		}
	}
	
	/**
	 * Getter de la variable maxMilkPerDay
	 * @return
	 */
	public int getMaxMilkDays() {
		return MAX_DIM;
	}

	/**
	 * Getter del màxim de llet per dia
	 */
	public int getMaxMilkPerDay() {
		return maxMilkPerDay;
	}
	
	/**
	 * Setter de la variable maxMilkPerDay
	 * @param maxMilkPerDay
	 */
	public void setMaxMilkPerDay(int maxMilkPerDay) {
		if ( maxMilkPerDay < 0 ) {
			throw new IllegalArgumentException(MSG_ERR_MAX_LITERS_PER_DAYS_NEGATIVE);
		} else {
			this.maxMilkPerDay = maxMilkPerDay;
		}
	}

	/**
	 * Implementa makenoise mitjançant el següent mètode
	 */
	@Override
	public void makeNoise() {
		makeNoise(1);
	}
	
	/**
	 * Sobrecarrego el mètode abstracte d'Animal makeNoise()
	 */
	public void makeNoise(int times) {
		String message = "Muuuuuu!!!";
		for ( int i = 0; i < times ; i++ ) {
			message += message;
		}
		System.out.print(message);
	}
	
	/**
	 * Override del mètode setGender per forçar que el sexe sempre sigui femení
	 */
	@Override
	public void setGender(Gender gender) {
		super.setGender(Gender.FEMALE);
	}
	
	/**
	 * Override del mètode toString.
	 */
	@Override
	public String toString() {
		return String.format("My name is %s and I'm %d years old.\n" + "My gender is %s and my weight is %s kg.\n" + "I'm a cow.",
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
