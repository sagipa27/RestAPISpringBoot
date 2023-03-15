package com.example.finalproject.domain.usecase.settlementmethods;

import com.example.finalproject.domain.usecase.dateformatter.DateFormatter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculateWorkingDaysLastSemester {

    private CalculateWorkingDaysLastSemester() {
        throw new IllegalStateException("Utility class");
    }
    public static Integer calculateWorkingDaysLastSemester(String endDate) {

        String newEndDate = DateFormatter.formatDate(endDate);

        LocalDate upperDate = LocalDate.parse("2023-01-01");
        LocalDate lowerDate = LocalDate.parse("2023-06-01");
        LocalDate endDates = LocalDate.parse(newEndDate);

        if(endDates.isBefore(upperDate)){
            return ((int) ChronoUnit.DAYS.between(lowerDate, upperDate))+(int) ChronoUnit.DAYS.between(upperDate, endDates);
        }else{
            return  (int) ChronoUnit.DAYS.between(upperDate, endDates);
        }
    }
}
