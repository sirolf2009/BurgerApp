package com.sirolf2009.burgerapp.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public enum Addition {
	FRIES(0), COLA(0);

	private final double cost;

	private Addition(double cost) {
		this.cost = cost;
	}

	public double getCost() {
		return cost;
	}

	public static class AdditionSerializer extends StdSerializer<Addition> {

		private static final long serialVersionUID = 5954294393401388963L;

		public AdditionSerializer() {
			this(null);
		}

		public AdditionSerializer(Class<Addition> t) {
			super(t);
		}

		@Override
		public void serialize(Addition addition, JsonGenerator jsonGenerator, SerializerProvider serializer)
				throws IOException {
			jsonGenerator.writeStartObject();
			jsonGenerator.writeStringField("name", addition.name());
			jsonGenerator.writeNumberField("price", addition.getCost());
			jsonGenerator.writeEndObject();
		}
	}
}
