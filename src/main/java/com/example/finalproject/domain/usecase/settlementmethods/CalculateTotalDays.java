package com.example.finalproject.domain.usecase.settlementmethods;

import com.example.finalproject.domain.usecase.dateformatter.DateFormatter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculateTotalDays {

    private CalculateTotalDays() {
        throw new IllegalStateException("Utility class");
    }
    public static Integer calculateTotalDays(String startDate, String endDate) {

        String newStartDate = DateFormatter.formatDate(startDate);
        String newEndDate = DateFormatter.formatDate(endDate);

        LocalDate startDates = LocalDate.parse(newStartDate);
        LocalDate endDates = LocalDate.parse(newEndDate);

        return (int)ChronoUnit.DAYS.between(startDates, endDates);

    }

}
