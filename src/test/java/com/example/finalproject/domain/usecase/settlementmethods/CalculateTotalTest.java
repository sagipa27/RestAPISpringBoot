package com.example.finalproject.domain.usecase.settlementmethods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTotalTest {

    @Test
    @DisplayName("Should return correct total")
    void isValid() {
        // Arrange
        String startDate = "2021/05/01";
        String endDate = "2023/05/01";
        int expected = 4000000 + 828000 + 960000 + 1551518;
        String retirementReason = "justified";

        int salary = 2000000;

        // Act
        int result = CalculateTotal.calculateTotal(startDate, endDate, salary, retirementReason);

        // Assert
        assertEquals(expected, result);
    }


}