package com.example.finalproject.domain.usecase.settlementmethods;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HolidaysTest {

    @Test
    @DisplayName("Should return correct amount to pay for holidays")
    void calculateHolidays() {
        String startDate = "2021/01/01";
        String endDate = "2021/02/01";
        Integer salary = 1000;
        Integer expected = 43;
        Integer actual = Holidays.calculateHolidays(startDate, endDate, salary);
        assertEquals(expected, actual);
    }

}