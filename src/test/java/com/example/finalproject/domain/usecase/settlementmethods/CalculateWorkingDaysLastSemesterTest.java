package com.example.finalproject.domain.usecase.settlementmethods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateWorkingDaysLastSemesterTest {


    @Test
    @DisplayName("Should return correct amount of days")
    void calculateWorkingDaysLastSemester() {
        String endDate = "2023/07/01";
        Integer expected = 181;
        Integer actual = CalculateWorkingDaysLastSemester.calculateWorkingDaysLastSemester(endDate);
        assertEquals(expected, actual);
    }



}