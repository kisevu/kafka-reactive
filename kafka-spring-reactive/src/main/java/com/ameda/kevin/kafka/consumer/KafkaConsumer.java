package com.ameda.kevin.kafka.consumer;

import com.ameda.kevin.kafka.DTO.Worker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {


//    @KafkaListener(topics = "ameda",groupId = "myGroup")
    public void consumerMessage(String message){
        log.info(String.format("Consuming message from ameda topic: %s",message));
    }

    @KafkaListener(topics = "ameda",groupId = "myGroup")
    public void consumerJsonMessage(Worker worker){
        log.info(String.format("Consuming message from ameda topic: %s",worker.toString()));
    }
}
