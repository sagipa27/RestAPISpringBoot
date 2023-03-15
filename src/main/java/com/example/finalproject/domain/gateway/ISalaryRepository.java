package com.example.finalproject.domain.gateway;


import com.example.finalproject.domain.model.salary.Salary;

import java.util.List;

public interface ISalaryRepository {

    Salary saveSalary(Salary salary);

    List<Salary> getSalaries();

    Boolean deleteSalary(String id);

    List<Salary> getSalariesByEmployeeId(String id);

    
}
