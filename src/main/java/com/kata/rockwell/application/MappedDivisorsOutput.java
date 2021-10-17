package com.kata.rockwell.application;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Getter
@EqualsAndHashCode
public class MappedDivisorsOutput {

    private Map<Number, List<String>> response;

    @JsonAnyGetter
    public Map<Number, List<String>> getResponse() {
        if(response == null) {
            response = new HashMap<>();
        }
        return response;
    }

    public void put(Number number, List<String> strings) {
        getResponse().put(number, strings);
    }

    public void put(Number number, String string) {
        if(getResponse().get(number) == null) {
            put(number, new ArrayList<>());
        }
        getResponse().get(number).add(string);
    }
}
