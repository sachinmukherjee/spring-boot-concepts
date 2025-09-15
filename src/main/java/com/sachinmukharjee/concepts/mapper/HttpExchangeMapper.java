package com.sachinmukharjee.concepts.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sachinmukharjee.concepts.entity.HttpExchangeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.actuate.web.exchanges.HttpExchange;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface HttpExchangeMapper {

  // === HttpExchange -> Entity ===
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "timestamp", source = "timestamp")
  @Mapping(target = "method", source = "request.method")
  @Mapping(target = "uri", expression = "java(exchange.getRequest().getUri().toString())")
  @Mapping(
      target = "requestHeaders",
      expression = "java(toJson(exchange.getRequest().getHeaders()))")
  @Mapping(target = "remoteAddress", source = "request.remoteAddress")
  @Mapping(target = "responseStatus", source = "response.status")
  @Mapping(
      target = "responseHeaders",
      expression = "java(toJson(exchange.getResponse().getHeaders()))")
  @Mapping(
      target = "durationMs",
      expression = "java(exchange.getTimeTaken() != null ? exchange.getTimeTaken().toMillis() : 0)")
  @Mapping(
      target = "principalName",
      expression =
          "java(exchange.getPrincipal() != null ? exchange.getPrincipal().getName() : null)")
  @Mapping(
      target = "sessionId",
      expression = "java(exchange.getSession() != null ? exchange.getSession().getId() : null)")
  HttpExchangeEntity toEntity(HttpExchange exchange);

  // === Entity -> HttpExchange ===
  @Mapping(target = "request", expression = "java(toRequest(entity))")
  @Mapping(target = "response", expression = "java(toResponse(entity))")
  @Mapping(
      target = "principal",
      expression =
          "java(entity.getPrincipalName() != null ? new HttpExchange.Principal(entity.getPrincipalName()) : null)")
  @Mapping(
      target = "session",
      expression =
          "java(entity.getSessionId() != null ? new HttpExchange.Session(entity.getSessionId()) : null)")
  @Mapping(target = "timeTaken", expression = "java(Duration.ofMillis(entity.getDurationMs()))")
  HttpExchange toDto(HttpExchangeEntity entity);

  // === Custom helpers ===
  default String toJson(Object value) {
    try {
      return new ObjectMapper().writeValueAsString(value);
    } catch (Exception e) {
      return "{}";
    }
  }

  default Map<String, List<String>> fromJson(String json) {
    try {
      return new ObjectMapper().readValue(json, new TypeReference<Map<String, List<String>>>() {});
    } catch (Exception e) {
      return Collections.emptyMap();
    }
  }

  default HttpExchange.Request toRequest(HttpExchangeEntity entity) {
    return new HttpExchange.Request(
        URI.create(entity.getUri()),
        entity.getRemoteAddress(),
        entity.getMethod(),
        fromJson(entity.getRequestHeaders()));
  }

  default HttpExchange.Response toResponse(HttpExchangeEntity entity) {
    return new HttpExchange.Response(
        entity.getResponseStatus(), fromJson(entity.getResponseHeaders()));
  }
}
