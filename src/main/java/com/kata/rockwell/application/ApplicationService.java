package com.kata.rockwell.application;

import com.kata.rockwell.application.mappers.CompositeMapper;
import com.kata.rockwell.domain.model.NumberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationService {
    private final NumberService numberService;
    private final CompositeMapper compositeMapper;

    public MappedDivisorsOutput findCorrespondingMappedDivisors(MappedDivisorsInput input) {
        final String name = input.getName();
        final List<Number> numbers = input.getNumbers();

        final MappedDivisorsOutput output = MappedDivisorsOutput.builder().build();

        numbers.forEach(n -> {
            output.put(n,
                    numberService.findAllDivisors(n)
                    .stream()
                    .map(d -> compositeMapper.map(name, d))
                    .collect(Collectors.toList())
            );
        });

        return output;
    }
}
