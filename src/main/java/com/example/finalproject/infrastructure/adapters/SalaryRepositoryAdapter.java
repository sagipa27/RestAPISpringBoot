package com.example.finalproject.infrastructure.adapters;

import com.example.finalproject.domain.gateway.ISalaryRepository;
import com.example.finalproject.domain.model.salary.Salary;
import com.example.finalproject.infrastructure.adapters.jpa.ISalaryRepositoryAdapter;
import com.example.finalproject.domain.usecase.entity.SalaryDBO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Repository

public class SalaryRepositoryAdapter implements ISalaryRepository {


    private final ISalaryRepositoryAdapter iSalaryRepositoryAdapter;

    public SalaryRepositoryAdapter(ISalaryRepositoryAdapter iSalaryRepositoryAdapter) {
        this.iSalaryRepositoryAdapter = iSalaryRepositoryAdapter;
    }


    @Override
    public Salary saveSalary(Salary salary) {
        SalaryDBO salaryDBO = SalaryDBO.fromDomain(salary);
        return SalaryDBO.toDomain(iSalaryRepositoryAdapter.save(salaryDBO));
    }

    @Override
    public List<Salary> getSalaries() {
        return iSalaryRepositoryAdapter
                .findAll().stream()
                .map(SalaryDBO::toDomain)
                .toList();
    }

    @Override
    public Boolean deleteSalary(String id) {
        AtomicReference<Boolean> bool = new AtomicReference<>(false);
        Optional<SalaryDBO> dbo = iSalaryRepositoryAdapter.findById(id);
        dbo.ifPresent(value->{
            iSalaryRepositoryAdapter.deleteById(id);
            bool.set(true);
        });
        return bool.get();
    }

    @Override
    public List<Salary> getSalariesByEmployeeId(String id) {
        return iSalaryRepositoryAdapter.findAllSalariesByCostumerId(id).stream()
                .map(SalaryDBO::toDomain)
                .toList();
    }


}
