package com.sachinmukharjee.concepts.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HttpExchangeFilter {

  public boolean excludeURL(String path) {
    boolean isExcluded = false;
    if (path.startsWith("/actuator") || path.startsWith("/health")) {
      log.info("Path is Excluded from HttpExchange {}", path);
      isExcluded = true;
    }
    return isExcluded;
  }
}
