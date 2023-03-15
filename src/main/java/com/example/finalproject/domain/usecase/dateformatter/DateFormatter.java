package com.example.finalproject.domain.usecase.dateformatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    private DateFormatter() {
        throw new IllegalStateException("Utility class");
    }
    private static final SimpleDateFormat inSDF = new SimpleDateFormat("yyyy/dd/mm");
    private static final SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-dd-mm");

    public static String formatDate(String inDate) {
        String outDate = "";
        if (inDate != null) {
            try {
                Date date = inSDF.parse(inDate);
                outDate = outSDF.format(date);
            } catch (ParseException ex){
                ex.printStackTrace();
            }
        }
        return outDate;
    }
}
