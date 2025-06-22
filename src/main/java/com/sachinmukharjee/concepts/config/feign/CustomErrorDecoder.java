package com.sachinmukharjee.concepts.config.feign;

import com.sachinmukharjee.concepts.exception.APIException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {

  private final ErrorDecoder defaultErrorDecoder = new Default();

  @Override
  public Exception decode(String s, Response response) {
    log.info("Inside CustomErrorDecoder");
    HttpStatus status = HttpStatus.valueOf(response.status());
    if (status.is4xxClientError()) {
      log.error("Client Error Occured");
      return new APIException("Client Error");
    } else if (status.is5xxServerError()) {
      log.error("Server Error Occured");
      return new APIException("Server Error");
    } else {
      log.warn("Executing Default Error");
      return defaultErrorDecoder.decode(s, response);
    }
  }
}
