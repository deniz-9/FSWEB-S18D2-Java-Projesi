package com.workintech.s18g2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    //fruitler için hata döner
    @ExceptionHandler
    public ResponseEntity<FruitResponse> handleException(FruitException exception){
        FruitResponse response= new FruitResponse(exception.getStatus().value(),exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response,exception.getStatus());
    }


    //en global hataları döner
    @ExceptionHandler
    public ResponseEntity<FruitResponse> handleExc(Exception exception){
        FruitResponse response= new FruitResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<VegetableResponse> handleExceptionVegetable(VegetableException exception){
        VegetableResponse response= new VegetableResponse(exception.getStatus().value(),exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response,exception.getStatus());
    }


    //en global hataları döner
    @ExceptionHandler
    public ResponseEntity<VegetableResponse> handleExcVegetable(Exception exception){
        VegetableResponse response= new VegetableResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    //annotationları, girilen değerleri kontrol eder.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleBindErrors(MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> {
                    Map<String, String> errors = new HashMap<>();
                    errors.put(fieldError.getField(), fieldError.getDefaultMessage());
                    return errors;
                }).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorList);
    }

}
