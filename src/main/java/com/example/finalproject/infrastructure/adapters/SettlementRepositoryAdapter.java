package com.example.finalproject.infrastructure.adapters;

import com.example.finalproject.domain.dto.EmployeeDTO;
import com.example.finalproject.domain.gateway.ISettlementRepository;
import com.example.finalproject.domain.model.employee.Employee;
import com.example.finalproject.domain.model.settlement.Settlement;
import com.example.finalproject.domain.usecase.EmployeeUseCase;
import com.example.finalproject.infrastructure.adapters.jpa.ISettlementRepositoryAdapter;
import com.example.finalproject.domain.usecase.entity.SettlementDBO;
import com.example.finalproject.domain.usecase.settlementmethods.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Repository
@AllArgsConstructor
public class SettlementRepositoryAdapter implements ISettlementRepository {

    private final ISettlementRepositoryAdapter isettlementRepositoryAdapter;
    private final EmployeeUseCase employeeUseCase;




    @Override
    public Settlement saveSettlement(Settlement settlement){

        Employee employee = EmployeeDTO.toDomain(employeeUseCase.getEmployee(settlement.getEmployeeId().getValue()));
        String retirementReason = settlement.getRetirementReason().getValue();
        String startDate = employee.getStartDate().getValue();
        String completionContractDate = settlement.getCompletionContractDate().getValue();
        Integer salary = employee.getSalary().getValue();
        Integer layOff =  (LayOff.calculateLayOff(startDate, completionContractDate,salary));

        SettlementDBO settlementDBO = SettlementDBO.fromDomain(settlement,
                employee.getName().getValue(),
                employee.getPosition().getValue(),
                startDate,
                TransportAllowance.calculateTransportAllowance(salary),
                completionContractDate,
                CalculateTotalDays.calculateTotalDays(startDate, completionContractDate),
                CalculateDaysCurrentYear.calculateDaysCurrentYear(completionContractDate),
                CalculateWorkingDaysLastSemester.calculateWorkingDaysLastSemester(completionContractDate),
                CalculateTotalHolidaysDays.calculateTotalHolidaysDays(startDate, completionContractDate),
                salary,
                layOff,
                Holidays.calculateHolidays(startDate, completionContractDate,salary),
                LayOffInterest.calculateLayOff(startDate, completionContractDate,layOff) ,
                PremiumService.calculatePremium(completionContractDate,salary),
                Bonus.calculateBonus(startDate, completionContractDate,salary),
                CalculateTotal.calculateTotal(startDate, completionContractDate,salary, retirementReason)

        );

        return SettlementDBO.toDomain(isettlementRepositoryAdapter.save(settlementDBO));
    }



    @Override
    public List<Settlement> getSettlements() {

        return isettlementRepositoryAdapter.findAll().stream()
                .map(SettlementDBO::toDomain).toList();

    }

    @Override
    public Boolean deleteSettlement(String id) {
        AtomicReference<Boolean> bool = new AtomicReference<>(false);
        Optional<SettlementDBO> dbo = isettlementRepositoryAdapter.findById(id);
        dbo.ifPresent(value->{
            isettlementRepositoryAdapter.deleteById(id);
            bool.set(true);
        });
        return bool.get();
    }
}
