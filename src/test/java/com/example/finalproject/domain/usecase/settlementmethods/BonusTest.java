package com.example.finalproject.domain.usecase.settlementmethods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusTest {

    @Test
    @DisplayName("Should return correct Bonus")
    void isValid() {
        // Arrange
        String startDate = "2021/05/01";
        String endDate = "2023/05/01";
        int salary = 2000000;

        Integer daysToBePaid = (2-1) * 20;

        Integer dailySalary = salary / 30;

        int expected = 2000000 + (daysToBePaid * dailySalary);

        // Act
        int result = Bonus.calculateBonus(startDate, endDate, salary);

        // Assert
        assertEquals(expected, result);
    }

}