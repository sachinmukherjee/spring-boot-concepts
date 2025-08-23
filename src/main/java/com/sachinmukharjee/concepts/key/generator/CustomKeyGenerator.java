package com.sachinmukharjee.concepts.key.generator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

@Slf4j
public class CustomKeyGenerator implements KeyGenerator {
  @Override
  public Object generate(Object target, Method method, Object... params) {
    log.info("Generaing Key for {}", params);
    return target.getClass().getSimpleName()
        + "_"
        + method.getName()
        + "_"
        + StringUtils.arrayToDelimitedString(params, "_");
  }
}
