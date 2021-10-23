package com.kata.rockwell.divisor

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static groovy.json.JsonOutput.toJson
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationServiceControllerSpockIT extends Specification {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    def "should context load"() {
        expect:
        mockMvc != null
        objectMapper != null
    }

    def "should pass mapped divisors input to application service and return 'ok' status"() {
        given:
            Map input = [
                    name : "animals",
                    numbers : [1, 2, 4]
            ]
            //def input = MappedDivisorsInput.builder().name("animals").numbers(Arrays.asList(1, 2, 4)).build();
        when:
            def output = mockMvc.perform(post("/api/findCorrespondingMappedDivisors").contentType(MediaType.APPLICATION_JSON).content(toJson(input)));
        then:
            output.andExpect(status().isOk())
        //and:
        //    def outputObj = objectMapper.readValue(output.andReturn().response.contentAsString, MappedDivisorsOutput);
        //    outputObj.getResponse().get(1) == null
        //    println(output.andReturn().response.contentAsString)
        //    println(outputObj)
    }
}