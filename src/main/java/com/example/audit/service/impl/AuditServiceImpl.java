package com.example.audit.service.impl;

import com.example.audit.dto.AuditAction;
import com.example.audit.dto.ServiceDTO;
import com.example.audit.dto.Type;
import com.example.audit.exception.AuditActionNotFoundException;
import com.example.audit.repository.AuditActionRepository;
import com.example.audit.service.AuditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuditServiceImpl implements AuditService {
    private final AuditActionRepository actionRepository;

    @Override
    public List<AuditAction> getActionsByType(Type type) {
        return actionRepository.findByType(type);
    }

    @Override
    public List<AuditAction> getActionsByService(ServiceDTO service) {
        return actionRepository.findByService(service);
    }

    @Override
    public List<AuditAction> getAllActions() {
        return (List<AuditAction>) actionRepository.findAll();
    }

    @Override
    public AuditAction getActionById(UUID id) {
        Optional<AuditAction> action = actionRepository.findById(id);
        if (action.isEmpty()) {
            throw new AuditActionNotFoundException("Audit action with id " + id + " not found");
        }
        return action.get();
    }
}
