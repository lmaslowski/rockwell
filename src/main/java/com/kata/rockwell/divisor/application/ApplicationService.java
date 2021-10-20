package com.kata.rockwell.divisor.application;

import com.kata.rockwell.divisor.domain.model.CompositeMapper;
import com.kata.rockwell.divisor.domain.model.NumberService;
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
        throwExceptionIfNumbersAreOutOfRange(input);
        return getMappedDivisorsOutput(input.getName(), input.getNumbers());
    }

    private MappedDivisorsOutput getMappedDivisorsOutput(String name, List<Integer> numbers) {
        final MappedDivisorsOutput output = MappedDivisorsOutput.builder().build();
        numbers.forEach(n -> output.put(n,
                numberService.findAllDivisors(n)
                .stream()
                .map(d -> compositeMapper.map(name, d))
                .collect(Collectors.toList())
        ));
        return output;
    }

    private void throwExceptionIfNumbersAreOutOfRange(MappedDivisorsInput mappedDivisorsInput) {
        if(mappedDivisorsInput.getNumbers().stream().anyMatch(number -> number > 20 || number < 1)) {
            throw new IllegalArgumentException("Numbers should be in range from 1 to 20!");
        }
    }
}
