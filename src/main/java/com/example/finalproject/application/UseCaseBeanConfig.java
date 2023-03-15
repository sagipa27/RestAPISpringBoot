package com.example.finalproject.application;

import com.example.finalproject.domain.gateway.IEmployeeRepository;
import com.example.finalproject.domain.gateway.ISalaryRepository;
import com.example.finalproject.domain.gateway.ISettlementRepository;
import com.example.finalproject.domain.usecase.EmployeeUseCase;
import com.example.finalproject.domain.usecase.SalaryUseCase;
import com.example.finalproject.domain.usecase.SettlementUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public EmployeeUseCase employeeUseCase(IEmployeeRepository iEmployeeRepository){
        return new EmployeeUseCase(iEmployeeRepository);
    }

    @Bean
    public SalaryUseCase salaryUseCase(ISalaryRepository iSalaryRepository, IEmployeeRepository iEmployeeRepository){
        return new SalaryUseCase(iSalaryRepository, iEmployeeRepository);
    }

    @Bean
    public SettlementUseCase settlementUseCase(ISettlementRepository iSettlementRepository, IEmployeeRepository iEmployeeRepository){
        return new SettlementUseCase(iSettlementRepository, iEmployeeRepository);
    }
}
