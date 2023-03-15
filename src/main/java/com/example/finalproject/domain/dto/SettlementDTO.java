package com.example.finalproject.domain.dto;

import com.example.finalproject.domain.model.employee.Employee;
import com.example.finalproject.domain.model.employee.EmployeeId;
import com.example.finalproject.domain.model.settlement.CompletionContractDate;
import com.example.finalproject.domain.model.settlement.RetirementReason;
import com.example.finalproject.domain.model.settlement.Settlement;
import com.example.finalproject.domain.model.settlement.SettlementId;
import com.example.finalproject.domain.usecase.settlementmethods.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SettlementDTO {

    private Integer id;
    private String employeeId;
    private String employeeName;
    private String employeePosition;
    private String employeeStartDate;
    private Integer transportAllowance;
    private String completionContractDate;
    private String retirementReason;
    private Integer totalWorkingDays;
    private Integer totalWorkingDaysCurrentYear;
    private Integer totalWorkingDaysLastSemester;
    private Integer totalHolidayDays;
    private Integer salaryBaseSettlement;
    private Integer layOffs;
    private Integer holidays;
    private Integer interests;
    private Integer servicesPremium;
    private Integer bonus;
    private Integer total;


    public static SettlementDTO fromDomain(Settlement settlement, Employee employee)
    {

        String retirementReason = settlement.getRetirementReason().getValue();
        String startDate = employee.getStartDate().getValue();
        String completionContractDate = settlement.getCompletionContractDate().getValue();
        Integer salary = employee.getSalary().getValue();
        Integer layOff =  (LayOff.calculateLayOff(startDate, completionContractDate,salary));

        return new SettlementDTO(
                settlement.getSettlementId().getValue(),
                settlement.getEmployeeId().getValue(),
                employee.getName().getValue(),
                employee.getPosition().getValue(),
                employee.getStartDate().getValue(),
                TransportAllowance.calculateTransportAllowance(salary),
                completionContractDate,
                settlement.getRetirementReason().getValue(),
                CalculateTotalDays.calculateTotalDays(startDate, completionContractDate),
                CalculateDaysCurrentYear.calculateDaysCurrentYear(completionContractDate),
                CalculateWorkingDaysLastSemester.calculateWorkingDaysLastSemester(completionContractDate),
                CalculateTotalHolidaysDays.calculateTotalHolidaysDays(startDate, completionContractDate),
                salary,
                layOff,
                Holidays.calculateHolidays(startDate, completionContractDate,salary),
                LayOffInterest.calculateLayOff(startDate, completionContractDate,layOff),
                PremiumService.calculatePremium(completionContractDate,salary),
                Bonus.calculateBonus(startDate, completionContractDate,salary),
                CalculateTotal.calculateTotal(startDate, completionContractDate,salary, retirementReason)
        );
    }
    public static Settlement toDomain(SettlementDTO settlementDTO) {
        return new Settlement(new SettlementId(settlementDTO.getId())
                ,new EmployeeId(settlementDTO.getEmployeeId())
                ,new CompletionContractDate(settlementDTO.getCompletionContractDate())
                ,new RetirementReason(settlementDTO.getRetirementReason()));
    }


}
