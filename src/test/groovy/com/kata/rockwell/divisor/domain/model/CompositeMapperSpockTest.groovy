package com.kata.rockwell.divisor.domain.model

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class CompositeMapperSpockTest extends Specification {

    @Autowired
    CompositeMapper compositeMapper;

    def "contextLoad" () {
        expect:
            compositeMapper != null
    }

    def "map" () {
        expect:
            compositeMapper.map("animals", 1) == "Mouse"
            compositeMapper.map("cars", 1) == "Audi"
            compositeMapper.map("furnitures", 1) == "Chair"
    }

//    def "maximum of two numbers"() {
//        expect:
//        // exercise math method for a few different inputs
//        Math.max(1, 3) == 3
//        Math.max(7, 4) == 7
//        Math.max(0, 0) == 0
//    }
//
//    def "maximum of two numbers"(int a, int b, int c) {
//        expect:
//        Math.max(a, b) == c
//
//        where:
//        a | b | c
//        1 | 3 | 3
//        7 | 4 | 7
//        0 | 0 | 0
//    }
//
//    def "maximum of two numbers 2 "() {
//        expect:
//        Math.max(a, b) == c
//
//        where:
//        a | b || c
//        1 | 3 || 3
//        7 | 4 || 7
//        0 | 0 || 0
//    }
}
