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
import edu.uoc.pac4.Goat;
import edu.uoc.pac4.Gender;
import edu.uoc.pac4.Milkable;

@TestInstance(Lifecycle.PER_CLASS)

class GoatTest {

	Goat goat;
	private ByteArrayOutputStream outContent;

	@BeforeAll
	void testgoat() {
		try {
			goat = new Goat("Whiteball",2015,39.5);
		} catch (AnimalException e) {			
			e.printStackTrace();
			fail("testgoat failed");
		}
	}
	
	@Test
	void testGetPeakMilk() {
		assertEquals(80,goat.getPeakMilk()); 
	}
	
	@Test
	void testGetDaysInMilk() {
		goat.setDaysInMilk(0);
		assertTrue(goat.getDaysInMilk()==0);
	}
	
	@Test
	void testSetDaysInMilk() {		
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> goat.setDaysInMilk(302));
		assertEquals(Milkable.MSG_ERR_DAYS_IN_MILK_GREATER,ex.getMessage());
		
		ex = assertThrows(IllegalArgumentException.class, () -> goat.setDaysInMilk(-302));
		assertEquals(Milkable.MSG_ERR_DAYS_IN_MILK_NEGATIVE,ex.getMessage());
		
		goat.setDaysInMilk(0);
		assertTrue(goat.getDaysInMilk()==0);
	}
	
	@Test
	void testGetMaxMilkPerDay() {
		assertEquals(6,goat.getMaxMilkPerDay());
	}
	
	@Test
	void testSetMaxMilkPerDay() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> goat.setMaxMilkPerDay(-13));
		assertEquals(Milkable.MSG_ERR_MAX_LITERS_PER_DAYS_NEGATIVE,ex.getMessage());
		
		goat.setDaysInMilk(10);
		assertTrue(goat.getDaysInMilk()==10);
		
		goat.setDaysInMilk(0);
		assertTrue(goat.getDaysInMilk()==0);
	}
	
	@Test
	void testEat() {
		Food steak = new Food("steak",20,FoodType.MEAT);		
		AnimalException ex = assertThrows(AnimalException.class, () -> goat.eat(steak));
		assertEquals(AnimalException.MSG_ERR_HERBIVORE_FOOD,ex.getMessage());
		
		Food plant = new Food("bush",15,FoodType.PLANT);		
		try{
			goat.eat(plant);
			assertEquals(81.5,goat.getEnergy());
		}catch(AnimalException e) {
			fail("testEat failed");
		}
	}
	
	@Test
	void testMakeNoise() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		goat.makeNoise();
		assertEquals("Beeeeee!!!", outContent.toString().replaceAll("\n|\r\n", System.getProperty("line.separator").trim()));
	}	
	
	@Test
	void testSetGender() {
		assertEquals(Gender.FEMALE,goat.getGender());
		goat.setGender(Gender.MALE);
		assertEquals(Gender.FEMALE,goat.getGender());
		goat.setGender(Gender.UNDEFINED);
		assertEquals(Gender.FEMALE,goat.getGender());
		goat.setGender(Gender.FEMALE);
		assertEquals(Gender.FEMALE,goat.getGender());
	}

	@Test
	void testToString() {
		outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    System.out.print(goat);
	    assertEquals("My name is Whiteball and I'm 5 years old.\nMy gender is FEMALE and my weight is 39.5 kg.\nI'm a goat.", outContent.toString());
	}

	@Test
	void testMilk() {
		double milkLiters;
		try {		
			goat.setDaysInMilk(0);
			milkLiters = goat.milk();			
			assertTrue(milkLiters>=goat.getMaxMilkPerDay()*0.75 && milkLiters<goat.getMaxMilkPerDay());
			
			goat.setDaysInMilk(10);
			milkLiters = goat.milk();
			assertTrue(milkLiters>=goat.getMaxMilkPerDay()*0.75 && milkLiters<goat.getMaxMilkPerDay());
			
			goat.setDaysInMilk(190);
			milkLiters = goat.milk();
			assertTrue(milkLiters>=0 &&  milkLiters<goat.getMaxMilkPerDay()*0.5);
			
			goat.setDaysInMilk(290);
			milkLiters = goat.milk();
			assertTrue(milkLiters>=0 &&  milkLiters<goat.getMaxMilkPerDay()*0.5);
			
			goat.setDaysInMilk(299);
			milkLiters = goat.milk();
			assertTrue(milkLiters>=0 &&  milkLiters<goat.getMaxMilkPerDay()*0.5);
			
			goat.setDaysInMilk(300);
			Exception ex = assertThrows(Exception.class, () -> goat.milk());
			assertEquals(Milkable.MSG_ERR_NO_MILK,ex.getMessage());			
			
		} catch (AnimalException e) {
			e.printStackTrace();
			fail("testMilk failed");
		}
	}
}
