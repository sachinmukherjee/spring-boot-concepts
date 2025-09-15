package com.sachinmukharjee.concepts.listner;

import com.sachinmukharjee.concepts.event.HttpExchangeEvent;
import com.sachinmukharjee.concepts.mapper.HttpExchangeMapper;
import com.sachinmukharjee.concepts.repository.IHttpExchangeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HttpExchangeListener implements ApplicationListener<HttpExchangeEvent> {

  @Autowired private IHttpExchangeRepository httpExchangeRepository;

  @Autowired private HttpExchangeMapper httpExchangeMapper;

  @Async
  @Override
  public void onApplicationEvent(HttpExchangeEvent event) {
    try {
      httpExchangeRepository.save(httpExchangeMapper.toEntity(event.getHttpExchange()));
    } catch (Exception e) {
      log.error("Error While Saving the data ", e);
    }
  }
}
