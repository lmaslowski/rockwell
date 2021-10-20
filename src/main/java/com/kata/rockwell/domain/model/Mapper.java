package com.kata.rockwell.domain.model;

import java.util.HashMap;
import java.util.Map;

public abstract class Mapper {
    protected Map<Number, String> map;

    public Mapper() {
        this(new HashMap<>());
    }

    public Mapper(Map<Number, String> map) {
        this.map = map;
    }

    public String map(Number number) {
        return map.get(number);
    }
}
