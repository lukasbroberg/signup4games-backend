package com.example.accessing_data_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.PRECONDITION_FAILED,
        reason = "Player doesnt meet requirements"
)
public class UnableToCreatePlayerException extends RuntimeException{
    public UnableToCreatePlayerException(String message){
        super(message);
    }
}
