package com.example.finalproject.domain.usecase.settlementmethods;

import com.example.finalproject.domain.usecase.dateformatter.DateFormatter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LayOffInterest {

    private LayOffInterest() {
        throw new IllegalStateException("Utility class");
    }
    public static Integer calculateLayOff(String startDate, String endDate, Integer layOff) {


        String newStartDate = DateFormatter.formatDate(startDate);
        String newEndDate = DateFormatter.formatDate(endDate);

        LocalDate startDates = LocalDate.parse(newStartDate);
        LocalDate endDates = LocalDate.parse(newEndDate);
        int totalDays = (int) ChronoUnit.DAYS.between(startDates, endDates);

        return (int) (((layOff * totalDays) *0.12) / 360);

    }
}
