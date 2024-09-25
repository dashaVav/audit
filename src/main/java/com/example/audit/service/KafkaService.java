package com.example.audit.service;

import com.example.audit.dto.AuditAction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;

public interface KafkaService {
    @KafkaListener(
            topics = "${spring.kafka.topic.audit}",
            groupId = "${spring.kafka.group-id.audit}",
            containerFactory = "factory"
    )
    void listenAuditTopic(@Payload AuditAction action);
}
