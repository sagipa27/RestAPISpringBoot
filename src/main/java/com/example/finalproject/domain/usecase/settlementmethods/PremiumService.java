package com.example.finalproject.domain.usecase.settlementmethods;


import com.example.finalproject.domain.usecase.dateformatter.DateFormatter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class PremiumService {

        private PremiumService() {
            throw new IllegalStateException("Utility class");
        }
        public static Integer calculatePremium( String endDate, Integer salary){


            String firstSemester = "2023-07-01";
            String secondSemester = "2023-01-01";
            String newEndDate = DateFormatter.formatDate(endDate);

            //Parsing the date
            LocalDate firstSemesterDate = LocalDate.parse(firstSemester);
            LocalDate secondSemesterDate = LocalDate.parse(secondSemester);
            LocalDate completionContractDate = LocalDate.parse(newEndDate);

            if(completionContractDate.isBefore(firstSemesterDate) && completionContractDate.isAfter(secondSemesterDate)) {

                long noOfDaysBetween = ChronoUnit.DAYS.between(secondSemesterDate, completionContractDate);
                return (salary * (int)noOfDaysBetween) / 360;
            }
            else{
                long noOfDaysBetween = ChronoUnit.DAYS.between(firstSemesterDate, completionContractDate);
                return (salary * (int)noOfDaysBetween) / 360;
            }

        }
}
