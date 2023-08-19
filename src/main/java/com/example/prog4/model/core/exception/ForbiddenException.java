package com.example.prog4.model.core.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends ServerException {
    public ForbiddenException(String message) {
        super(message, HttpStatus.FORBIDDEN.value());
    }
}
