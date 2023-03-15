package com.example.finalproject.domain.usecase.datevalidator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateValidatorUsingFormatTest {

    @Test
    @DisplayName("Should return true when date is valid")
    void isValid() {
        // Arrange
        String dateStr = "2020/01/01";
        IDateValidator dateValidator = new DateValidatorUsingFormat("yyyy/MM/dd");

        // Act
        boolean isValid = dateValidator.isValid(dateStr);

        // Assert
        assertTrue(isValid);
    }

    @Test
    @DisplayName("Should return true when date is not valid")
    void isNotValid() {
        // Arrange
        String dateStr = "2020/14/01";
        IDateValidator dateValidator = new DateValidatorUsingFormat("yyyy/MM/dd");

        // Act
        boolean isValid = dateValidator.isValid(dateStr);

        // Assert
        assertFalse(isValid);
    }

}