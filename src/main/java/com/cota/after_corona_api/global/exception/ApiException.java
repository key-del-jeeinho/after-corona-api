package com.cota.after_corona_api.global.exception;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
