package edu.uoc.pac4;

public class Food {
	private String name;
	private int kcal = 0;
	private FoodType type;
	
	public Food (String name, int kcal, FoodType type) throws IllegalArgumentException {
		if ( kcal >= 0.0 ) {
			this.name = name;
			this.kcal = kcal;
			this.type = type;	
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
	 * Override del mètode toString.
	 */
	@Override
	public String toString() {
		return String.format("%s (%s): %d kcal",
				this.name, getType(), this.kcal);
	}

	
}
