package com.sachinmukharjee.concepts.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class CustomAuthEntryPoint implements AuthenticationEntryPoint {

  @Override
  public void commence(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException authException)
      throws IOException, ServletException {

    response.setContentType("application/json");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

    Map<String, Object> body = new LinkedHashMap<>();
    //body.put("timestamp", LocalDateTime.now());
    body.put("success", false);
    body.put(
        "error",
        Map.of(
            "code", "BAD_CREDENTIALS",
            "message", "Invalid username or password"));

    response.getWriter().write(new ObjectMapper().writeValueAsString(body));
  }
}
