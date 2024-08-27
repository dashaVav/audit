package com.example.audit.service.kafka;

import com.example.audit.dto.AuditAction;
import com.example.audit.repository.AuditActionRepository;
import com.example.audit.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {
    private final AuditActionRepository actionRepository;

    @Override
    public void listenAuditTopic(AuditAction action) {
        actionRepository.save(action);
    }
}
