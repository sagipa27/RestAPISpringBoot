package com.example.finalproject.domain.model.settlement;

import static org.springframework.util.Assert.notNull;

public class RetirementReason {

    private final String value;

    public RetirementReason(String value) {
        notNull(value, "RetirementReason must not be null");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
