package com.example.audit.exception;

public class AuditActionNotFoundException extends RuntimeException {
    public AuditActionNotFoundException(String message) {
        super(message);
    }
}
