package com.example.finalproject.domain.model.settlement;

import com.example.finalproject.domain.model.employee.EmployeeId;

public class Settlement {

    private final SettlementId settlementId;
    private final EmployeeId employeeId;
    private final CompletionContractDate completionContractDate;
    private final RetirementReason retirementReason;

    public Settlement(SettlementId settlementId, EmployeeId employeeId, CompletionContractDate completionContractDate,
                      RetirementReason retirementReason) {

        this.settlementId = settlementId;
        this.employeeId = employeeId;
        this.completionContractDate = completionContractDate;
        this.retirementReason = retirementReason;

    }

    public SettlementId getSettlementId() {
        return settlementId;
    }

    public EmployeeId getEmployeeId() {
        return employeeId;
    }

    public CompletionContractDate getCompletionContractDate() {
        return completionContractDate;
    }

    public RetirementReason getRetirementReason() {
        return retirementReason;
    }
}
