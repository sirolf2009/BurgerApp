package com.sirolf2009.burgerapp.burgers;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.sirolf2009.burgerapp.model.Addition;
import com.sirolf2009.burgerapp.model.BreadType;
import com.sirolf2009.burgerapp.model.MeatType;
import com.sirolf2009.burgerapp.model.Toppings;

public abstract class Burger {
	
	private final MeatType meat;
	private final BreadType bread;
	private final double baseCost;
	private final Set<Toppings> toppings;
	private final List<Addition> additions;
	
	public Burger(MeatType meat, BreadType bread, double baseCost, Set<Toppings> toppings) {
		this(meat, bread, baseCost, toppings, Collections.emptyList());
	}
	
	public Burger(MeatType meat, BreadType bread, double baseCost, Set<Toppings> toppings, List<Addition> additions) {
		this.meat = meat;
		this.bread = bread;
		this.baseCost = baseCost;
		this.toppings = toppings;
		this.additions = additions;
	}
	
	public String receipt() {
		NumberFormat price = NumberFormat.getCurrencyInstance();
		StringBuilder str = new StringBuilder();
		
		str.append("=== Burger ===\n");
		str.append(this.getClass().asSubclass(this.getClass()).getSimpleName()+"\t"+price.format(baseCost)+"\n");
		toppings.stream().sorted((a,b) -> a.name().compareTo(b.name())).forEach(topping -> {
			str.append("+ "+topping.name().toLowerCase()+"\t"+price.format(topping.getCost())+"\n");
		});
		str.append("Burger Total = "+price.format(baseCost+getToppingCost())+"\n");
		
		str.append("=== Additions ===\n");
		additions.stream().sorted((a,b) -> a.name().compareTo(b.name())).forEach(addition -> {
			str.append("+"+addition.name().toLowerCase()+"\t"+price.format(addition.getCost())+"\n");
		});
		
		str.append("=== Total ===\n");
		str.append(price.format(getCost()));
		return str.toString();
	}
	
	public double getCost() {
		return baseCost + getToppingCost() + getAdditionCost();
	}
	
	public double getToppingCost() {
		return toppings.stream().mapToDouble(topping -> topping.getCost()).sum();
	}
	
	public double getAdditionCost() {
		return additions.stream().mapToDouble(addition -> addition.getCost()).sum();
	}

	public MeatType getMeat() {
		return meat;
	}

	public BreadType getBread() {
		return bread;
	}

	public double getBaseCost() {
		return baseCost;
	}

	public Set<Toppings> getToppings() {
		return toppings;
	}
	
	public List<Addition> getAdditions() {
		return additions;
	}

}
