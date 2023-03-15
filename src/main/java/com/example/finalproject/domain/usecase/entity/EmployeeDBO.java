package com.example.finalproject.domain.usecase.entity;

import com.example.finalproject.domain.model.employee.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter


public class EmployeeDBO {

    @Id
    @Column(name = "employee_id")
    private  String id;
    @Column(name = "name")
    private  String name;
    @Column(name = "salary")
    private  Integer salary;
    @Column(name = "start_date")
    private  String startDate;
    @Column(name = "position")
    private  String position;
    @Column(name = "status_employee")
    private String statusEmployee;



    public static EmployeeDBO fromDomain(Employee employee){

        return new EmployeeDBO(
                employee.getId().getValue(),
                employee.getName().getValue(),
                employee.getSalary().getValue(),
                employee.getStartDate().getValue(),
                employee.getPosition().getValue(),
                employee.getEmployeeStatus().getValue());

    }

    public static Employee toDomain(EmployeeDBO employeeDBO){

     return new Employee(
                 new EmployeeId(employeeDBO.getId()),
                 new EmployeeName(employeeDBO.getName()),
                 new EmployeeSalary(employeeDBO.getSalary()),
                 new EmployeeStartDate(employeeDBO.getStartDate()),
                 new EmployeePosition(employeeDBO.getPosition()),
                 new EmployeeStatus(employeeDBO.getStatusEmployee())
             );
    }
}
