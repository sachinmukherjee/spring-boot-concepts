package com.sachinmukharjee.concepts.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KafkaConsumerProperties {
  private String groupId;
  private String topic;
  private String autoOffsetReset;
  private boolean enableAutoCommit;
  private String keyDeserializer;
  private String valueDeserializer;
  private int maxPollRecords;
}
