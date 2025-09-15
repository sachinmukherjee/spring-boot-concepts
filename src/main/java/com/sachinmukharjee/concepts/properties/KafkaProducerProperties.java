package com.sachinmukharjee.concepts.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KafkaProducerProperties {
  private String keySerializer;
  private String valueSerializer;
}
