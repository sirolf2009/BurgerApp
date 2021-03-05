package com.sirolf2009.burgerapp.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public enum Toppings {
	CHEESE(1), KETCHUP(0.1), MAYONAISSE(0.1), CURRY(0.2), MUSTARD(0.2), LETTUCE(0.2), TOMATO(0.5), ONION(0.5);
	
	private final double cost;
	
	private Toppings(double cost) {
		this.cost = cost;
	}

	public double getCost() {
		return cost;
	}
	
	public static class ToppingsSerializer extends StdSerializer<Toppings> {
	    
		private static final long serialVersionUID = 5954294393401388963L;

		public ToppingsSerializer() {
	        this(null);
	    }

	    public ToppingsSerializer(Class<Toppings> t) {
	        super(t);
	    }

	    @Override
	    public void serialize(
	      Toppings topping, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
	        jsonGenerator.writeStartObject();
	        jsonGenerator.writeStringField("name", topping.name());
	        jsonGenerator.writeNumberField("price", topping.getCost());
	        jsonGenerator.writeEndObject();
	    }
	}
}
