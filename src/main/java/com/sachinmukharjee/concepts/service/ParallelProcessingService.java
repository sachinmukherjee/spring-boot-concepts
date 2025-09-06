package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.annotation.Scheduled;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ParallelProcessingService {

  @Scheduled(initialDelay = 5, period = 10, unit = java.util.concurrent.TimeUnit.SECONDS)
  public void taskOne() {
    log.info("Running Task One at {}", System.currentTimeMillis());
  }

  @Scheduled(initialDelay = 2, period = 5, unit = java.util.concurrent.TimeUnit.SECONDS)
  public void taskTwo() {
    log.info("Running Task Two at {}", System.currentTimeMillis());
  }
}
