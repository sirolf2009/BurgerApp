package com.sirolf2009.burgerapp.spring;

import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.sirolf2009.burgerapp.burgers.BasicBurger;
import com.sirolf2009.burgerapp.burgers.ComboBurger;
import com.sirolf2009.burgerapp.burgers.HealthyBurger;
import com.sirolf2009.burgerapp.exception.TooManyToppings;
import com.sirolf2009.burgerapp.model.Addition;
import com.sirolf2009.burgerapp.model.BreadType;
import com.sirolf2009.burgerapp.model.MeatType;
import com.sirolf2009.burgerapp.model.Toppings;

@RestController
public class BurgerController {

	@RequestMapping("/basic")
	public String basic(@RequestParam("meat") MeatType meat, @RequestParam("bread") BreadType bread,
			@RequestParam("toppings") Set<Toppings> toppings) throws TooManyToppings, JsonProcessingException {
		return objectMapper().writeValueAsString(new BasicBurger(meat, bread, toppings));
	}

	@RequestMapping("/combo")
	public String combo(@RequestParam("meat") MeatType meat, @RequestParam("bread") BreadType bread) throws TooManyToppings, JsonProcessingException {
		return objectMapper().writeValueAsString(new ComboBurger(meat, bread));
	}

	@RequestMapping("/healthy")
	public String healthy(@RequestParam("meat") MeatType meat, @RequestParam("bread") BreadType bread, @RequestParam("toppings") Set<Toppings> toppings) throws TooManyToppings, JsonProcessingException {
		return objectMapper().writeValueAsString(new HealthyBurger(meat, bread, toppings));
	}

	private ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule("BurgerSerializers", new Version(1, 0, 0, null, null, null));
		module.addSerializer(Toppings.class, new Toppings.ToppingsSerializer());
		module.addSerializer(Addition.class, new Addition.AdditionSerializer());
		mapper.registerModule(module);
		return mapper;
	}

}