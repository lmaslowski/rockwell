package com.kata.rockwell.divisor.adapter.mappers;

import com.kata.rockwell.divisor.domain.model.AbstractMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("animals")
public class AnimalsMapper extends AbstractMapper {
    public AnimalsMapper(@Qualifier("animals") Map<Integer, String> map) {
        super(map);
    }
}
