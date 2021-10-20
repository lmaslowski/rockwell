package com.kata.rockwell.infrastructure.web;

import com.kata.rockwell.application.ApplicationService;
import com.kata.rockwell.application.MappedDivisorsInput;
import com.kata.rockwell.application.MappedDivisorsOutput;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class ApplicationServiceController {

    private final ApplicationService applicationService;

    @PostMapping("/api/findCorrespondingMappedDivisors")
    @ResponseBody
    public MappedDivisorsOutput findCorrespondingMappedDivisors(@RequestBody MappedDivisorsInput mappedDivisorsInput) {
        return applicationService.findCorrespondingMappedDivisors(mappedDivisorsInput);
    }
}
