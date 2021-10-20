package com.kata.rockwell.divisor.domain.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

@Service
@Primary
public class StreamNumberService implements NumberService {

    public List<Integer> findAllDivisors(Integer number) {
        return rangeClosed(1, number)
                .filter(i -> number % i == 0)
                .boxed()
                .collect(toList());
    }

}
