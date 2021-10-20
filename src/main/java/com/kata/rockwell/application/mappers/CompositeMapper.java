package com.kata.rockwell.application.mappers;

import com.kata.rockwell.domain.model.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CompositeMapper {

    private static final String NOT_MAPPED = "not mapped";
    private final Map<String, Mapper> mapperMap;

    public String map(String type, Number number) {
        return Objects.isNull(mapperMap.get(type).map(number)) ? NOT_MAPPED : mapperMap.get(type).map(number);
    }
}
