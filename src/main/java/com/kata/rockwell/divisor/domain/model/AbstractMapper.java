package com.kata.rockwell.divisor.domain.model;

import com.kata.rockwell.divisor.domain.model.Mapper;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMapper implements Mapper {
    protected Map<Integer, String> map;

    public AbstractMapper() {
        this(new HashMap<>());
    }

    public AbstractMapper(Map<Integer, String> map) {
        this.map = map;
    }

    public String map(Integer number) {
        return map.get(number);
    }
}
