package com.sachinmukharjee.concepts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@AllArgsConstructor
public class BackgroundTask implements Runnable {

  private String taskName;

  @Override
  public void run() {
    log.info("Executing Task {}", taskName);
  }
}
