package com.example.audit.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuditError {
    private String error;
    private Integer status;
}
