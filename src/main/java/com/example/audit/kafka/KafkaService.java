package com.example.audit.kafka;

import com.example.audit.dto.AuditAction;
import com.example.audit.repository.AuditActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {
    private final AuditActionRepository actionRepository;

    @KafkaListener(
            topics = "${spring.kafka.topic.audit}",
            groupId = "${spring.kafka.group-id.audit}",
            containerFactory = "factory"
    )
    public void listenSendDocuments(@Payload AuditAction action) {
        actionRepository.save(action);
    }
}
