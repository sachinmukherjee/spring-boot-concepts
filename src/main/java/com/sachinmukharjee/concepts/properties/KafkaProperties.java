package com.sachinmukharjee.concepts.properties;

import com.sachinmukharjee.concepts.condition.CacheEnableCondition;
import com.sachinmukharjee.concepts.condition.KafkaEnableCondition;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(KafkaEnableCondition.class)
@ConfigurationProperties("app.messaging.kafka")
@Getter
@Setter
public class KafkaProperties {
    private String bootstrapServers;
    private KafkaProducerProperties producer;
    private KafkaConsumerProperties consumer;
}
