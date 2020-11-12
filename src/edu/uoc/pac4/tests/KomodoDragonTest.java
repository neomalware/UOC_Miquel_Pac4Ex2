package edu.uoc.pac4.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import edu.uoc.pac4.AnimalException;
import edu.uoc.pac4.Food;
import edu.uoc.pac4.FoodType;
import edu.uoc.pac4.Gender;
import edu.uoc.pac4.KomodoDragon;

@TestInstance(Lifecycle.PER_CLASS)

class KomodoDragonTest {

	KomodoDragon komodo;
	private ByteArrayOutputStream outContent;	

	
	@BeforeAll
	void testKomodoDragon() {
		try {
			komodo = new KomodoDragon("Dave",2015,120.8,Gender.FEMALE);
		} catch (AnimalException e) {			
			e.printStackTrace();
			fail("testElephant failed");
		}
	}
	
	@Test
	void testEat() {
		Food plant = new Food("bush",10,FoodType.PLANT);		
		AnimalException ex = assertThrows(AnimalException.class, () -> komodo.eat(plant));
		assertEquals(AnimalException.MSG_ERR_CARNIVORE_FOOD,ex.getMessage());
		
		Food steak = new Food("steak",20,FoodType.MEAT);		
		try{
			komodo.eat(steak);
			assertEquals(84,komodo.getEnergy());
		}catch(AnimalException e) {
			fail("testEat failed");
		}
	}
	
	@Test
	void testMakeNoise() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    komodo.makeNoise();
		assertEquals("Grrrrr!!!", outContent.toString().replaceAll("\n|\r\n", System.getProperty("line.separator").trim()));
	}
	
	@Test
	void testToString() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    System.out.print(komodo);
	    assertEquals("My name is Dave and I'm 5 years old.\nMy gender is FEMALE and my weight is 120.8 kg.\nI'm a Komodo dragon.", outContent.toString());
	}

}
