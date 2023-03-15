package com.example.finalproject.domain.usecase;

import com.example.finalproject.domain.dto.EmployeeDTO;
import com.example.finalproject.domain.gateway.IEmployeeRepository;
import com.example.finalproject.domain.model.employee.Employee;

import java.util.List;



public class EmployeeUseCase {

    private final IEmployeeRepository employeeRepository;

    public EmployeeUseCase(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){

        Employee employee = EmployeeDTO.toDomain(employeeDTO);
        return EmployeeDTO.fromDomain(employeeRepository.saveEmployee(employee));

    }

    public EmployeeDTO getEmployee(String id) {
        Employee employee = employeeRepository.findEmployeeById(id);
        if (employee != null) {
            return EmployeeDTO.fromDomain(employee);
        }
        return null;
    }


    public List<EmployeeDTO> getEmployees() {
        List<Employee> employee = employeeRepository.getEmployees();

        return employee.stream().map(EmployeeDTO::fromDomain).toList();
    }


    public Boolean deleteEmployee(String id){
        return employeeRepository.deleteEmployeeById(id);
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO){
        Employee employee = EmployeeDTO.toDomain(employeeDTO);
        return EmployeeDTO.fromDomain(employeeRepository.updateEmployee(employee));
    }


}
