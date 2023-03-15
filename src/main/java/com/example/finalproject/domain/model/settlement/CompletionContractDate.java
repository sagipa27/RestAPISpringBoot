package com.example.finalproject.domain.model.settlement;

import static org.springframework.util.Assert.notNull;

public class CompletionContractDate {

    private final String value;

    public CompletionContractDate(String value) {

        notNull(value, "CompletionContractDate must not be null");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
