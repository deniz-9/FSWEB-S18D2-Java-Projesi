package com.workintech.s18g2.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class VegetableException extends RuntimeException {

    private HttpStatus status;

    public VegetableException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}