package com.kata.rockwell.divisor.adapter.mapper.db;

import com.kata.rockwell.divisor.DivisorConfig;
import com.kata.rockwell.divisor.adapter.mappers.db.AnimalsMapper;
import com.kata.rockwell.divisor.adapter.mappers.db.CarsMapper;
import com.kata.rockwell.divisor.adapter.mappers.db.SpringJpaAnimalRepository;
import com.kata.rockwell.divisor.adapter.mappers.db.SpringJpaCarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = {DivisorConfig.class})
public class AnimalsMapperTests {

    @Autowired
    private AnimalsMapper animalsMapper;

    @Autowired
    private SpringJpaAnimalRepository springJpaAnimalRepository;

    @Test
    void contextLoad() {
        assertNotNull(animalsMapper);
        assertNotNull(springJpaAnimalRepository);
    }

    @Test
    void map() {
        assertThat(animalsMapper.map(1)).isEqualTo("Mouse");
        assertThat(animalsMapper.map(2)).isEqualTo("Cat");
        assertThat(animalsMapper.map(3)).isEqualTo("Dog");
        assertThat(animalsMapper.map(4)).isEqualTo("Elephant");
    }
}
