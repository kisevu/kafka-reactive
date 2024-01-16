package com.ameda.kevin.kafka.controller;

import com.ameda.kevin.kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessagingController {
    private final KafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<?> publishMessage(@RequestBody String message){
        kafkaProducer.publishMessage(message);
        return new ResponseEntity<>("Queueing your message Kisevu...",HttpStatus.OK);
    }
}
