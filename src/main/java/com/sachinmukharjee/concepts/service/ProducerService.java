package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.Message;
import com.sachinmukharjee.concepts.producer.KafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService implements IProducerService {

    private static final String TOPIC_NAME= "sample-topic";

    @Autowired
    private KafkaProducer kafkaProducer;


    @Override
    public void sendMessage(Message message) {
        kafkaProducer.sendMessage(message.getMessage(),TOPIC_NAME);
    }
}
