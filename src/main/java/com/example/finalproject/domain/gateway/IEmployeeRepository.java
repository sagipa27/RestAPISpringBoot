package com.example.finalproject.domain.gateway;

import com.example.finalproject.domain.model.employee.Employee;

import java.util.List;

public interface IEmployeeRepository {


    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee findEmployeeById(String id);

    Boolean deleteEmployeeById(String id);

    void updateEmployeeSalary(String id, Integer salary);

    void updateEmployeeStatusToInactive(String employeeId, String status);
}
