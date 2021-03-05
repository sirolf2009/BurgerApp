package com.sirolf2009.burgerapp.burgers;

import java.util.Set;

import com.sirolf2009.burgerapp.exception.TooManyToppings;
import com.sirolf2009.burgerapp.model.BreadType;
import com.sirolf2009.burgerapp.model.MeatType;
import com.sirolf2009.burgerapp.model.Toppings;

public class BasicBurger extends Burger {

	public BasicBurger(MeatType meat, BreadType bread, Set<Toppings> toppings) throws TooManyToppings {
		super(meat, bread, 2.5, toppings);
		if(toppings.size() > 4) {
			throw new TooManyToppings(this, 4);
		}
	}

}
