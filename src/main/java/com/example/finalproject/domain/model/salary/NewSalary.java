package com.example.finalproject.domain.model.salary;

import static org.springframework.util.Assert.notNull;

public class NewSalary {

    private final Integer value;

    public NewSalary(Integer value) {

        notNull(value, "Este campo no puede ser nulo");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
