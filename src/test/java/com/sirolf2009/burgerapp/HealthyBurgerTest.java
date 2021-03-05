package com.sirolf2009.burgerapp;

import static com.sirolf2009.burgerapp.model.BreadType.WHOLEGRAIN;
import static com.sirolf2009.burgerapp.model.MeatType.BLACK_ANGUS_PATTY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.sirolf2009.burgerapp.burgers.HealthyBurger;
import com.sirolf2009.burgerapp.exception.TooManyToppings;
import com.sirolf2009.burgerapp.model.Toppings;

public class HealthyBurgerTest {
	
	@Test
	public void testHealthyBurgerPrice() throws TooManyToppings {
		HealthyBurger emptyBurger = new HealthyBurger(BLACK_ANGUS_PATTY, WHOLEGRAIN, set());
		
		assertEquals(emptyBurger.getBaseCost(), emptyBurger.getCost());
		assertEquals(3, emptyBurger.getCost());
	}
	
	@Test
	public void testHealthyBurgerToppingPrice() throws TooManyToppings {
		Set<Toppings> toppings = set(Toppings.CHEESE, Toppings.KETCHUP, Toppings.ONION, Toppings.TOMATO);
		HealthyBurger stackedBurger = new HealthyBurger(BLACK_ANGUS_PATTY, WHOLEGRAIN, toppings);
		double expectedToppingsPrice = 	1+0.1+0.5+0.5;
		
		assertEquals(stackedBurger.getToppingCost(), expectedToppingsPrice);
		assertEquals(stackedBurger.getCost(), stackedBurger.getBaseCost() + expectedToppingsPrice);
	}
	
	@Test
	public void testHealthyBurgerMaxTopping() throws TooManyToppings {
		Set<Toppings> justEnoughToppings = set(Toppings.CHEESE, Toppings.KETCHUP, Toppings.ONION, Toppings.TOMATO, Toppings.LETTUCE, Toppings.MUSTARD);
		new HealthyBurger(BLACK_ANGUS_PATTY, WHOLEGRAIN, justEnoughToppings);
		
		Set<Toppings> tooManyToppings = set(Toppings.CHEESE, Toppings.KETCHUP, Toppings.ONION, Toppings.TOMATO, Toppings.LETTUCE, Toppings.MUSTARD, Toppings.MAYONAISSE);
		assertThrows(TooManyToppings.class, () -> new HealthyBurger(BLACK_ANGUS_PATTY, WHOLEGRAIN, tooManyToppings));
	}

	@Test
	public void testHealthyBurgerReceipt() throws TooManyToppings {
		Set<Toppings> toppings = set(Toppings.CHEESE, Toppings.KETCHUP, Toppings.ONION, Toppings.TOMATO);
		HealthyBurger stackedBurger = new HealthyBurger(BLACK_ANGUS_PATTY, WHOLEGRAIN, toppings);
		StringBuilder expectedReceipt = new StringBuilder();
		expectedReceipt.append("=== Burger ===\n");
		expectedReceipt.append("HealthyBurger	€ 3,00\n");
		expectedReceipt.append("+ cheese	€ 1,00\n");
		expectedReceipt.append("+ ketchup	€ 0,10\n");
		expectedReceipt.append("+ onion	€ 0,50\n");
		expectedReceipt.append("+ tomato	€ 0,50\n");
		expectedReceipt.append("Burger Total = € 5,10\n");
		expectedReceipt.append("=== Additions ===\n");
		expectedReceipt.append("=== Total ===\n");
		expectedReceipt.append("€ 5,10");

		assertEquals(expectedReceipt.toString(), stackedBurger.receipt());
	}
	
	private <E> Set<E> set(E... objects) {
		return new HashSet<E>(Arrays.asList(objects));
	}

}
