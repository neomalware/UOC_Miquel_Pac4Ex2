package edu.uoc.pac4.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import edu.uoc.pac4.Animal;
import edu.uoc.pac4.AnimalException;
import edu.uoc.pac4.Gender;
import edu.uoc.pac4.Hen;
import edu.uoc.pac4.KomodoDragon;

@TestInstance(Lifecycle.PER_CLASS)

class AnimalTest {

	Animal animal;
	
	@BeforeAll
	void testAnimal() {
		try {
			animal = new Hen("Turuleca",2020,14.6);			
		} catch (Exception e) {
			e.printStackTrace();
			fail("testAnimal failed");
		}
	}
	
	@Test
	void testGetId() {
		assertEquals(0,animal.getId());		
	}
	
	@Test
	void testSetId() {
		assertEquals(0,animal.getId());
		
	  try{ 
		  Animal animal2 = new Hen("Pico pico",2019,20.5); 
		  assertEquals(1,animal2.getId());
		  assertEquals(2,Animal.nextId); 
		  Animal.nextId = 5; 
		  Animal animal3 = new Hen("Pio",2018,30); 
		  assertEquals(5,animal3.getId()); 
		  assertEquals(6,Animal.nextId); 
	  }catch (Exception e) { 
		  e.printStackTrace(); 
		  fail("testSetId failed"); 
	  }		 
	}
	
	@Test
	void testGetName() {
		assertEquals("Turuleca",animal.getName());
	}
	
	@Test
	void testSetName() {
		animal.setName("Bobby");
		assertEquals("Bobby",animal.getName());
		animal.setName("Polly");
		assertEquals("Polly",animal.getName());		
	}
	
	@Test
	void testGetYearBirth() {
		assertEquals(2020,animal.getYearBirth());
	}
	
	@Test
	void testSetYearBirth() {
		int currentYear = LocalDate.now().getYear();
		
		try {
			animal.setYearBirth(currentYear-1);
			assertEquals(currentYear-1,animal.getYearBirth());
		} catch (AnimalException e) {			
			e.printStackTrace();
			fail("testSetYearBirth - Case 1 failed");
		}
							
		Exception ex = assertThrows(Exception.class, () -> animal.setYearBirth(currentYear+20));
		assertEquals(AnimalException.MSG_ERR_YEAR_BIRTH,ex.getMessage());
		assertEquals(currentYear-1,animal.getYearBirth());
				
		try {
			animal.setYearBirth(currentYear);
			assertEquals(currentYear,animal.getYearBirth());
			animal.setYearBirth(2000);
			assertEquals(2000,animal.getYearBirth());
		} catch (AnimalException e) {			
			e.printStackTrace();
			fail("testSetYearBirth - Case 3 failed");
		}
		
	}
	
	@Test
	void testGetWeight() {		
		assertEquals(0.1,animal.getWeight());
	}
	
	@Test
	void testSetWeight() {
		double weight = 67.8;
		
		try {
			animal.setWeight(weight);
			assertEquals(weight,animal.getWeight());
		} catch (AnimalException e) {			
			e.printStackTrace();
			fail("testSetWeight - Case 1 failed");
		}
							
		Exception ex = assertThrows(Exception.class, () -> animal.setWeight(0));
		assertEquals(AnimalException.MSG_ERR_WEIGTH,ex.getMessage());
		assertEquals(weight,animal.getWeight());
				
		try {
			weight += 20;
			animal.setWeight(weight);
			assertEquals(weight,animal.getWeight());
			animal.setWeight(0.1);
			assertEquals(0.1,animal.getWeight());
		} catch (AnimalException e) {			
			e.printStackTrace();
			fail("testSetWeight - Case 3 failed");
		}
	}
	
	@Test
	void testGetGender() {
		assertEquals(Gender.FEMALE,animal.getGender());
	}
	
	@Test
	void testSetGender() {
		KomodoDragon dragon;
		
		try {
			dragon = new KomodoDragon("Epi", 2013, 700, Gender.MALE);
			assertEquals(Gender.MALE,dragon.getGender());
			
			dragon.setGender(Gender.UNDEFINED);
			assertEquals(Gender.UNDEFINED,dragon.getGender());	
			
			dragon.setGender(Gender.MALE);
			assertEquals(Gender.MALE,dragon.getGender());
			
			dragon.setGender(Gender.FEMALE);
			assertEquals(Gender.FEMALE,dragon.getGender());
		} catch (AnimalException e) {			
			e.printStackTrace();
			fail("testSetGender failed");
		}		
	}
	
	@Test
	void testEquals() {
		Animal animal2 = animal, animal3;
		assertEquals(true,animal.equals(animal));
		assertEquals(true,animal2.equals(animal2));
		assertEquals(true,animal.equals(animal2));
		assertEquals(true,animal2.equals(animal));
				
		try {
			animal3 = new Hen("Turuleca",2020,14.6);
			assertEquals(true,animal3.equals(animal3));
			assertEquals(true,animal.equals(animal3));			
			assertEquals(true,animal2.equals(animal3));
		} catch (AnimalException e) {			
			e.printStackTrace();
			fail("testEquals failed");
		}				
	}	
	
	@Test
	void testToString() {
		assertEquals("My name is Turuleca and I'm 0 years old.\nMy gender is FEMALE and my weight is 14.6 kg.\nI'm a hen.",animal.toString());
	}
	
	@Test
	void testGetEnergy() {
		assertEquals(80,animal.getEnergy());
	}	
	
	@Test
	void testCompareTo() {
		Animal [] animals = new Animal[4];
		animals[0] = animal;
		
		try {
			Animal komodo = new KomodoDragon("Epi", 2013, 700, Gender.MALE);
			Animal hen1 = new Hen("Pico pico",2019,20.5);
			Animal hen2 = new Hen("Paco",2019,30.5);
			animals[1] = komodo;
			animals[2] = hen1;
			animals[3] = hen2;
			
			Arrays.sort(animals);
						
			assertArrayEquals(new Animal[]{animal,hen2,hen1,komodo},animals);
			
			
		} catch (AnimalException e) {
			e.printStackTrace();
			fail("testCompareTo failed");
		}	
	}
}
