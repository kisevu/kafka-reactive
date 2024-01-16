package com.ameda.kevin.kafka.producer;

import com.ameda.kevin.kafka.DTO.Worker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaJsonProducer {
    private final KafkaTemplate<String, Worker> kafkaTemplate;

    public void sendMessage(Worker worker){
        Message<Worker> message = MessageBuilder
                .withPayload(worker)
                .setHeader(KafkaHeaders.TOPIC,"ameda")
                .build();
        kafkaTemplate.send(message);
    }
}
