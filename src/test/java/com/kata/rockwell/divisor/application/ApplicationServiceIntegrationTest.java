package com.kata.rockwell.divisor.application;

import com.kata.rockwell.App;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ApplicationServiceIntegrationTest {

    @Autowired
    private ApplicationService applicationService;

    @Test
    void contextLoad() {
        assertNotNull(applicationService);
    }

    @Test
    void givenServiceIsWorking_whenRequestAnimalsAndNumbers124_thenReturnsDivisorResponse() {
        //given
        final List<Integer> numbers = List.of(1, 2, 4);
        final MappedDivisorsInput mappedDivisorsInput =  MappedDivisorsInput.builder()
                .numbers(numbers)
                .name("animals")
                .build();

        final HashMap<Number, List<String>> expectedNumberListHashMap = new HashMap<>();
        expectedNumberListHashMap.put(1, List.of("Mouse"));
        expectedNumberListHashMap.put(2, List.of("Mouse", "Cat"));
        expectedNumberListHashMap.put(4, List.of("Mouse", "Cat", "Elephant"));

        //when
        final MappedDivisorsOutput allDivisors = applicationService.findCorrespondingMappedDivisors(mappedDivisorsInput);

        //then
        assertNotNull(allDivisors);
        assertThat(allDivisors.getResponse()).isEqualTo(expectedNumberListHashMap);
    }

    @Test
    void givenServiceIsWorking_whenRequestAnimalsAndNumbers1_thenReturnsDivisorResponse() {
        //given
        final List<Integer> numbers = List.of(1);
        final MappedDivisorsInput mappedDivisorsInput =  MappedDivisorsInput.builder()
                .numbers(numbers)
                .name("animals")
                .build();

        final HashMap<Number, List<String>> expectedNumberListHashMap = new HashMap<>();
        expectedNumberListHashMap.put(1, List.of("Mouse"));

        //when
        final MappedDivisorsOutput allDivisors = applicationService.findCorrespondingMappedDivisors(mappedDivisorsInput);

        //then
        assertNotNull(allDivisors);
        assertThat(allDivisors.getResponse()).isEqualTo(expectedNumberListHashMap);
    }

    @Test
    void givenServiceIsWorking_whenRequestAnimalsAndNumbers2_thenReturnsDivisorResponse() {
        //given
        final List<Integer> numbers = List.of(2);
        final MappedDivisorsInput mappedDivisorsInput =  MappedDivisorsInput.builder()
                .numbers(numbers)
                .name("animals")
                .build();

        final HashMap<Number, List<String>> expectedNumberListHashMap = new HashMap<>();
        expectedNumberListHashMap.put(2, List.of("Mouse", "Cat"));

        //when
        final MappedDivisorsOutput allDivisors = applicationService.findCorrespondingMappedDivisors(mappedDivisorsInput);

        //then
        assertNotNull(allDivisors);
        assertThat(allDivisors.getResponse()).isEqualTo(expectedNumberListHashMap);
    }

    @Test
    void givenServiceIsWorking_whenRequestAnimalsAndNumbers3_thenReturnsDivisorResponse() {
        //given
        final List<Integer> numbers = List.of(3);
        final MappedDivisorsInput mappedDivisorsInput =  MappedDivisorsInput.builder()
                .numbers(numbers)
                .name("animals")
                .build();

        final HashMap<Number, List<String>> expectedNumberListHashMap = new HashMap<>();
        expectedNumberListHashMap.put(3, List.of("Mouse", "Dog"));

        //when
        final MappedDivisorsOutput allDivisors = applicationService.findCorrespondingMappedDivisors(mappedDivisorsInput);

        //then
        assertNotNull(allDivisors);
        assertThat(allDivisors.getResponse()).isEqualTo(expectedNumberListHashMap);
    }

    @Test
    void givenServiceIsWorking_whenRequestFurnituresAndNumbers124_thenReturnsDivisorResponse() {
        //given
        final List<Integer> numbers = List.of(1, 2, 4);
        final MappedDivisorsInput mappedDivisorsInput =  MappedDivisorsInput.builder()
                .numbers(numbers)
                .name("furnitures")
                .build();

        final HashMap<Number, List<String>> expectedNumberListHashMap = new HashMap<>();
        expectedNumberListHashMap.put(1, List.of("Chair"));
        expectedNumberListHashMap.put(2, List.of("Chair", "Table"));
        expectedNumberListHashMap.put(4, List.of("Chair", "Table", "Bed"));

        //when
        final MappedDivisorsOutput allDivisors = applicationService.findCorrespondingMappedDivisors(mappedDivisorsInput);

        //then
        assertNotNull(allDivisors);
        assertThat(allDivisors.getResponse()).isEqualTo(expectedNumberListHashMap);
    }

    @Test
    void givenServiceIsWorking_whenRequestFurnituresAndNumbers1_thenReturnsDivisorResponse() {
        //given
        final List<Integer> numbers = List.of(1);
        final MappedDivisorsInput mappedDivisorsInput =  MappedDivisorsInput.builder()
                .numbers(numbers)
                .name("furnitures")
                .build();

        final HashMap<Number, List<String>> expectedNumberListHashMap = new HashMap<>();
        expectedNumberListHashMap.put(1, List.of("Chair"));

        //when
        final MappedDivisorsOutput allDivisors = applicationService.findCorrespondingMappedDivisors(mappedDivisorsInput);

        //then
        assertNotNull(allDivisors);
        assertThat(allDivisors.getResponse()).isEqualTo(expectedNumberListHashMap);
    }

    @Test
    void givenServiceIsWorking_whenRequestFurnituresAndNumbers2_thenReturnsDivisorResponse() {
        //given
        final List<Integer> numbers = List.of(2);
        final MappedDivisorsInput mappedDivisorsInput =  MappedDivisorsInput.builder()
                .numbers(numbers)
                .name("furnitures")
                .build();

        final HashMap<Number, List<String>> expectedNumberListHashMap = new HashMap<>();
        expectedNumberListHashMap.put(2, List.of("Chair", "Table"));

        //when
        final MappedDivisorsOutput allDivisors = applicationService.findCorrespondingMappedDivisors(mappedDivisorsInput);

        //then
        assertNotNull(allDivisors);
        assertThat(allDivisors.getResponse()).isEqualTo(expectedNumberListHashMap);
    }

    @Test
    void givenServiceIsWorking_whenRequestFurnituresAndNumbers3_thenReturnsDivisorResponse() {
        //given
        final List<Integer> numbers = List.of(3);
        final MappedDivisorsInput mappedDivisorsInput =  MappedDivisorsInput.builder()
                .numbers(numbers)
                .name("furnitures")
                .build();

        final HashMap<Number, List<String>> expectedNumberListHashMap = new HashMap<>();
        expectedNumberListHashMap.put(3, List.of("Chair", "Cabinet"));

        //when
        final MappedDivisorsOutput allDivisors = applicationService.findCorrespondingMappedDivisors(mappedDivisorsInput);

        //then
        assertNotNull(allDivisors);
        assertThat(allDivisors.getResponse()).isEqualTo(expectedNumberListHashMap);
    }
}
