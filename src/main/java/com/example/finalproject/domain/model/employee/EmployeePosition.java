package com.example.finalproject.domain.model.employee;

import org.springframework.util.Assert;

import java.util.regex.Pattern;



public class EmployeePosition {

    private final String value;

    public EmployeePosition(String value) {

        Assert.isTrue(!(value.length() >= 30 || value.length()<=10) , "El cargo no debe de superar los 30 caracteres o tener menos de 10 caracteres");
        Assert.isTrue(Pattern.matches("^[^$%&|<>#]*$", value), "No debe contener caracteres especiales");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
