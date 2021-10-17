package com.kata.rockwell.domain.model;

import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

@Service
public class RecursionNumberService implements NumberService {

    public List<Number> findAllDivisors(Number number) {
        return rangeClosed(1, (int) number)
                .filter(i -> ((int) number) % i == 0)
                .boxed()
                .collect(toList());
    }

}
