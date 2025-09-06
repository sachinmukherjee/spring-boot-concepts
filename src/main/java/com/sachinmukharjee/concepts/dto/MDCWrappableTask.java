package com.sachinmukharjee.concepts.dto;

import org.slf4j.MDC;

import java.util.Map;

public class MDCWrappableTask implements Runnable {
  private final Runnable task;
  private final Map<String, String> contextMap;

  public MDCWrappableTask(Runnable task) {
    this.task = task;
    this.contextMap = MDC.getCopyOfContextMap(); // capture current MDC
  }

  @Override
  public void run() {
    Map<String, String> previous = MDC.getCopyOfContextMap();
    try {
      if (contextMap != null) {
        MDC.setContextMap(contextMap); // set MDC for this thread
      }
      task.run();
    } finally {
      if (previous != null) {
        MDC.setContextMap(previous);
      } else {
        MDC.clear();
      }
    }
  }
}
