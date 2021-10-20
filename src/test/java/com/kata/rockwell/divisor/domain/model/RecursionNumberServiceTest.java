package com.kata.rockwell.divisor.domain.model;

class RecursionNumberServiceTest extends NumberServiceTest {

    @Override
    NumberService getDivisioningService() {
        return new StreamNumberService();
    }
}
