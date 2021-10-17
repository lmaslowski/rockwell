package com.kata.rockwell.application;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@ExtendWith(SpringExtension.class)
class ApplicationServiceMockTest {

    @MockBean
    private ApplicationService applicationService;

    @Test
    void contextLoad() {
        assertNotNull(applicationService);
        log.info("app : {}", applicationService);
    }
}
