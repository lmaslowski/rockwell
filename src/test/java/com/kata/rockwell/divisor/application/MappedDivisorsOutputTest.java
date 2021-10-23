package com.kata.rockwell.divisor.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@JsonTest
class MappedDivisorsOutputTest {

    @Autowired
    private JacksonTester<MappedDivisorsOutput> jacksonTester;

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

    @Test
    void shouldSerializeObject() throws IOException {
        final MappedDivisorsOutput mappedDivisorsOutput = MappedDivisorsOutput
                .builder()
                .build();

        mappedDivisorsOutput.put(1, List.of("Mouse"));
        mappedDivisorsOutput.put(2, List.of("Mouse", "Cat"));
        mappedDivisorsOutput.put(4, List.of("Mouse", "Cat", "Elephant"));

        final JsonContent<MappedDivisorsOutput> jsonContent = jacksonTester.write(mappedDivisorsOutput);

        assertThat(jsonContent).extractingJsonPathArrayValue("$.1").isEqualTo(Arrays.asList("Mouse"));
        assertThat(jsonContent).extractingJsonPathArrayValue("$.2").isEqualTo(Arrays.asList("Mouse", "Cat"));
        assertThat(jsonContent).extractingJsonPathArrayValue("$.4").isEqualTo(Arrays.asList("Mouse", "Cat", "Elephant"));
    }
}
