package com.kata.rockwell.application;

import com.kata.rockwell.domain.model.NumberService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ApplicationService {
    private final NumberService numberService;
    private final Map<Number, String> mapNumberToAnimals;
    private final Map<Number, String> mapNumberToFurnitures;

    public ApplicationService(NumberService numberService,
                              @Qualifier("animals") Map<Number, String> mapNumberToAnimals,
                              @Qualifier("furnitures") Map<Number, String> mapNumberToFurnitures) {
        this.numberService = numberService;
        this.mapNumberToAnimals = mapNumberToAnimals;
        this.mapNumberToFurnitures = mapNumberToFurnitures;
    }

    public MappedDivisorsOutput findCorrespondingMappedDivisors(MappedDivisorsInput input) {
        final String name = input.getName();
        final List<Number> numbers = input.getNumbers();

        final MappedDivisorsOutput output = MappedDivisorsOutput.builder().build();

        numbers.forEach(n -> {
            final List<Number> allDivisors = numberService.findAllDivisors(n);
            final ArrayList<String> strings = new ArrayList<>();
            for (Number d : allDivisors) {
                strings.add(getMapping(name).get(d));
            }
            output.put(n, strings);
        });

        return output;
    }

    private Map<Number, String> getMapping(String type) {
        if (type.equals("animals")) {
            return mapNumberToAnimals;
        } else if (type.equals("furnitures")) {
            return mapNumberToFurnitures;
        }
        throw new IllegalArgumentException("not supported");
    }
}
