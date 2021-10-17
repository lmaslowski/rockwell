package com.kata.rockwell.domain.model;

class StreamNumberServiceTest extends NumberServiceTest {

    @Override
    NumberService getDivisioningService() {
        return new StreamNumberService();
    }
}
