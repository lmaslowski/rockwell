package com.kata.rockwell.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class NumberServiceTest {

    protected NumberService numberService;

    @BeforeEach
    void before() { numberService = getDivisioningService(); }

    @ParameterizedTest
    @MethodSource("provideFindAllDivisorsArguments")
    void givenNumber_returnsAllDivisors(int n, List<Integer> e) {
        assertEquals(e, numberService.findAllDivisors(n));
    }

    private static Stream<Arguments> provideFindAllDivisorsArguments() {
        return Stream.of(
                Arguments.of(4, List.of(1, 2, 4)),
                Arguments.of(5, List.of(1, 5)),
                Arguments.of(6, List.of(1, 2, 3, 6)),
                Arguments.of(10, List.of(1, 2, 5, 10))
        );
    }

    abstract NumberService getDivisioningService();
}
