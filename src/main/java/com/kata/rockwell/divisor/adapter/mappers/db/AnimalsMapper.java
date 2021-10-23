package com.kata.rockwell.divisor.adapter.mappers.db;

import com.kata.rockwell.divisor.domain.model.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service("animals")
@AllArgsConstructor
class AnimalsMapper implements Mapper {

    private final SpringJpaAnimalRepository repository;

    @Override
    public String map(Integer number) {
        return repository.findById(number).map(Animal::getName).orElse("not mapped");
    }
}
