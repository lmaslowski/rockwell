package com.kata.rockwell.divisor.adapter.mappers.db;

import com.kata.rockwell.divisor.domain.model.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("cars")
@AllArgsConstructor
class CarsMapper implements Mapper {

    private final SpringJpaCarRepository repository;

    @Override
    public String map(Integer number) {
        return repository.findById(number).map(Car::getName).orElse("not mapped");
    }
}
