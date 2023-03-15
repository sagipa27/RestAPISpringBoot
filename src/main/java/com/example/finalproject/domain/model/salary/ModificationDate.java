package com.example.finalproject.domain.model.salary;

import com.example.finalproject.domain.usecase.datevalidator.DateValidatorUsingFormat;
import com.example.finalproject.domain.usecase.datevalidator.IDateValidator;
import org.springframework.util.Assert;

import static org.springframework.util.Assert.notNull;

public class ModificationDate {

    private final String value;

    public ModificationDate(String value) {

        notNull(value, "El campo fecha de inicio no puede ser nulo");

        IDateValidator validator = new DateValidatorUsingFormat("yyyy/dd/M");

        Assert.isTrue(!(validator.isValid(value)), "La fecha debe estar en el formato yyyy/dd/MM");


        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
