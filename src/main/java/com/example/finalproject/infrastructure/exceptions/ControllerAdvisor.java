package com.example.finalproject.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<ResponseModel> handleException(NullPointerException e){
        ResponseModel responseModel = new ResponseModel(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(responseModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<ResponseModel> handleException(IllegalArgumentException e){
        ResponseModel responseModel = new ResponseModel(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
