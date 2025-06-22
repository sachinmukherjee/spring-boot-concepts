package com.sachinmukharjee.concepts.filter;

import com.sachinmukharjee.concepts.token.JwtAuthenicationToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
@Slf4j
public class JwtValidationFilter extends OncePerRequestFilter {

  private final AuthenticationManager authenticationManager;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    log.info("Inside JwtValidationFilter");
    log.info("Validating JWT Token");
    String token = extractJwtFromRequest(request);
    if (null != token) {
      //Custom Authentication Token
      JwtAuthenicationToken authToken = new JwtAuthenicationToken(token);
      Authentication authentication = authenticationManager.authenticate(authToken);
      if (authentication.isAuthenticated()) {
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }

    filterChain.doFilter(request, response);
  }

  private String extractJwtFromRequest(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");
    if (null != bearerToken && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7);
    }
    return null;
  }
}
