package edu.uoc.pac4;

import java.time.LocalDateTime;

public class Cow extends Herbivore {
	int dim = 0;
	private int maxMilkPerDay = 35;
	public static final int PEAK_MILK = 90; 
	
	/**
	 * Constructor per defecte de Cow
	 * @throws AnimalException
	 */
	public Cow() throws AnimalException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructor paramètric de Cow
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Cow(String name, int yearBirth, Double weight, Gender gender) throws AnimalException {
		super(name, yearBirth, weight, gender);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Getter de PeakMilk
	 * @return
	 */
	public static int getPeakMilk() {
		return PEAK_MILK;
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
	 * Getter de la variable maxMilkPerDay
	 * @return
	 */
	public int getMaxMilkDays() {
		return MAX_DIM;
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
	public String makeNoise(int times) {
		String crit;
		crit = String.format("Muuuuuu!!!");
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
