package com.workintech.s18g2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VegetableResponse {

    private int status;
    private String message;
    private long timestamp;
}
