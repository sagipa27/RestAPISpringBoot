package com.example.finalproject.domain.model.employee;

import org.springframework.util.Assert;

import static org.springframework.util.Assert.notNull;

public class EmployeeId {

    private final String value;

    public EmployeeId(String value) {
        notNull(value, "El campo id no puede ser nulo");
        Assert.isTrue(!(value.length() >= 15 || value.length()<=7) , "El id no debe de superar los 15 caracteres o tener minimo 7 caracteres");
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
