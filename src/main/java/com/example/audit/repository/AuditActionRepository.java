package com.example.audit.repository;

import com.example.audit.dto.AuditAction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AuditActionRepository extends CrudRepository<AuditAction, UUID> {
    List<AuditAction> findByType(String type);

    List<AuditAction> findByService(String service);
}
