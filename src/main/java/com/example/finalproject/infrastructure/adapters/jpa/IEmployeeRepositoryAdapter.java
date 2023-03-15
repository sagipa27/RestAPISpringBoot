package com.example.finalproject.infrastructure.adapters.jpa;

import com.example.finalproject.domain.usecase.entity.EmployeeDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEmployeeRepositoryAdapter  extends JpaRepository<EmployeeDBO, String> {

    @Modifying
    @Query(value = "UPDATE EMPLOYEE SET SALARY=:salary WHERE employee_id=:id", nativeQuery = true)
    void updateEmployeeSalary(@Param("id") String id, @Param("salary") Integer salary);

    @Query(value = "SELECT * FROM EMPLOYEE ORDER BY SALARY", nativeQuery = true)
    List<EmployeeDBO> findAllEmployeesInSalaryOrder();

    @Modifying
    @Query(value = "UPDATE EMPLOYEE SET STATUS_EMPLOYEE=:status  WHERE employee_id=:id", nativeQuery = true)
    void updateEmployeeStatusToInactive(@Param("id") String id, @Param("status") String status);


}