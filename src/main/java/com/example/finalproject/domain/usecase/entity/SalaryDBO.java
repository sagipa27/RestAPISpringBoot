package com.example.finalproject.domain.usecase.entity;


import com.example.finalproject.domain.model.salary.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "salary")
@NoArgsConstructor
@Getter
@Setter


public class SalaryDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "salary_id")
    Integer id;
    @Column(name = "new_salary")
    Integer newSalary;
    @Column(name = "modification_date")
    String modificationDate;
    @Column(name = "employee_id_salary")
    String employeeIdSalary;


    public SalaryDBO(Integer id, Integer newSalary, String modificationDate, String employeeIdSalary) {
        this.id = id;
        this.newSalary = newSalary;
        this.modificationDate = modificationDate;
        this.employeeIdSalary = employeeIdSalary;
    }

    public static SalaryDBO fromDomain(Salary salary){

        return new SalaryDBO(
                salary.getSalaryId().getValue(),
                salary.getNewSalary().getValue(),
                salary.getModificationDate().getValue(),
                salary.getEmployeeIdSalary().getValue()
        );
    }

    public static Salary toDomain(SalaryDBO salaryDBO){

        return new Salary(
                new NewSalary(salaryDBO.getNewSalary()),
                new ModificationDate(salaryDBO.getModificationDate()),
                new SalaryId(salaryDBO.getId()),
                new EmployeeIdSalary(salaryDBO.getEmployeeIdSalary())
        );
    }
}
