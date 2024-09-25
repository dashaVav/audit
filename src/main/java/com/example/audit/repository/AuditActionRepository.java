package com.example.audit.repository;

import com.example.audit.dto.AuditAction;
import com.example.audit.dto.ServiceDTO;
import com.example.audit.dto.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AuditActionRepository extends CrudRepository<AuditAction, UUID> {
    List<AuditAction> findByType(Type type);

    List<AuditAction> findByService(ServiceDTO service);
}
