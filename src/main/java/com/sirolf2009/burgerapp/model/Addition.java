package com.sirolf2009.burgerapp.model;

public enum Addition {
	FRIES(0), COLA(0);
	
	private final double cost;
	
	private Addition(double cost) {
		this.cost = cost;
	}

	public double getCost() {
		return cost;
	}
}
