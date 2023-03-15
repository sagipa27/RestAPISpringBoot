package com.example.finalproject.domain.dto;

import com.example.finalproject.domain.model.salary.*;

public class SalaryDTO {

    private final Integer id;
    private final Integer newSalary;
    private final String modificationDate;
    private final String employeeIdSalary;

    public SalaryDTO(Integer id, Integer newSalary, String modificationDate, String employeeIdSalary) {
        this.id = id;
        this.newSalary = newSalary;
        this.modificationDate = modificationDate;

        this.employeeIdSalary = employeeIdSalary;
    }


    public String getEmployeeIdSalary() {
        return employeeIdSalary;
    }

    public Integer getId() {
        return id;
    }


    public Integer getNewSalary() {
        return newSalary;
    }

    public String getModificationDate() {
        return modificationDate;
    }


    public static SalaryDTO fromDomain(Salary salary) {
        return new SalaryDTO(
                salary.getSalaryId().getValue()
                ,salary.getNewSalary().getValue()
                ,salary.getModificationDate().getValue()
                ,salary.getEmployeeIdSalary().getValue());

    }

    public static Salary toDomain(SalaryDTO salaryDTO) {
        return new Salary(
                new NewSalary(salaryDTO.getNewSalary())
                ,new ModificationDate(salaryDTO.getModificationDate())
                ,new SalaryId(salaryDTO.getId())
                ,new EmployeeIdSalary(salaryDTO.getEmployeeIdSalary()));
    }

}
