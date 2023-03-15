package com.example.finalproject.domain.usecase.settlementmethods;

import com.example.finalproject.domain.usecase.dateformatter.DateFormatter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculateDaysCurrentYear {


    private CalculateDaysCurrentYear() {
        throw new IllegalStateException("Utility class");
    }
    public static Integer calculateDaysCurrentYear(String endDate) {

        String newEndDate = DateFormatter.formatDate(endDate);


        LocalDate beginningYear = LocalDate.parse("2023-01-01");
        LocalDate endDates = LocalDate.parse(newEndDate);

        return (int) ChronoUnit.DAYS.between(beginningYear, endDates);

    }
}
