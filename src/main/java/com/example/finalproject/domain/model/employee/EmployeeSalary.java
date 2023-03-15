package com.example.finalproject.domain.model.employee;

import org.springframework.util.Assert;

import static org.springframework.util.Assert.notNull;

public class EmployeeSalary {

    private final Integer value;

    public EmployeeSalary(Integer value) {

        notNull(value, "El campo salario no puede ser nulo");
        Assert.isTrue(!(value > 7000000 || value< 1160000) , "El salario no debe de superar los 7'000.000 o debe ser minimo 1'160.000");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
