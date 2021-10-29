package com.kata.rockwell.divisor.adapter.mappers.db;

import com.kata.rockwell.divisor.DivisorConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ContextConfiguration(classes = {DivisorConfig.class})
class CarsMapperTests {

    @Autowired
    private CarsMapper carsMapper;

    @Autowired
    private SpringJpaCarRepository springJpaCarRepository;

    @Autowired
    private SpringJpaAnimalRepository springJpaAnimalRepository;

    @Test
    void contextLoad() {
        assertNotNull(carsMapper);
        assertNotNull(springJpaCarRepository);
        assertNotNull(springJpaAnimalRepository);
    }

    @Test
    void map() {
        assertThat(carsMapper.map(1)).isEqualTo("Audi");
        assertThat(carsMapper.map(2)).isEqualTo("Bmw");
        assertThat(carsMapper.map(3)).isEqualTo("Citroen");
        assertThat(carsMapper.map(4)).isEqualTo("Dacia");
    }
}
