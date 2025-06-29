package com.sachinmukharjee.concepts.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class LoggingFilter extends OncePerRequestFilter {
  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    Authentication authBefore = SecurityContextHolder.getContext().getAuthentication();
    log.info("Before controller: {}", authBefore);
    try {
      filterChain.doFilter(request, response);
    } catch (Exception e) {
      log.error("Exception during filter chain ", e.getMessage());
      throw e;
    } finally {
      Authentication authAfter = SecurityContextHolder.getContext().getAuthentication();
      log.info("After controller: {}", authAfter);
    }
  }
}
