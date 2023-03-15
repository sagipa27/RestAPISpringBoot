package com.example.finalproject.infrastructure.adapters.jpa;

import com.example.finalproject.domain.usecase.entity.SalaryDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ISalaryRepositoryAdapter extends JpaRepository<SalaryDBO, String> {



    @Query(value = "SELECT * FROM salary WHERE employee_id_salary =:id", nativeQuery = true)
    List<SalaryDBO> findAllSalariesByCostumerId(@Param("id") String id);


}
