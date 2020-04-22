package com.example.dataparser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@SpringBootApplication
@PropertySource({
		"classpath:kafka.properties",
		"classpath:twitter.properties"
})
public class DataparserApplication {
	public static void main(String[] args) {
		SpringApplication.run(DataparserApplication.class, args);
	}

	@Bean
	public JsonDeserializer jsonDeserializer() {
		return new JsonDeserializer() {
			@Override
			public Object deserialize(JsonParser p, DeserializationContext context) throws IOException {
				return null;
			}
		};
	}
}
