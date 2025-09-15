package com.sachinmukharjee.concepts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "http_exchange")
public class HttpExchangeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "timestamp")
  private Instant timestamp;

  @Column(name = "method")
  private String method;

  @Column(length = 2000, name = "uri")
  private String uri;

  @Column(name = "request_headers")
  private String requestHeaders;

  @Column(name = "remote_address")
  private String remoteAddress;

  @Column(name = "response_status")
  private int responseStatus;

  @Column(name = "response_headers")
  private String responseHeaders;

  @Column(name = "duration_ms")
  private long durationMs;

  @Column(name = "session_id")
  private String sessionId;

  @Column(name = "principal")
  private String principalName;
}
