package com.sachinmukharjee.concepts.dto;

import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;

import java.util.Map;

public class MDCTaskDecorator implements TaskDecorator {

  @Override
  public Runnable decorate(Runnable runnable) {
    Map<String, String> contextMap = MDC.getCopyOfContextMap();
    return () -> {
      Map<String, String> previous = MDC.getCopyOfContextMap();
      try {
        if (contextMap != null) {
          MDC.setContextMap(contextMap);
        }
        runnable.run();
      } finally {
        if (previous != null) {
          MDC.setContextMap(previous);
        } else {
          MDC.clear();
        }
      }
    };
  }
}
