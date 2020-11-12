package edu.uoc.pac4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import edu.uoc.pac4.Food;
import edu.uoc.pac4.FoodType;

@TestInstance(Lifecycle.PER_CLASS)

class FoodTest {

	Food food;
	
	@BeforeAll
	void testFood() {
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Food("yum yum",-324,FoodType.PLANT));
		assertEquals("[ERROR] Food's kcal cannot be negative!!",ex.getMessage());
		
		food = new Food("yum yum",324,FoodType.PLANT);
	}

	@Test
	void testGetName() {
		assertEquals("yum yum",food.getName());
	}

	@Test
	void testGetKcal() {
		assertEquals(324,food.getKcal());
	}

	@Test
	void testGetType() {
		assertEquals(FoodType.PLANT,food.getType());
	}

	@Test
	void testToString() {
		assertEquals("yum yum (PLANT): 324 kcal",food.toString());
	}

}
