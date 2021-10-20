package com.kata.rockwell.divisor.application;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MappedDivisorsInputTest {

    @Test
    void shouldBeFailWhenCreated() {
        assertThrows( NullPointerException.class, () -> MappedDivisorsInput.builder().build());
    }

    @Test
    void shouldBeCreated() {
        final MappedDivisorsInput input = MappedDivisorsInput.builder()
                .name("name")
                .numbers(Arrays.asList())
                .build();
        assertNotNull(input);
    }
}
