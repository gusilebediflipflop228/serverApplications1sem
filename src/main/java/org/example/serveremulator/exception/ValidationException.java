package org.example.serveremulator.exception;

import org.example.serveremulator.enums.ErrorCode;
import org.springframework.http.HttpStatus;

public class ValidationException extends ApiException {
    public ValidationException(ErrorCode errorCode, String details) {
        super(errorCode, HttpStatus.BAD_REQUEST, details);
    }

    // Конструктор для обратной совместимости
    public ValidationException(String message) {
        super(ErrorCode.VALIDATION_ERROR, HttpStatus.BAD_REQUEST, message);
    }
}