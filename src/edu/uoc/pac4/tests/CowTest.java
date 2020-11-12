package edu.uoc.pac4.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import edu.uoc.pac4.AnimalException;
import edu.uoc.pac4.Cow;
import edu.uoc.pac4.Food;
import edu.uoc.pac4.FoodType;
import edu.uoc.pac4.Gender;
import edu.uoc.pac4.Milkable;

@TestInstance(Lifecycle.PER_CLASS)

class CowTest {
	
	Cow cow;
	private ByteArrayOutputStream outContent;

	@BeforeAll
	void testCow() {
		try {
			cow = new Cow("Tarunca",2018,720.1);
		} catch (AnimalException e) {			
			e.printStackTrace();
			fail("testCow failed");
		}
	}
	
	@Test
	void testGetPeakMilk() {
		assertEquals(90,cow.getPeakMilk()); 
	}
	
	@Test
	void testGetDaysInMilk() {
		cow.setDaysInMilk(0);
		assertTrue(cow.getDaysInMilk()==0);
	}
	
	@Test
	void testSetDaysInMilk() {		
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> cow.setDaysInMilk(302));
		assertEquals(Milkable.MSG_ERR_DAYS_IN_MILK_GREATER,ex.getMessage());
		
		ex = assertThrows(IllegalArgumentException.class, () -> cow.setDaysInMilk(-302));
		assertEquals(Milkable.MSG_ERR_DAYS_IN_MILK_NEGATIVE,ex.getMessage());
		
		cow.setDaysInMilk(0);
		assertTrue(cow.getDaysInMilk()==0);
	}
	
	@Test
	void testGetMaxMilkPerDay() {
		assertEquals(35,cow.getMaxMilkPerDay());
	}
	
	@Test
	void testSetMaxMilkPerDay() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> cow.setMaxMilkPerDay(-13));
		assertEquals(Milkable.MSG_ERR_MAX_LITERS_PER_DAYS_NEGATIVE,ex.getMessage());
		
		cow.setDaysInMilk(10);
		assertTrue(cow.getDaysInMilk()==10);
		
		cow.setDaysInMilk(0);
		assertTrue(cow.getDaysInMilk()==0);
	}
	
	@Test
	void testEat() {
		Food steak = new Food("steak",20,FoodType.MEAT);		
		AnimalException ex = assertThrows(AnimalException.class, () -> cow.eat(steak));
		assertEquals(AnimalException.MSG_ERR_HERBIVORE_FOOD,ex.getMessage());
		
		Food plant = new Food("bush",10,FoodType.PLANT);		
		try{
			cow.eat(plant);
			assertEquals(81,cow.getEnergy());
		}catch(AnimalException e) {
			fail("testEat failed");
		}
	}
	
	@Test
	void testMakeNoise() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		cow.makeNoise();
		assertEquals("Muuuuuu!!!", outContent.toString().replaceAll("\n|\r\n", System.getProperty("line.separator").trim()));
	}
	
	@Test
	void testMakeNoiseInt() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		cow.makeNoise(3);
		assertEquals("Muuuuuu!!!Muuuuuu!!!Muuuuuu!!!", outContent.toString().replaceAll("\n|\r\n", System.getProperty("line.separator").trim()));
	}

	
	@Test
	void testSetGender() {
		assertEquals(Gender.FEMALE,cow.getGender());
		cow.setGender(Gender.MALE);
		assertEquals(Gender.FEMALE,cow.getGender());
		cow.setGender(Gender.UNDEFINED);
		assertEquals(Gender.FEMALE,cow.getGender());
		cow.setGender(Gender.FEMALE);
		assertEquals(Gender.FEMALE,cow.getGender());
	}

	@Test
	void testToString() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    System.out.print(cow);
	    assertEquals("My name is Tarunca and I'm 2 years old.\nMy gender is FEMALE and my weight is 720.1 kg.\nI'm a cow.", outContent.toString());
	}

	

	@Test
	void testMilk() {
		double milkLiters;
		try {					
			cow.setDaysInMilk(0);
			milkLiters = cow.milk();			
			assertTrue(milkLiters>=cow.getMaxMilkPerDay()*0.75 && milkLiters<cow.getMaxMilkPerDay());
			
			cow.setDaysInMilk(10);
			milkLiters = cow.milk();
			assertTrue(milkLiters>=cow.getMaxMilkPerDay()*0.75 && milkLiters<cow.getMaxMilkPerDay());
			
			cow.setDaysInMilk(190);
			milkLiters = cow.milk();
			assertTrue(milkLiters>=0 &&  milkLiters<cow.getMaxMilkPerDay()*0.5);
			
			cow.setDaysInMilk(290);
			milkLiters = cow.milk();
			assertTrue(milkLiters>=0 &&  milkLiters<cow.getMaxMilkPerDay()*0.5);
			
			cow.setDaysInMilk(299);
			milkLiters = cow.milk();
			assertTrue(milkLiters>=0 &&  milkLiters<cow.getMaxMilkPerDay()*0.5);
			
			cow.setDaysInMilk(300);
			Exception ex = assertThrows(Exception.class, () -> cow.milk());
			assertEquals(Milkable.MSG_ERR_NO_MILK,ex.getMessage());			
			
		} catch (AnimalException e) {
			e.printStackTrace();
			fail("testMilk failed");
		}
	}
}
