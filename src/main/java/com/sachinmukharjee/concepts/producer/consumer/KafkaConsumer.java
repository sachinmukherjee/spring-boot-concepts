package com.sachinmukharjee.concepts.producer.consumer;

import com.sachinmukharjee.concepts.properties.KafkaProperties;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

  private final ConsumerFactory<String, String> consumerFactory;
  private final KafkaProperties kafkaProperties;
  private final ExecutorService executorService;
  private final Consumer<String, String> consumer;

  public KafkaConsumer(
      ConsumerFactory<String, String> consumerFactory, KafkaProperties kafkaProperties) {
    this.consumerFactory = consumerFactory;
    this.kafkaProperties = kafkaProperties;
    this.consumer = consumerFactory.createConsumer();
    this.consumer.subscribe(Collections.singleton(kafkaProperties.getConsumer().getTopic()));
    this.executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
  }

  public void start() {
    while (true) {
      // poll up to N records (configurable with max.poll.records)
      ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
      for (ConsumerRecord<String, String> record : records) {
        log.info(
            "Processing async: topic=%s, offset=%d, value=%s%n",
            record.topic(), record.offset(), record.value());
      }
    }
  }
}
