package com.example.finalproject.domain.usecase.settlementmethods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PremiumServiceTest {

    @Test
    @DisplayName("Should return correct Premium Service")
    void isValid() throws ParseException {
        // Arrange
        String endDate = "2023/02/01";
        int salary = 1000;

        // Act
        int result = PremiumService.calculatePremium(endDate, salary);

        // Assert
        assertEquals(86, result);
    }

}