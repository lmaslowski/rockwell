package com.kata.rockwell.divisor.adapter.mappers.inmemory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class InmemoryMappingConfig {

    @Bean
    @Qualifier("animals")
    public Map<Integer, String> mapToAnimals() {
        return new HashMap<>() {{
            put(1, "Mouse");
            put(2, "Cat");
            put(3, "Dog");
            put(4, "Elephant");
        }};
    }

    @Bean
    @Qualifier("furnitures")
    public Map<Integer, String> mapToFurnitures() {
        return new HashMap<>() {{
            put(1, "Chair");
            put(2, "Table");
            put(3, "Cabinet");
            put(4, "Bed");
        }};
    }

}
