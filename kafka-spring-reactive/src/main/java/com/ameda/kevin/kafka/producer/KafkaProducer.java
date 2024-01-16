package com.ameda.kevin.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;


    public void publishMessage(String message){
        kafkaTemplate.send("ameda",message);
        log.info(String.format("sending message to ameda topic: %s",message));
    }
}
