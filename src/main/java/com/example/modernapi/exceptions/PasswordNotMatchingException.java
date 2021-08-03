package com.example.modernapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class PasswordNotMatchingException extends RuntimeException{
    public PasswordNotMatchingException(String message) {
        super(message);
    }
}
