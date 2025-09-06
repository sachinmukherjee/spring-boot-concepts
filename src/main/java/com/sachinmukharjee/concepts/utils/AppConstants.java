package com.sachinmukharjee.concepts.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppConstants {

  public static final String ROLE_PREFIX = "ROLE_%s";
  public static final String REQUEST_ID = "REQUEST_ID";
  public static final String TRACE_ID = "traceId";
  public static final String REDIS_ENABLED_CONDITION =
      "app.cache.redis.enabled";
}
