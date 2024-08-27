package com.example.audit.controller.impl;

import com.example.audit.controller.AuditController;
import com.example.audit.dto.AuditAction;
import com.example.audit.dto.ServiceDTO;
import com.example.audit.dto.Type;
import com.example.audit.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AuditControllerImpl implements AuditController {
    private final AuditService auditService;

    @Override
    public ResponseEntity<AuditAction> getAudit(UUID uuid) {
        return ResponseEntity.ok(auditService.getActionById(uuid));
    }

    @Override
    public ResponseEntity<List<AuditAction>> getAuditsByType(Type type) {
        return ResponseEntity.ok(auditService.getActionsByType(type));
    }

    @Override
    public ResponseEntity<List<AuditAction>> getAuditsByService(ServiceDTO serviceDTO) {
        return ResponseEntity.ok(auditService.getActionsByService(serviceDTO));
    }

    @Override
    public ResponseEntity<List<AuditAction>> getAllAudits() {
        return ResponseEntity.ok(auditService.getAllActions());
    }
}
