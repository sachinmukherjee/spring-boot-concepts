package com.sachinmukharjee.concepts.condition;

import com.sachinmukharjee.concepts.utils.AppConstants;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class KafkaEnableCondition implements Condition {
  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    String enabled =
        context.getEnvironment().getProperty(AppConstants.KAFKA_ENABLED_CONDITION, "false");
    return Boolean.valueOf(enabled);
  }
}
