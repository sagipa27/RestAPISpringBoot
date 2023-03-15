package com.example.finalproject.domain.usecase;

import com.example.finalproject.domain.dto.SalaryDTO;
import com.example.finalproject.domain.gateway.IEmployeeRepository;
import com.example.finalproject.domain.gateway.ISalaryRepository;
import com.example.finalproject.domain.model.salary.Salary;

import java.util.List;

public class SalaryUseCase {

    private final ISalaryRepository iSalaryRepository;
    private final IEmployeeRepository employeeRepository;
    public SalaryUseCase(ISalaryRepository iSalaryRepository, IEmployeeRepository employeeRepository){
        this.iSalaryRepository = iSalaryRepository;
        this.employeeRepository = employeeRepository;
    }

    public SalaryDTO saveSalary(SalaryDTO salaryDTO){

        Salary salary = SalaryDTO.toDomain(salaryDTO);

        employeeRepository.updateEmployeeSalary(salary.getEmployeeIdSalary().getValue()
                ,salary.getNewSalary().getValue());

        return SalaryDTO.fromDomain(iSalaryRepository.saveSalary(salary));

    }


    public List<SalaryDTO> findSalaries() {
        List<Salary> salary = iSalaryRepository.getSalaries();

        return salary.stream().map(SalaryDTO::fromDomain).toList();
    }

    public List<SalaryDTO> findSalariesByCostumerId (String employeeId) {


        List<Salary> salary = iSalaryRepository.getSalariesByEmployeeId(employeeId);

        return salary.stream().map(SalaryDTO::fromDomain).toList();
    }

    public Boolean deleteSalary(String id){
        return iSalaryRepository.deleteSalary(id);
    }


}
