package edu.uoc.pac4;

public interface Milkable {
	public static final int MAX_DIM = 300;
	public String MSG_ERR_NO_MILK = "[ERROR] This animal is not pregnant, so it cannot give milk.";
	public String MSG_ERR_DAYS_IN_MILK_NEGATIVE = "[ERROR] Days in milk cannot be a negative value!!";
	public String MSG_ERR_DAYS_IN_MILK_GREATER = "[ERROR] Days in milk cannot be greater than"+MAX_DIM+"!!";
	public String MSG_ERR_MAX_LITERS_PER_DAYS_NEGATIVE = "[ERROR] Max. liters of milk per day cannot be a negative value!!";
		
	public int getDaysInMilk();
	
	public int setDaysInMilk();
	
	public int getPeakMilk();
	
	public int getMaxMilkPerDay();
	
	public int setMaxMilkPerDay();
	
	/**
	 * M�tode milk. Retorna la quantitat de llet munyida i incrementa una unitat el nombre de dies que ha 
	 * donat llet (dim). Si al moment d�invocar a aquest m�tode, el valor de dim �s major o igual al m�xim 
	 * de dies que pot donar llet (MAX_DIM), llavors el m�tode no ha de fer res i tan sols ha de llan�ar 
	 * una excepci� de tipus AnimalException amb el missatge que hi ha en l'atribut MSG_ERR_NO_MILK 
	 * d'AnimalException. En cas contrari, la quantitat de llet que s'obt� del munyit dep�n del moment en 
	 * qu� es faci:
	 * @param dim 
	 * @param PEAK_MILK 
	 * @return
	 */
	public default int milk(int dim, int PEAK_MILK) throws Exception {
		
		if ( dim >= MAX_DIM ) {
			throw new Exception(MSG_ERR_NO_MILK);
		} else {
			int resultat = 0;
			if (dim <= PEAK_MILK)
			
			
			dim++;
			return resultat;
		}
	}
	
	/**
	 * Getter de DaysLeftinMilk
	 * @param dim 
	 * @return
	 */
	public default int getDaysLeftInMilk(int dim) {
		int DaysLeftInMilk = MAX_DIM - dim;
		return DaysLeftInMilk;
	}

	
}