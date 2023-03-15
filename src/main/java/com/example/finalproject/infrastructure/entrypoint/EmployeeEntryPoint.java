package com.example.finalproject.infrastructure.entrypoint;


import com.example.finalproject.domain.dto.EmployeeDTO;
import com.example.finalproject.domain.usecase.EmployeeUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeEntryPoint {


    private final EmployeeUseCase employeeUseCase;

    public EmployeeEntryPoint(EmployeeUseCase employeeUseCase) {
        this.employeeUseCase = employeeUseCase;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<?> getEmployees() {
        List<EmployeeDTO> employees = employeeUseCase.getEmployees();

        if(employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable(name = "id") String id) {
        EmployeeDTO employee = employeeUseCase.getEmployee(id);

        if(employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO employee = employeeUseCase.saveEmployee(employeeDTO);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO employee = employeeUseCase.updateEmployee(employeeDTO);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(name = "id") String id) {
        Boolean deleted = employeeUseCase.deleteEmployee(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }

}


