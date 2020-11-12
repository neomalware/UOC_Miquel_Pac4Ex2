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
import edu.uoc.pac4.Hen;

@TestInstance(Lifecycle.PER_CLASS)

class HenTest {

	Hen hen;
	private ByteArrayOutputStream outContent;	
	
	@BeforeAll
	void testHen() {
		try {
			hen = new Hen("Turuleca",2020,50.8);
		} catch (AnimalException e) {			
			e.printStackTrace();
			fail("testHen failed");
		}		
	}
	
	@Test
	void testEat() {
		Food steak = new Food("steak",20,FoodType.MEAT);		
		Food plant = new Food("bush",15,FoodType.PLANT);
		
		try{
			hen.eat(steak);
			assertEquals(83,hen.getEnergy());			
			hen.eat(plant);
			assertEquals(83.75,hen.getEnergy());
		}catch(AnimalException e) {
			fail("testEat failed");
		}
	}
	
	@Test
	void testMakeNoise() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		hen.makeNoise();
		assertEquals("Co-co-co!!!", outContent.toString().replaceAll("\n|\r\n", System.getProperty("line.separator").trim()));
	}
	
	@Test
	void testSetGender() {
		assertEquals(Gender.FEMALE,hen.getGender());
		hen.setGender(Gender.MALE);
		assertEquals(Gender.FEMALE,hen.getGender());
		hen.setGender(Gender.UNDEFINED);
		assertEquals(Gender.FEMALE,hen.getGender());
		hen.setGender(Gender.FEMALE);
		assertEquals(Gender.FEMALE,hen.getGender());
	}

	@Test
	void testToString() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    System.out.print(hen);
	    assertEquals("My name is Turuleca and I'm 0 years old.\nMy gender is FEMALE and my weight is 50.8 kg.\nI'm a hen.", outContent.toString());
	}
}
