package com.example.audit.service;

import com.example.audit.dto.AuditAction;
import com.example.audit.dto.ServiceDTO;
import com.example.audit.dto.Type;
import com.example.audit.repository.AuditActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditActionRepository actionRepository;

    public List<AuditAction> getActionsByType(Type type) {
        return actionRepository.findByType(type.name());
    }

    public List<AuditAction> getActionsByService(ServiceDTO service) {
        return actionRepository.findByService(service.name());
    }

    public List<AuditAction> getAllActions() {
        return (List<AuditAction>) actionRepository.findAll();
    }

    public AuditAction getActionById(UUID id) {
        return actionRepository.findById(id).get();
    }
}
