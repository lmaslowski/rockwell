package com.kata.rockwell.divisor.application;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@Slf4j
class ApplicationServiceMockTest {

    //@Mock
    @MockBean
    private ApplicationService applicationService;

    @Test
    void contextLoad() {
        assertNotNull(applicationService);
        log.info("{}", applicationService.getClass().getCanonicalName());
    }
}
