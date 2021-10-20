package com.kata.rockwell.divisor.application;

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

    private Map<Integer, List<String>> response;

    @JsonAnyGetter
    public Map<Integer, List<String>> getResponse() {
        if(response == null) {
            response = new HashMap<>();
        }
        return response;
    }

    public void put(Integer number, List<String> strings) {
        getResponse().put(number, strings);
    }

    public void put(Integer number, String string) {
        if(getResponse().get(number) == null) {
            put(number, new ArrayList<>());
        }
        getResponse().get(number).add(string);
    }
}
