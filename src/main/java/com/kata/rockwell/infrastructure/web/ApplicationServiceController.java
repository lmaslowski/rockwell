package com.kata.rockwell.infrastructure.web;

import com.kata.rockwell.application.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApplicationServiceController {

    private final ApplicationService applicationService;
}
