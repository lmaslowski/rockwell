package com.kata.rockwell.divisor.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@JsonTest
class MappedDivisorsInputTest {

    @Autowired
    private JacksonTester<MappedDivisorsInput> jacksonTester;


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

    @Test
    void shouldSerializeObject() throws IOException {
        final MappedDivisorsInput input = MappedDivisorsInput.builder()
                .name("name")
                .numbers(Arrays.asList(1, 2, 4))
                .build();

        final JsonContent<MappedDivisorsInput> jsonContent = jacksonTester.write(input);

        assertThat(jsonContent).hasJsonPathStringValue("$.name");
        assertThat(jsonContent).extractingJsonPathStringValue("$.name").isEqualTo("name");
        assertThat(jsonContent).extractingJsonPathArrayValue("$.numbers").isEqualTo(Arrays.asList(1, 2, 4));
    }
}
