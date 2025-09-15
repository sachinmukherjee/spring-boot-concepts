package com.sachinmukharjee.concepts.config;

import com.sachinmukharjee.concepts.properties.KafkaProperties;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
@AllArgsConstructor
public class KafkaConfig {

  private final KafkaProperties kafkaProperties;

  @Bean
  public ConsumerFactory<String, String> consumerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
    props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getConsumer().getGroupId());
    props.put(
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
        kafkaProperties.getConsumer().getKeyDeserializer());
    props.put(
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
        kafkaProperties.getConsumer().getValueDeserializer());
    props.put(
        ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,
        kafkaProperties.getConsumer().isEnableAutoCommit());
    props.put(
        ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,
        kafkaProperties.getConsumer().getAutoOffsetReset());
      props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, kafkaProperties.getConsumer().getMaxPollRecords());
    return new DefaultKafkaConsumerFactory<>(props);
  }

  @Bean
  public ProducerFactory<String, String> producerFactory() {
    Map<String, Object> props = new HashMap<>();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
    props.put(
        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        kafkaProperties.getProducer().getKeySerializer());
    props.put(
        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        kafkaProperties.getProducer().getValueSerializer());
    return new DefaultKafkaProducerFactory<>(props);
  }

  @Bean
  public KafkaTemplate<String, String> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }
}
