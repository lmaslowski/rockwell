package com.kata.rockwell.divisor.application;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class MappedDivisorsOutputTest {

    @Test
    void shouldBeCreated() {
        final HashMap<Number, List<String>> expected = new HashMap<>();
        expected.put(1, List.of("Mouse"));
        expected.put(2, List.of("Mouse", "Cat"));
        expected.put(4, List.of("Mouse", "Cat", "Elephant"));

        final MappedDivisorsOutput mappedDivisorsOutput = MappedDivisorsOutput
                .builder()
                .build();

        mappedDivisorsOutput.put(1, List.of("Mouse"));
        mappedDivisorsOutput.put(2, List.of("Mouse", "Cat"));
        mappedDivisorsOutput.put(4, List.of("Mouse", "Cat", "Elephant"));

        assertEquals(expected, mappedDivisorsOutput.getResponse());
    }
}
