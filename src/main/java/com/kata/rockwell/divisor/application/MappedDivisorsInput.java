package com.kata.rockwell.divisor.application;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
public class MappedDivisorsInput {

    @NonNull
    private final List<Integer> numbers;

    @NonNull
    private final String name;
}

