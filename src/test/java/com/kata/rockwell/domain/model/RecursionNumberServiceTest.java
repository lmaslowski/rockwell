package com.kata.rockwell.domain.model;

class RecursionNumberServiceTest extends NumberServiceTest {

    @Override
    NumberService getDivisioningService() {
        return new StreamNumberService();
    }
}
