package com.kata.rockwell.divisor.domain.model;

class StreamNumberServiceTest extends NumberServiceTest {

    @Override
    NumberService getDivisioningService() {
        return new StreamNumberService();
    }
}
