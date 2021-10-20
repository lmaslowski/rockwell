package com.kata.rockwell.divisor.adapter.web;

import com.kata.rockwell.divisor.application.ApplicationService;
import com.kata.rockwell.divisor.application.MappedDivisorsInput;
import com.kata.rockwell.divisor.application.MappedDivisorsOutput;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class ApplicationServiceController {

    private final ApplicationService applicationService;

    @PostMapping(value = "/api/findCorrespondingMappedDivisors", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MappedDivisorsOutput findCorrespondingMappedDivisors(@RequestBody MappedDivisorsInput mappedDivisorsInput) {
        return applicationService.findCorrespondingMappedDivisors(mappedDivisorsInput);
    }
}
