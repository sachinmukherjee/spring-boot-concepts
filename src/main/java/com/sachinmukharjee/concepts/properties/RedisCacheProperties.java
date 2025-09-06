package com.sachinmukharjee.concepts.properties;

import com.sachinmukharjee.concepts.condition.CacheEnableCondition;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(CacheEnableCondition.class)
@ConfigurationProperties("app.cache.redis")
public class RedisCacheProperties {

  private String host;
  private int port;

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
