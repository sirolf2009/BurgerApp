package com.sirolf2009.burgerapp.burgers;

import java.util.Set;

import com.sirolf2009.burgerapp.exception.TooManyToppings;
import com.sirolf2009.burgerapp.model.BreadType;
import com.sirolf2009.burgerapp.model.MeatType;
import com.sirolf2009.burgerapp.model.Toppings;

public class HealthyBurger extends Burger {

	public HealthyBurger(MeatType meat, BreadType bread, Set<Toppings> toppings) throws TooManyToppings {
		super(meat, bread, 3, toppings);
		if(toppings.size() > 6) {
			throw new TooManyToppings(this, 6);
		}
	}

}
