package edu.uoc.pac4.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import edu.uoc.pac4.AnimalException;
import edu.uoc.pac4.Elephant;
import edu.uoc.pac4.Food;
import edu.uoc.pac4.FoodType;
import edu.uoc.pac4.Gender;

@TestInstance(Lifecycle.PER_CLASS)

class ElephantTest {

	Elephant elephant;
	private ByteArrayOutputStream outContent;	
	

	@BeforeAll
	void testElephant() {
		try {
			elephant = new Elephant("Dumbo",2010,5000.18,Gender.MALE);
		} catch (AnimalException e) {			
			e.printStackTrace();
			fail("testElephant failed");
		}		
	}
	
	@Test
	void testEat() {
		Food steak = new Food("steak",20,FoodType.MEAT);		
		AnimalException ex = assertThrows(AnimalException.class, () -> elephant.eat(steak));
		assertEquals(AnimalException.MSG_ERR_HERBIVORE_FOOD,ex.getMessage());
		
		Food plant = new Food("bush",10,FoodType.PLANT);		
		try{
			elephant.eat(plant);
			assertEquals(81,elephant.getEnergy());
		}catch(AnimalException e) {
			fail("testEat failed");
		}
	}
	
	@Test
	void testToString() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    System.out.print(elephant);
	    assertEquals("My name is Dumbo and I'm 10 years old.\nMy gender is MALE and my weight is 5000.18 kg.\nI'm an elephant.", outContent.toString());
	}

	@Test
	void testMakeNoise() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		elephant.makeNoise();
		assertEquals("Brrrrr!!!", outContent.toString().replaceAll("\n|\r\n", System.getProperty("line.separator").trim()));
	}
}
