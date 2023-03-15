package com.example.finalproject.infrastructure.entrypoint;


import com.example.finalproject.domain.dto.EmployeeDTO;
import com.example.finalproject.domain.dto.SalaryDTO;
import com.example.finalproject.domain.usecase.EmployeeUseCase;
import com.example.finalproject.domain.usecase.SalaryUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/salary")

public class SalaryEntryPoint {

    private final SalaryUseCase salaryUseCase;
    private final EmployeeUseCase employeeUseCase;

    public SalaryEntryPoint(SalaryUseCase salaryUseCase, EmployeeUseCase employeeUseCase) {
        this.salaryUseCase = salaryUseCase;
        this.employeeUseCase = employeeUseCase;
    }

    @GetMapping
    public ResponseEntity<?> getSalary() {
        List<SalaryDTO> salaries = salaryUseCase.findSalaries();

        if(salaries.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else return new ResponseEntity<>(salaries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSalariesByEmployeeId(@PathVariable(name = "id") String id) {

        List<SalaryDTO> salariesByEmployeeId = salaryUseCase.findSalariesByCostumerId(id);

        if(salariesByEmployeeId.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(salariesByEmployeeId, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveSalary(@RequestBody SalaryDTO salaryDTO) throws ParseException {

        EmployeeDTO employeeDTO = employeeUseCase.getEmployee(salaryDTO.getEmployeeIdSalary());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM");

        Date hireDate = dateFormat.parse(employeeDTO.getStartDate());

        Date updateDate = dateFormat.parse(salaryDTO.getModificationDate());

        if(updateDate.before(hireDate)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(salaryDTO.getNewSalary() < employeeDTO.getSalary()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(employeeDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        SalaryDTO salary = salaryUseCase.saveSalary(salaryDTO);

        return new ResponseEntity<>(salary, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSalary(@PathVariable(name = "id") String id) {

        Boolean deleted = salaryUseCase.deleteSalary(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}

