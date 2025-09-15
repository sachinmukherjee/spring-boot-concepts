package com.sachinmukharjee.concepts.event;

import lombok.Getter;
import org.springframework.boot.actuate.web.exchanges.HttpExchange;
import org.springframework.context.ApplicationEvent;

@Getter
public class HttpExchangeEvent extends ApplicationEvent {

    private final HttpExchange httpExchange;

    public HttpExchangeEvent(Object source,HttpExchange httpExchange) {
        super(source);
        this.httpExchange=httpExchange;
    }
}
