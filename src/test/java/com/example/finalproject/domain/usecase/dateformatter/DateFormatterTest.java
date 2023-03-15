package com.example.finalproject.domain.usecase.dateformatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {

    @Test
    @DisplayName("Date formatter OK")
    void isValid() {

        //arrange
        String inDate = "2021/01/01";
        String expected = "2021-01-01";
        //act
        String actual = DateFormatter.formatDate(inDate);
        //assert
        assertEquals(expected, actual);
    }

}