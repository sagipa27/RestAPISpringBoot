package com.example.finalproject.domain.usecase.settlementmethods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTotalDaysTest {

    @Test
    @DisplayName("Calculate total days OK")
    void isValid() {

        //arrange
        String startDate = "2021/01/01";
        String endDate = "2021/01/31";
        Integer expected = 30;
        //act
        Integer actual = CalculateTotalDays.calculateTotalDays(startDate, endDate);
        //assert
        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Calculate total days not OK")
    void isNotValid() {

        //arrange
        String startDate = "2021/01/01";
        String endDate = "2021/01/31";
        Integer expected = 60;
        //act
        Integer actual = CalculateTotalDays.calculateTotalDays(startDate, endDate);
        //assert
        assertNotEquals(expected,actual);
    }

}