package com.sirolf2009.burgerapp;

import static com.sirolf2009.burgerapp.model.BreadType.WHOLEGRAIN;
import static com.sirolf2009.burgerapp.model.MeatType.BLACK_ANGUS_PATTY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sirolf2009.burgerapp.burgers.ComboBurger;
import com.sirolf2009.burgerapp.exception.TooManyToppings;

public class ComboBurgerTest {
	
	@Test
	public void testBasicBurgerPrice() throws TooManyToppings {
		ComboBurger emptyBurger = new ComboBurger(BLACK_ANGUS_PATTY, WHOLEGRAIN);
		
		assertEquals(emptyBurger.getBaseCost(), emptyBurger.getCost());
		assertEquals(2.5, emptyBurger.getCost());
	}

}
