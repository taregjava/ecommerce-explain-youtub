package com.halfacode.ecommerceyoutube.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data

public class ApiResponse<T> {

    private int status;
    private String message;
    private T payload;
    private Date timestamp;


    public ApiResponse(int status, String message, T payload) {
        this.status = status;
        this.message = message;
        this.payload = payload;
        this.timestamp = new Date();
    }
}
