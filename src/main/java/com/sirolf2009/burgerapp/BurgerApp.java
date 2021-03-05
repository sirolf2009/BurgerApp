package com.sirolf2009.burgerapp;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

import com.sirolf2009.burgerapp.burgers.BasicBurger;
import com.sirolf2009.burgerapp.burgers.ComboBurger;
import com.sirolf2009.burgerapp.burgers.HealthyBurger;
import com.sirolf2009.burgerapp.model.BreadType;
import com.sirolf2009.burgerapp.model.MeatType;
import com.sirolf2009.burgerapp.model.Toppings;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "burger", mixinStandardHelpOptions = true, version = "Burger 0.1",
description = "Prints a recipt for a given burger")
public class BurgerApp implements Callable<Integer> {

	@Option(names = {"-bt", "--burger"}, description = "Burger type (basic, combo, healthy)")
    private String burger = "";
	
	@Option(names = {"-t", "--topping"}, description = "Toppings")
    private Set<Toppings> toppings;
	
	@Option(names = {"-m", "--meat"}, description = "Meat")
    private MeatType meat;
	
	@Option(names = {"-b", "--bread"}, description = "Bread")
    private BreadType bread;

	@Override
	public Integer call() throws Exception {
		switch (burger) {
		case "basic":
			System.out.println(new BasicBurger(meat, bread, toppings).receipt());
			break;
		case "combo":
			System.out.println(new ComboBurger(meat, bread).receipt());
			break;
		case "healthy":
			System.out.println(new HealthyBurger(meat, bread, toppings).receipt());
			break;
		default:
			System.err.println("Missing -bt argument");
			return 1;
		}
		return 0;
	}
	
	/**
	 * example args: -bt basic -t CHEESE -t ONION -t KETCHUP -t CURRY -m BLACK_ANGUS_PATTY -b WHOLEGRAIN
	 * @param args
	 */
	public static void main(String... args) {
        int exitCode = new CommandLine(new BurgerApp()).execute(args);
        System.exit(exitCode);
    }

}
