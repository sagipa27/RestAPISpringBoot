package com.example.finalproject.infrastructure.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class ResponseModel {

    private Integer status;
    private String message;


}
