package com.kata.rockwell.divisor.adapter.mappers.inmemory;

import com.kata.rockwell.divisor.domain.model.AbstractMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("furnitures")
class FurnituresMapper extends AbstractMapper {
    public FurnituresMapper(@Qualifier("furnitures") Map<Integer, String> map) {
        super(map);
    }
}
