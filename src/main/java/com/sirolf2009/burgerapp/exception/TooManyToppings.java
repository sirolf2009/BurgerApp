package com.sirolf2009.burgerapp.exception;

import com.sirolf2009.burgerapp.burgers.Burger;

public class TooManyToppings extends Exception{

	private static final long serialVersionUID = -4190977201157575899L;
	
	private final Burger burger;
	private final int max;
	
	public TooManyToppings(Burger burger, int max) {
		super("Too many toppings in burger. You have: "+burger.getToppings().size()+". Max: "+max);
		this.burger = burger;
		this.max = max;
	}

	public Burger getBurger() {
		return burger;
	}

	public int getMax() {
		return max;
	}

}
