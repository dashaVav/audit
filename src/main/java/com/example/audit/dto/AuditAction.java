package com.example.audit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.UUID;

@RedisHash("Action")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditAction implements Serializable {
    private UUID id;
    @Indexed
    private Type type;
    @Indexed
    private ServiceDTO service;
    private String message;
}
