package com.kata.rockwell.divisor.adapter.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.rockwell.divisor.DivisorConfig;
import com.kata.rockwell.divisor.application.ApplicationService;
import com.kata.rockwell.divisor.application.MappedDivisorsInput;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(controllers = ApplicationServiceController.class)
@ContextConfiguration(classes = DivisorConfig.class)
@ExtendWith(SpringExtension.class)
@Slf4j
class ApplicationServiceControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void before() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void contextLoad() {
        assertNotNull(mockMvc);
        assertNotNull(applicationService);
        assertNotNull(objectMapper);
    }

    @Test
    void givenServiceIsWorking_whenRequestAnimalsAndNumbers124_thenReturnsDivisorResponse() {
        RestAssuredMockMvc
                .given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(MappedDivisorsInput.builder().numbers(Arrays.asList(1, 2, 4)).name("animals").build())
                .log().all()
                .when()
                .post("/api/findCorrespondingMappedDivisors")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void givenServiceIsWorking_whenRequestFurnituresAndNumbers124_thenReturnsDivisorResponse() {
        RestAssuredMockMvc
                .given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(MappedDivisorsInput.builder().numbers(Arrays.asList(1, 2, 4)).name("furnitures").build())
                .log().all()
                .when()
                .post("/api/findCorrespondingMappedDivisors")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void givenServiceIsWorking_whenAMapping_thenReturnsDivisorResponse() {
        RestAssuredMockMvc
                .given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(MappedDivisorsInput.builder().numbers(Arrays.asList(1, 2, 4)).name("noexistingmapping").build())
                .log().all()
                .when()
                .post("/api/findCorrespondingMappedDivisors")
                .then()
                .statusCode(400)
                .log().all();
    }

    @Test
    void givenServiceIsWorking_whenRequestFurnituresAndNumbers_124_thenReturnsDivisorResponse() {
        RestAssuredMockMvc
                .given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(MappedDivisorsInput.builder().numbers(Arrays.asList(-1, 2, 4)).name("furnitures").build())
                .log().all()
                .when()
                .post("/api/findCorrespondingMappedDivisors")
                .then()
                .statusCode(400)
                .log().all();
    }
}
