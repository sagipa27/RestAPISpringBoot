package com.example.finalproject.domain.usecase.settlementmethods;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTotalHolidaysDaysTest {

    @Test
    void calculateTotalHolidaysDays() {
        String startDate = "2020/01/01";
        String endDate = "2021/01/01";
        Integer expected = 20;
        Integer actual = CalculateTotalHolidaysDays.calculateTotalHolidaysDays(startDate, endDate);
        assertEquals(expected, actual);
    }

}