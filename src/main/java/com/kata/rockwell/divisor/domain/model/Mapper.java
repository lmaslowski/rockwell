package com.kata.rockwell.divisor.domain.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Mapper {
    protected Map<Integer, String> map;

    public Mapper() {
        this(new HashMap<>());
    }

    public Mapper(Map<Integer, String> map) {
        this.map = map;
    }

    public String map(Integer number) {
        return map.get(number);
    }
}
