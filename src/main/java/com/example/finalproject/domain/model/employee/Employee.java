package com.example.finalproject.domain.model.employee;

public class Employee {

    private final EmployeeId id;
    private final EmployeeName name;
    private final EmployeeSalary salary;
    private final EmployeeStartDate startDate;
    private final EmployeePosition position;
    private final EmployeeStatus employeeStatus;

    public Employee(EmployeeId id, EmployeeName name, EmployeeSalary salary,
                    EmployeeStartDate startDate, EmployeePosition position, EmployeeStatus employeeStatus) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
        this.position = position;
        this.employeeStatus = employeeStatus;
    }



    public EmployeeId getId() {
        return id;
    }

    public EmployeeName getName() {
        return name;
    }

    public EmployeeSalary getSalary() {
        return salary;
    }

    public EmployeeStartDate getStartDate() {
        return startDate;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

}
