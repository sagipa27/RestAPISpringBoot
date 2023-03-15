package com.example.finalproject.domain.model.employee;

import com.example.finalproject.domain.usecase.datevalidator.DateValidatorUsingFormat;
import com.example.finalproject.domain.usecase.datevalidator.IDateValidator;

import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.util.Assert.notNull;


public class EmployeeStartDate {

    private final String value;

    public EmployeeStartDate(String value) {

        IDateValidator validator = new DateValidatorUsingFormat("yyyy/dd/M");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM");
        String upperLimitDate = "2023/06/06";
        String lowerLimitDate = "2015/01/01";



        notNull(value, "El campo fecha de inicio no puede ser nulo");
        Assert.isTrue(!(validator.isValid(value)), "La fecha debe estar en el formato yyyy/dd/MM");

        try{
            Date lowerDate = dateFormat.parse(lowerLimitDate);
            Date upperDate = dateFormat.parse(upperLimitDate);
            Date hireDate = dateFormat.parse(value);

            if(hireDate.before(lowerDate) || hireDate.after(upperDate)){
                throw new IllegalArgumentException("La fecha de inicio debe estar entre el 01/01/2015 y el 06/06/2015");
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
