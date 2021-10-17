package com.kata.rockwell.application;

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
    private final List<Number> numbers;

    @NonNull
    private final String name;
}

