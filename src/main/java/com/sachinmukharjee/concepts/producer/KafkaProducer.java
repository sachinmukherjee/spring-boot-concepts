package com.sachinmukharjee.concepts.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message,String topic){
        log.debug("Sending message {} : topic {}",message,topic);
        kafkaTemplate.send(topic,message);
    }
}
