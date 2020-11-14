package edu.uoc.pac4;

import java.time.LocalDateTime;

public abstract class Animal implements Comparable <Animal> {
	private int id;
	public static int nextId = 0;
	private String name = "Foo";
	private int yearBirth = 2000;
	private double weight = 0.1;
	private Gender gender;
	private double energy = 80.0;

	/**
	 * Constructor per defecte d'Animal, amb els seg�ents par�metres:
	 * name = "Foo"
	 * yearBirth = 2000
	 * weight = 0.1
	 * gender = UNDEFINED
	 * @throws AnimalException
	 */
	public Animal() throws AnimalException {
		this("Foo", 2000, 0.1, Gender.UNDEFINED);
	}
	
	/**
	 * Constructor parametritzat d'Animal.
	 * @param name
	 * @param yearBirth
	 * @param weight
	 * @param gender
	 * @throws AnimalException
	 */
	public Animal( String name, int yearBirth, double weight, Gender gender ) throws AnimalException {
		setName(name);
		setYearBirth(yearBirth);
		setWeight(weight);
		setGender(gender);
		setId();
	}

	/**
	 * M�tode abstracte makeNoise()
	 */
	public abstract void makeNoise();
	
	/**
	 * M�tode abstracte eat(food)
	 * @param food
	 */
	public abstract void eat(Food food) throws AnimalException;
	
	/**
	 * Getter de la variable energy
	 * @return
	 */
	public double getEnergy() {
		return energy;
	}

	/**
	 * M�tode addEnergy (substitut del Setter tradicional). Si l'energia sobrepassa 100, la rebaixa a aquest nombre.
	 * @param energy
	 * @throws AnimalException. Llen�a una excepci� MSG_ERR_ENERGY quan la variable energia no est� entre 0 i 100.
	 */
	// falta posar l'excepci�
	public void addEnergy(double energy) throws AnimalException {
		if ( energy >= 0.0 && energy <= 100.0 ) {
			this.energy += energy;			
		} else if ( energy < 0 ) {
			throw new AnimalException(AnimalException.MSG_ERR_ENERGY);
		}
		
		if ( energy > 100 ) {
			this.energy = 100.0;	
		}
	}

	/**
	 * Getter de Id
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter de Id.
	 */
	public void setId() {
		this.id = getNextId();
		incNextId();
	}

	/**
	 * Getter de nextId
	 * @return
	 */
	public int getNextId() {
		return nextId;
	}

	/**
	 * Setter de nextId
	 * @param nextId
	 */
	public void setNextId(int nextId) {
		this.nextId = nextId;
	}
	
	/**
	 * M�tode auxilar incNextId. Es fa servir en el setId().
	 */
	private void incNextId(){
		nextId++;
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
	 * Getter de la variable yearBirth
	 * @return
	 */
	public int getYearBirth() {
		return yearBirth;
	}

	/**
	 * Setter de la variable yearBirth
	 * @param yearBirth
	 * @throws AnimalException. Llan�a un tipus d'AnimalException corresponent al MSG_ERR_YEAR_BIRTH.
	 */
	public void setYearBirth(int yearBirth) throws AnimalException {
		if ( yearBirth > java.time.LocalDate.now().getYear() ) {
			throw new AnimalException (AnimalException.MSG_ERR_YEAR_BIRTH);
		}
		this.yearBirth = yearBirth;
	}
	
	/**
	 * Getter de la variable weight.
	 * @return
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Setter de la variable Weight
	 * @param weight
	 * @throws AnimalException
	 */
	public void setWeight(double weight) throws AnimalException {
		if ( weight < 0.1 ) {
			throw new AnimalException (AnimalException.MSG_ERR_WEIGTH);
		}
		this.weight = weight;
	}
	
	/**
	 * Getter de gender
	 * @return
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Setter de gender
	 * @param gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	/**
	 * Override del m�tode equals.
	 */
	@Override
	public boolean equals(Object auxAnimal) { 
		// Comparo primer l'objecte amb la variable this:   
		if (auxAnimal == this) { 
			return true; 
		} 

		// Comprovo que la variable d'entrada auxAnimal es una inst�ncia de la classe Animal:
		if (!(auxAnimal instanceof Animal)) { 
			return false; 
		} 

		// Transformo la variable auxAnimal a Animal per poder fer les comparacions:
		Animal auxAnimal2 = (Animal) auxAnimal; 

		// Comparo els resultats:
		return 	this.name == auxAnimal2.name
				&& this.yearBirth == auxAnimal2.yearBirth
				&& this.weight == auxAnimal2.weight
				&& this.gender == auxAnimal2.gender; 
	}

	/**
	 * Override del m�tode toString.
	 */
	@Override
	public String toString() {
		return String.format("My name is %s and I'm %d years old.\n" + "My gender is %s and my weight is %s kg.",
				this.name, calcYearsAge(), this.gender, this.weight);
	}
	
	/**
	 * M�tode auxiliar calcYearsAge. Serveix per calcular l'edat, i el farem servir en l'override del m�tode toString().
	 * @return
	 */
	private int calcYearsAge() {
		return LocalDateTime.now().getYear() - this.yearBirth;
	}

	@Override
	public int compareTo(Animal auxAnimal) {
		int aux = Integer.compare(auxAnimal.yearBirth, this.yearBirth);
		if (aux == 0) {
			aux = Double.compare(auxAnimal.weight, this.weight);
		}
		return aux;
	}

}
