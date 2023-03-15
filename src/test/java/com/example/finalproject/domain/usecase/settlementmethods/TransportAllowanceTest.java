package com.example.finalproject.domain.usecase.settlementmethods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransportAllowanceTest {

    @Test
    @DisplayName("Should return correct Transport Allowance")
    void isValid() {
        // Arrange
        int salary = 1160000;

        // Act
        int result = TransportAllowance.calculateTransportAllowance(salary);

        // Assert
        assertEquals(102854, result);
    }

}