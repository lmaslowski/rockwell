package com.kata.rockwell.divisor.domain.model;

import com.kata.rockwell.divisor.DivisorConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {DivisorConfig.class})
@DataJpaTest
@Slf4j
//@SpringBootTest
class CompositeMapperTest {

    @Autowired
    private CompositeMapper compositeMapper;

    @Test
    void contextLoad() {
        assertNotNull(compositeMapper);
    }

    @Test
    void map() {
        assertThat(compositeMapper.map("animals", 1)).isEqualTo("Mouse");
        assertThat(compositeMapper.map("furnitures", 1)).isEqualTo("Chair");
    }
}


