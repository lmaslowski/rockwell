package com.kata.rockwell.application.mappers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MappingConfig {

    @Bean
    @Qualifier("animals")
    public Map<Number, String> mapToAnimals() {
        return new HashMap<>() {{
            put(1, "Mouse");
            put(2, "Cat");
            put(3, "Dog");
            put(4, "Elephant");
        }};
    }

    @Bean
    @Qualifier("furnitures")
    public Map<Number, String> mapToFurnitures() {
        return new HashMap<>() {{
            put(1, "Chair");
            put(2, "Table");
            put(3, "Cabinet");
            put(4, "Bed");
        }};
    }

}
