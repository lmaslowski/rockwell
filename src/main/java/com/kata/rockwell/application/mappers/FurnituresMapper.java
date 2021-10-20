package com.kata.rockwell.application.mappers;

import com.kata.rockwell.domain.model.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("furnitures")
public class FurnituresMapper extends Mapper {
    public FurnituresMapper(@Qualifier("furnitures") Map<Number, String> map) {
        super(map);
    }
}
