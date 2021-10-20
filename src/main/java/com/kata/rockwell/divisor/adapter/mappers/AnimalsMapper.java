package com.kata.rockwell.divisor.adapter.mappers;

import com.kata.rockwell.divisor.domain.model.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("animals")
public class AnimalsMapper extends Mapper {
    public AnimalsMapper(@Qualifier("animals") Map<Integer, String> map) {
        super(map);
    }
}
