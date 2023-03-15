package com.example.finalproject.domain.model.employee;

import org.springframework.util.Assert;

import java.util.regex.Pattern;

import static org.springframework.util.Assert.notNull;


public class EmployeeName {

    private final String value;

    public EmployeeName(String value) {

        notNull(value, "El campo id no puede ser nulo");
        Assert.isTrue((value.length() <= 50), "El id no debe de superar los 50 caracteres");
        Assert.isTrue(Pattern.matches("^[^$%&|<>#]*$", value), "EL nombre no debe contener caracteres especiales");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
