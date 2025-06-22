package com.sachinmukharjee.concepts.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sachinmukharjee.concepts.dto.LoginRequest;
import com.sachinmukharjee.concepts.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final AuthenticationManager authenticationManager;
  private final JwtUtils jwtUtils;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    log.info("Inside JwtAuthenticationFilter");
    if (!request.getServletPath().equals("/v1/user/generate-token")) {
      log.info("Not a request to  generate token");
      filterChain.doFilter(request, response);
      return;
    }
    log.info("Generating token");
    ObjectMapper objectMapper = new ObjectMapper();
    LoginRequest loginRequest =
        objectMapper.readValue(request.getInputStream(), LoginRequest.class);

    // Specially using UsernamePasswordAuthentication object so DaoAuthenticationProvider can handle
    // it
    UsernamePasswordAuthenticationToken authToken =
        new UsernamePasswordAuthenticationToken(
            loginRequest.getUsername(), loginRequest.getPassword());

    Authentication authResult = authenticationManager.authenticate(authToken);
    if (authResult.isAuthenticated()) {
      String token = jwtUtils.generateToken(loginRequest.getUsername(), 15);
      response.setHeader("Authorization", "Bearer " + token);


      //Generating Refresh Token
      String refreshToken = jwtUtils.generateToken(authResult.getName(),7*24*60);
      //Setting the refresh token in HttpOnly Cookie
      Cookie refreshCookie = new Cookie("refreshToken",refreshToken);
      refreshCookie.setHttpOnly(true);
      refreshCookie.setSecure(true);
      refreshCookie.setPath("/v1/user/refresh-token");
      refreshCookie.setMaxAge(7*24*60*60);
      response.addCookie(refreshCookie);
    }
  }
}
