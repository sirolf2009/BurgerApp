package com.sirolf2009.burgerapp.burgers;

import java.util.Arrays;
import java.util.Collections;

import com.sirolf2009.burgerapp.model.Addition;
import com.sirolf2009.burgerapp.model.BreadType;
import com.sirolf2009.burgerapp.model.MeatType;

public class ComboBurger extends Burger {

	public ComboBurger(MeatType meat, BreadType bread) {
		super(meat, bread, 2.5, Collections.emptySet(), Arrays.asList(Addition.COLA, Addition.FRIES));
	}

}
