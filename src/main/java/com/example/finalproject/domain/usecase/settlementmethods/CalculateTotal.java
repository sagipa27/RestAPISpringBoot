package com.example.finalproject.domain.usecase.settlementmethods;

public class CalculateTotal {

    private CalculateTotal() {
        throw new IllegalStateException("Utility class");
    }
    public static Integer calculateTotal(String startDate, String endDate, Integer salary, String retirementReason) {

        if (retirementReason.equals("justified")) {
            return PremiumService.calculatePremium(endDate, salary) +
                    LayOff.calculateLayOff(startDate, endDate, salary) +
                    LayOffInterest.calculateLayOff(startDate, endDate, salary) +
                    Holidays.calculateHolidays(startDate, endDate, salary) +
                    TransportAllowance.calculateTransportAllowance(salary);
        } else{
            return PremiumService.calculatePremium(endDate, salary) +
                    LayOff.calculateLayOff(startDate, endDate, salary) +
                    LayOffInterest.calculateLayOff(startDate, endDate, salary) +
                    Holidays.calculateHolidays(startDate, endDate, salary) +
                    TransportAllowance.calculateTransportAllowance(salary) +
                    Bonus.calculateBonus(startDate, endDate, salary);
        }

    }
}

