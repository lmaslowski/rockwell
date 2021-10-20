package com.kata.rockwell.application.mappers;

import com.kata.rockwell.domain.model.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class CompositeMapper {

    private Map<String, Mapper> mapperMap;

    public String map(String type, Number number) {
        return mapperMap.get(type).map(number);
    }
}
