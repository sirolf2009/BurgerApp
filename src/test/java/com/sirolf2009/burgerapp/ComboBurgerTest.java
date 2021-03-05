package com.sirolf2009.burgerapp;

import static com.sirolf2009.burgerapp.model.BreadType.WHOLEGRAIN;
import static com.sirolf2009.burgerapp.model.MeatType.BLACK_ANGUS_PATTY;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

	@Test
	public void testComboBurgerReceipt() {
		ComboBurger stackedBurger = new ComboBurger(BLACK_ANGUS_PATTY, WHOLEGRAIN);
		StringBuilder expectedReceipt = new StringBuilder();
		expectedReceipt.append("=== Burger ===\n");
		expectedReceipt.append("ComboBurger	€ 2,50\n");
		expectedReceipt.append("Burger Total = € 2,50\n");
		expectedReceipt.append("=== Additions ===\n");
		expectedReceipt.append("+cola	€ 0,00\n");
		expectedReceipt.append("+fries	€ 0,00\n");
		expectedReceipt.append("=== Total ===\n");
		expectedReceipt.append("€ 2,50");

		assertEquals(expectedReceipt.toString(), stackedBurger.receipt());
	}

	private <E> Set<E> set(E... objects) {
		return new HashSet<E>(Arrays.asList(objects));
	}

}
