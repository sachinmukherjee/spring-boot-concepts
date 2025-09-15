package com.sachinmukharjee.concepts.repository.impl;

import com.sachinmukharjee.concepts.event.HttpExchangeEvent;
import com.sachinmukharjee.concepts.filter.HttpExchangeFilter;
import com.sachinmukharjee.concepts.mapper.HttpExchangeMapper;
import com.sachinmukharjee.concepts.repository.IHttpExchangeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.web.exchanges.HttpExchange;
import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Primary
@Repository
public class HttpExchangeRepositoryImpl implements HttpExchangeRepository {

  @Autowired private IHttpExchangeRepository httpExchangeRepository;

  @Autowired private HttpExchangeMapper httpExchangeMapper;

  @Autowired private HttpExchangeFilter httpExchangeFilter;

  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;


  @Override
  public List<HttpExchange> findAll() {
    return httpExchangeRepository
        .findAll(PageRequest.of(0, 100)) // safeguard
        .stream()
        .map(httpExchangeMapper::toDto)
        .toList();
  }

  @Override
  public void add(HttpExchange httpExchange) {
    if (httpExchangeFilter.excludeURL(httpExchange.getRequest().getUri().getPath())) {
      return;
    }
    log.info("Publishing HttpExchange Event");
    applicationEventPublisher.publishEvent(new HttpExchangeEvent(this,httpExchange));
  }
}
