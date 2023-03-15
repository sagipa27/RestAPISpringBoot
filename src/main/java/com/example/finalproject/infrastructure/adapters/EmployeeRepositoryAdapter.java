package com.example.finalproject.infrastructure.adapters;

import com.example.finalproject.domain.gateway.IEmployeeRepository;
import com.example.finalproject.domain.model.employee.Employee;
import com.example.finalproject.domain.model.salary.*;
import com.example.finalproject.infrastructure.adapters.jpa.IEmployeeRepositoryAdapter;
import com.example.finalproject.infrastructure.adapters.jpa.ISalaryRepositoryAdapter;
import com.example.finalproject.domain.usecase.entity.EmployeeDBO;
import com.example.finalproject.domain.usecase.entity.SalaryDBO;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;


@Repository
@AllArgsConstructor
public class EmployeeRepositoryAdapter implements IEmployeeRepository {

    private final IEmployeeRepositoryAdapter iEmployeeRepositoryAdapter;
    private final ISalaryRepositoryAdapter iSalaryRepositoryAdapter;
    @Override
    public Employee saveEmployee(Employee employee) {

        EmployeeDBO employeeDBO = EmployeeDBO.fromDomain(employee);

        Salary salary = new Salary(new NewSalary(employeeDBO.getSalary()),
                new ModificationDate(employeeDBO.getStartDate()),
                new SalaryId(1),
                new EmployeeIdSalary(employeeDBO.getId()));

        iSalaryRepositoryAdapter.save(SalaryDBO.fromDomain(salary));

        return EmployeeDBO.toDomain(iEmployeeRepositoryAdapter.save(employeeDBO));
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        EmployeeDBO employeeDBO = EmployeeDBO.fromDomain(employee);
        Optional<EmployeeDBO> elementFound = iEmployeeRepositoryAdapter.findById(employeeDBO.getId());

        if(elementFound.isPresent()){
            return EmployeeDBO.toDomain(iEmployeeRepositoryAdapter.save(employeeDBO));
        }else{
            throw new NullPointerException("No existe empleado con el id: " + employee.getId().getValue());
        }

    }

    @Override
    public List<Employee> getEmployees() {
        return iEmployeeRepositoryAdapter
                .findAllEmployeesInSalaryOrder().stream()
                .map(EmployeeDBO::toDomain)
                .toList();
    }

    @Override
    public Employee findEmployeeById(String id) {
        Optional<EmployeeDBO> dbo = iEmployeeRepositoryAdapter.findById(id);

        if (dbo.isEmpty()){
            throw new NullPointerException("No existe empleado con el id: " + id);
        } else {
            return EmployeeDBO.toDomain(dbo.get());
        }
    }

    @Override
    public Boolean deleteEmployeeById(String id) {

        AtomicReference<Boolean> bool = new AtomicReference<>(false);
        Optional<EmployeeDBO> dbo = iEmployeeRepositoryAdapter.findById(id);
        dbo.ifPresent(value->{
            iEmployeeRepositoryAdapter.deleteById(id);
            bool.set(true);
        });
        return bool.get();

    }

    @Transactional
    @Override
    public void updateEmployeeSalary(String id, Integer salary) {

        iEmployeeRepositoryAdapter.updateEmployeeSalary(id, salary);
    }

    @Transactional
    @Override
    public void updateEmployeeStatusToInactive(String employeeId, String status) {
        iEmployeeRepositoryAdapter.updateEmployeeStatusToInactive(employeeId, status);
    }




}
