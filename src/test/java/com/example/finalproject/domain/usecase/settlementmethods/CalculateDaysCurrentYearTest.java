package com.example.finalproject.domain.usecase.settlementmethods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateDaysCurrentYearTest {

    @Test
    @DisplayName("Should return correct days")
    void isValid() {
        // Arrange
        String endDate = "2023/02/01";
        int expected = 31;

        // Act
        int result = CalculateDaysCurrentYear.calculateDaysCurrentYear(endDate);

        // Assert
        assertEquals(expected, result);
    }

}