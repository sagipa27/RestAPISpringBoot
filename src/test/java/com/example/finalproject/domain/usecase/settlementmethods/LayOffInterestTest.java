package com.example.finalproject.domain.usecase.settlementmethods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class LayOffInterestTest {

    @Test
    @DisplayName("Should return correct Lay Off Interest")
    void isValid() {
        // Arrange
        String startDate = "2023/05/01";
        String endDate = "2023/06/01";
        int layOff = 2000000;


        int expected = (int) (((layOff * 31 ) * 0.12) / 360);
        if (expected < 0) {
           throw new IllegalArgumentException("The lay off interest is negative");
        }
        // Act
        int result = LayOffInterest.calculateLayOff(startDate, endDate, layOff);

        // Assert
        assertEquals(expected, result);
    }

}