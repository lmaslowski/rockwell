package com.kata.rockwell.divisor.domain.model;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompositeMapper {

    private static final String NOT_MAPPED = "not mapped";
    private final Map<String, Mapper> mapperMap;

    public String map(String type, Integer number) {
        final Mapper mapper = get(type)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Mapper: %s does not existing ", type)));
        final String mapped = mapper.map(number);
        return Objects.isNull(mapped) ? NOT_MAPPED : mapped;
    }

    private Optional<Mapper> get(String mapperName) {
        return Optional.ofNullable(mapperMap.get(mapperName));
    }
}
