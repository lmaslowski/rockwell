package com.kata.rockwell.application.mappers;

import com.kata.rockwell.domain.model.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("animals")
public class AnimalsMapper extends Mapper {
    public AnimalsMapper(@Qualifier("animals") Map<Number, String> map) {
        super(map);
    }
}
