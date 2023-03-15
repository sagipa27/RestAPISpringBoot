package com.example.finalproject.domain.usecase;

import com.example.finalproject.domain.dto.SettlementDTO;
import com.example.finalproject.domain.gateway.IEmployeeRepository;
import com.example.finalproject.domain.gateway.ISettlementRepository;
import com.example.finalproject.domain.model.employee.Employee;
import com.example.finalproject.domain.model.settlement.Settlement;

import java.util.ArrayList;
import java.util.List;

public class SettlementUseCase {

    private final ISettlementRepository iSettlementRepository;
    private final IEmployeeRepository iEmployeeRepository;
    public SettlementUseCase(ISettlementRepository settlementRepository, IEmployeeRepository iEmployeeRepository) {
        this.iSettlementRepository = settlementRepository;
        this.iEmployeeRepository = iEmployeeRepository;
    }

    public SettlementDTO saveSettlement(SettlementDTO settlementDTO) throws Exception {

        Settlement settlement = SettlementDTO.toDomain(settlementDTO);
        Employee employee = iEmployeeRepository.findEmployeeById(settlementDTO.getEmployeeId());

        String status = employee.getEmployeeStatus().getValue();

        if(status.equals("ACTIVE")){
            iEmployeeRepository.updateEmployeeStatusToInactive(settlementDTO.getEmployeeId(), "INACTIVE");
            return SettlementDTO.fromDomain(iSettlementRepository.saveSettlement(settlement),employee);
        }else {
            throw new Exception("Employee is not active");
        }


    }

    public List<SettlementDTO> getSettlements() {
        List<Settlement> settlements = iSettlementRepository.getSettlements();

        List<SettlementDTO> settlementDTO = new ArrayList<>();


        settlements.forEach(settlement -> {
            Employee employee = iEmployeeRepository.findEmployeeById(settlement.getEmployeeId().getValue());
            SettlementDTO.fromDomain(settlement, employee);
            settlementDTO.add(SettlementDTO.fromDomain(settlement, employee));
        });

        return  settlementDTO;
    }

    public Boolean deleteSettlement(String id){
        return iSettlementRepository.deleteSettlement(id);
    }
}
