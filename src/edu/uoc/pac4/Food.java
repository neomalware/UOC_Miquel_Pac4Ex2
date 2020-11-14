package edu.uoc.pac4;

import java.time.LocalDateTime;

public class Food {
	private String name;
	private int kcal = 0;
	private FoodType type;
	
	public Food (String name, int kcal, FoodType type) throws IllegalArgumentException {
		if ( kcal >= 0.0 ) {
			setName(name);
			this.kcal = 0;
			setType(type);		
		} else {
			throw new IllegalArgumentException("[ERROR] Food's kcal cannot be negative!!");
		}
	}
	
	/**
	 * Getter de la variable name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter de la variable name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter de la variable kcal
	 * @return
	 */
	public int getKcal() {
		return kcal;
	}
	
	/**
	 * Getter de la variable type
	 * @return
	 */
	public FoodType getType() {
		return type;
	}
	
	/**
	 * Setter de la variable type
	 * @param type
	 */
	public void setType(FoodType type) {
		this.type = type;
	}
	
	/**
	 * Override del mètode toString.
	 */
	@Override
	public String toString() {
		return String.format("%s (%s): %d kcal",
				this.name, getType(), this.kcal);
	}

	
}
