package com.example.finalproject.domain.usecase.datevalidator;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateValidatorUsingFormat implements  IDateValidator{

    private String dateFormat;

    public DateValidatorUsingFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}

