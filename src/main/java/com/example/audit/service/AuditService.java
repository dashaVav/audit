package com.example.audit.service;

import com.example.audit.dto.AuditAction;
import com.example.audit.dto.ServiceDTO;
import com.example.audit.dto.Type;

import java.util.List;
import java.util.UUID;

public interface AuditService {
    List<AuditAction> getActionsByType(Type type);

    List<AuditAction> getActionsByService(ServiceDTO service);

    List<AuditAction> getAllActions();

    AuditAction getActionById(UUID id);
}
