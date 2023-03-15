package com.example.finalproject.domain.usecase.settlementmethods;

import com.example.finalproject.domain.usecase.dateformatter.DateFormatter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bonus {

    private Bonus() {
        throw new IllegalStateException("Utility class");
    }

    public static Integer calculateBonus(String startDate, String endDate, Integer salary) {


        String newStartDate = DateFormatter.formatDate(startDate);
        String newEndDate = DateFormatter.formatDate(endDate);

        LocalDate startDates = LocalDate.parse(newStartDate);

        LocalDate endDates = LocalDate.parse(newEndDate);

        int workedYears = (int) ChronoUnit.YEARS.between(startDates, endDates);

        Integer daysToBePaid = (workedYears-1) * 20;

        Integer dailySalary = salary / 30;


        return salary + (daysToBePaid * dailySalary);

    }
}
