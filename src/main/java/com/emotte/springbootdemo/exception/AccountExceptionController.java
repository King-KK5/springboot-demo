package com.emotte.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountExceptionController {
    @ExceptionHandler(value = AccountNotFoundException.class)
    public ResponseEntity<Object> exception(AccountNotFoundException exception) {
        return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
    }
}
