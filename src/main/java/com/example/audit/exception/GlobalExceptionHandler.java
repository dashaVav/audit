package com.example.audit.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    private ResponseEntity<AuditError> handleTheException(RuntimeException e, HttpStatus status) {
        log.error("Exception: {} handled normally. Message: {}", e.getClass().getName(), e.getMessage());
        return new ResponseEntity<>(
                new AuditError(e.getMessage(), status.value()),
                status
        );
    }

    @ExceptionHandler(AuditActionNotFoundException.class)
    public ResponseEntity<AuditError> handleNotFoundException(RuntimeException e) {
        return handleTheException(e, HttpStatus.NOT_FOUND);
    }
}
