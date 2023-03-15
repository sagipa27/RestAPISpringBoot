package com.example.finalproject.domain.usecase.entity;


import com.example.finalproject.domain.model.employee.EmployeeId;
import com.example.finalproject.domain.model.settlement.CompletionContractDate;
import com.example.finalproject.domain.model.settlement.RetirementReason;
import com.example.finalproject.domain.model.settlement.Settlement;
import com.example.finalproject.domain.model.settlement.SettlementId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "settlement")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class SettlementDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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



    public static SettlementDBO fromDomain(Settlement settlement,
                                           String employeeName,
                                           String employeePosition,
                                           String employeeStartDate,
                                           Integer transportAllowance,
                                           String completionContractDate,
                                           Integer totalWorkingDays,
                                           Integer totalWorkingDaysCurrentYear,
                                           Integer totalWorkingDaysLastSemester,
                                           Integer totalHolidayDays,
                                           Integer salaryBaseSettlement,
                                           Integer layOffs,
                                           Integer holidays,
                                           Integer interests,
                                           Integer servicesPremium,
                                           Integer bonus,
                                           Integer total
    ){

        return new SettlementDBO(
                    settlement.getSettlementId().getValue(),
                    settlement.getEmployeeId().getValue(),
                    employeeName,
                    employeePosition,
                    employeeStartDate,
                    transportAllowance,
                    completionContractDate,
                    settlement.getRetirementReason().getValue(),
                    totalWorkingDays,
                    totalWorkingDaysCurrentYear,
                    totalWorkingDaysLastSemester,
                    totalHolidayDays,
                    salaryBaseSettlement,
                    layOffs,
                    holidays,
                    interests,
                    servicesPremium,
                    bonus,
                    total
        );

    }

    public static Settlement toDomain(SettlementDBO settlementDBO){

        return new Settlement(
                new SettlementId(settlementDBO.getId()),
                new EmployeeId(settlementDBO.getEmployeeId()),
                new CompletionContractDate(settlementDBO.getCompletionContractDate()),
                new RetirementReason(settlementDBO.getRetirementReason())
        );
    }

}
