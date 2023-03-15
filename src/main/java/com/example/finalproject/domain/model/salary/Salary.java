package com.example.finalproject.domain.model.salary;


public class Salary {

   private final NewSalary newSalary;
   private final ModificationDate modificationDate;
   private final SalaryId salaryId;
   private final EmployeeIdSalary employeeIdSalary;

    public Salary(NewSalary newSalary,
                  ModificationDate modificationDate,
                  SalaryId salaryId,
                  EmployeeIdSalary employeeIdSalary) {
        this.newSalary = newSalary;
        this.modificationDate = modificationDate;
        this.salaryId = salaryId;
        this.employeeIdSalary = employeeIdSalary;
    }


    public NewSalary getNewSalary() {
        return newSalary;
    }

    public ModificationDate getModificationDate() {
        return modificationDate;
    }

    public SalaryId getSalaryId() {
        return salaryId;
    }


    public EmployeeIdSalary getEmployeeIdSalary() {
        return employeeIdSalary;
    }
}
