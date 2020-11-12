package edu.uoc.pac4.tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({FoodTest.class, ElephantTest.class, KomodoDragonTest.class, HenTest.class})
class MinimumCheck {
	

}
