package com.example.audit.controller;

import com.example.audit.dto.AuditAction;
import com.example.audit.dto.ServiceDTO;
import com.example.audit.dto.Type;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RequestMapping("/audit")
public interface AuditController {
    @GetMapping("/{uuid}")
    ResponseEntity<AuditAction> getAudit(@PathVariable UUID uuid);

    @GetMapping("/type/{type}")
    ResponseEntity<List<AuditAction>> getAuditsByType(@PathVariable Type type);

    @GetMapping("/service/{serviceDTO}")
    ResponseEntity<List<AuditAction>> getAuditsByService(@PathVariable ServiceDTO serviceDTO);

    @GetMapping
    ResponseEntity<List<AuditAction>> getAllAudits();
}
