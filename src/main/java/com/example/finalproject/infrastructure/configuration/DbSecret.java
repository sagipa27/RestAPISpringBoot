package com.example.finalproject.infrastructure.configuration;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DbSecret {

    private final String url;

    private final String driverClass;
}
