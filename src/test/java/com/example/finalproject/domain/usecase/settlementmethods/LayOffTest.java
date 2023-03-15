package com.example.finalproject.domain.usecase.settlementmethods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LayOffTest {

    @Test
    @DisplayName("Should return correct amount to pay for lay off")
    void calculateLayOff() {
        String startDate = "2021/01/01";
        String endDate = "2021/02/01";
        Integer salary = 1000;
        Integer expected = 86;
        Integer actual = LayOff.calculateLayOff(startDate, endDate, salary);
        assertEquals(expected, actual);
    }

}