package com.kata.rockwell.divisor.application

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class ApplicationServiceIT extends Specification {
    UUID uuid = UUID.randomUUID();

    @Autowired
    private ApplicationService applicationService;

    def 'test spock 0000'() {
        given:
            println(applicationService)
        when:
            println(applicationService)
        then:
            println(applicationService)
            applicationService.class != ApplicationService
    }

    def 'test spock 0001'() {
        given:
        println "given " + uuid
        when:
        println "when " + uuid
        then:
        System.out.println("AAAA")
        UUID uuid1 = UUID.randomUUID();
        println "then " + uuid1
    }
}
