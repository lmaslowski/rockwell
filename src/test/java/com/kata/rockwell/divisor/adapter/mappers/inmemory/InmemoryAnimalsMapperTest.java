package com.kata.rockwell.divisor.adapter.mappers.inmemory;

import com.kata.rockwell.divisor.DivisorConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = InMemoryMappingConfig.class)
//@ContextConfiguration(classes = DivisorConfig.class)
//@DataJpaTest //running test application properties or with default if not exists
class InmemoryAnimalsMapperTest {

    @Autowired
    @Qualifier("animalsInMemory")
    private AnimalsMapper animalsMapper;

    @Test
    void contextLoad() {
        assertNotNull(animalsMapper);
    }

    @Test
    void map() {
        assertThat(animalsMapper.map(1)).isEqualTo("Mouse");
        assertThat(animalsMapper.map(2)).isEqualTo("Cat");
        assertThat(animalsMapper.map(3)).isEqualTo("Dog");
        assertThat(animalsMapper.map(4)).isEqualTo("Elephant");
    }
}
