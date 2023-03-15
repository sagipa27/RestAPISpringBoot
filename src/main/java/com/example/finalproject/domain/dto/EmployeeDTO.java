package com.example.finalproject.domain.dto;
import com.example.finalproject.domain.model.employee.*;



public class EmployeeDTO {

        private  String id;
        private  String name;
        private  Integer salary;
        private  String startDate;
        private  String position;
        private  String employeeStatus;


    public EmployeeDTO(String id, String name, Integer salary, String startDate, String position, String employeeStatus) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.startDate = startDate;
            this.position = position;
            this.employeeStatus = employeeStatus;
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public static EmployeeDTO fromDomain(Employee employee){
            return new EmployeeDTO(
                    employee.getId().getValue(),
                    employee.getName().getValue(),
                    employee.getSalary().getValue(),
                    employee.getStartDate().getValue(),
                    employee.getPosition().getValue(),
                    employee.getEmployeeStatus().getValue());
        }

        public static Employee toDomain(EmployeeDTO employeeDTO){
            return new Employee(
                    new EmployeeId(employeeDTO.getId()),
                    new EmployeeName(employeeDTO.getName()),
                    new EmployeeSalary(employeeDTO.getSalary()),
                    new EmployeeStartDate(employeeDTO.getStartDate()),
                    new EmployeePosition(employeeDTO.getPosition()),
                   new EmployeeStatus(employeeDTO.getEmployeeStatus()));
        }
}
