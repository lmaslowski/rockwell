package com.kata.rockwell.divisor.domain.model

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class StreamNumberServiceSpockTest extends Specification {

    @Autowired
    private StreamNumberService service;

    def 'contextLoad'() {
        expect:
            service.class == StreamNumberService
    }

}
