package com.sirolf2009.burgerapp;

import static com.sirolf2009.burgerapp.model.BreadType.WHOLEGRAIN;
import static com.sirolf2009.burgerapp.model.MeatType.BLACK_ANGUS_PATTY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.sirolf2009.burgerapp.burgers.BasicBurger;
import com.sirolf2009.burgerapp.exception.TooManyToppings;
import com.sirolf2009.burgerapp.model.Toppings;

public class BasicBurgerTest {
	
	@Test
	public void testBasicBurgerPrice() throws TooManyToppings {
		BasicBurger emptyBurger = new BasicBurger(BLACK_ANGUS_PATTY, WHOLEGRAIN, set());
		
		assertEquals(emptyBurger.getBaseCost(), emptyBurger.getCost());
		assertEquals(2.5, emptyBurger.getCost());
	}
	
	@Test
	public void testBasicBurgerToppingPrice() throws TooManyToppings {
		Set<Toppings> toppings = set(Toppings.CHEESE, Toppings.KETCHUP, Toppings.ONION, Toppings.TOMATO);
		BasicBurger stackedBurger = new BasicBurger(BLACK_ANGUS_PATTY, WHOLEGRAIN, toppings);
		double expectedToppingsPrice = 	1+0.1+0.5+0.5;
		
		assertEquals(stackedBurger.getToppingCost(), expectedToppingsPrice);
		assertEquals(stackedBurger.getCost(), stackedBurger.getBaseCost() + expectedToppingsPrice);
	}
	
	@Test
	public void testBasicBurgerMaxTopping() throws TooManyToppings {
		Set<Toppings> justEnoughToppings = set(Toppings.CHEESE, Toppings.KETCHUP, Toppings.ONION, Toppings.TOMATO);
		new BasicBurger(BLACK_ANGUS_PATTY, WHOLEGRAIN, justEnoughToppings);
		
		Set<Toppings> tooManyToppings = set(Toppings.CHEESE, Toppings.KETCHUP, Toppings.ONION, Toppings.TOMATO, Toppings.LETTUCE, Toppings.MUSTARD);
		assertThrows(TooManyToppings.class, () -> new BasicBurger(BLACK_ANGUS_PATTY, WHOLEGRAIN, tooManyToppings));
	}
	
	@Test
	public void testBasicBurgerReceipt() throws TooManyToppings {
		Set<Toppings> toppings = set(Toppings.CHEESE, Toppings.KETCHUP, Toppings.ONION, Toppings.TOMATO);
		BasicBurger stackedBurger = new BasicBurger(BLACK_ANGUS_PATTY, WHOLEGRAIN, toppings);
		StringBuilder expectedReceipt = new StringBuilder();
		expectedReceipt.append("=== Burger ===\n");
		expectedReceipt.append("BasicBurger	€ 2,50\n");
		expectedReceipt.append("+ cheese	€ 1,00\n");
		expectedReceipt.append("+ ketchup	€ 0,10\n");
		expectedReceipt.append("+ onion	€ 0,50\n");
		expectedReceipt.append("+ tomato	€ 0,50\n");
		expectedReceipt.append("Burger Total = € 4,60\n");
		expectedReceipt.append("=== Additions ===\n");
		expectedReceipt.append("=== Total ===\n");
		expectedReceipt.append("€ 4,60");

		assertEquals(expectedReceipt.toString(), stackedBurger.receipt());
	}
	
	private <E> Set<E> set(E... objects) {
		return new HashSet<E>(Arrays.asList(objects));
	}

}
