package com.sirolf2009.burgerapp.model;

public enum Toppings {
	CHEESE(1), KETCHUP(0.1), MAYONAISSE(0.1), CURRY(0.2), MUSTARD(0.2), LETTUCE(0.2), TOMATO(0.5), ONION(0.5);
	
	private final double cost;
	
	private Toppings(double cost) {
		this.cost = cost;
	}

	public double getCost() {
		return cost;
	}
}
