package com.sachinmukharjee.concepts.filter;

import com.sachinmukharjee.concepts.token.JwtAuthenicationToken;
import com.sachinmukharjee.concepts.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
@Slf4j
public class JwtRefreshFilter extends OncePerRequestFilter {

  private final JwtUtils jwtUtils;
  private final AuthenticationManager authenticationManager;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    log.info("Inside JwtRefreshFilter");
    if (!request.getServletPath().equals("/v1/user/refresh-token")) {
      log.info("Not a request to refresh token");
      filterChain.doFilter(request, response);
      return;
    }
    log.info("Generating refresh token");
    String refreshToken = extractJwtFromRequest(request);
    if (null == refreshToken) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    JwtAuthenicationToken authenicationToken = new JwtAuthenicationToken(refreshToken);
    Authentication authentication = authenticationManager.authenticate(authenicationToken);
    if (authentication.isAuthenticated()) {
      String newToken = jwtUtils.generateToken(authentication.getName(), 15);
      response.setHeader("Authorization", "Bearer " + newToken);
    }
  }

  private String extractJwtFromRequest(HttpServletRequest request) {
    Cookie[] cookieArr = request.getCookies();
    if (null == cookieArr || cookieArr.length == 0) {
      return null;
    }

    String refreshToken = null;
    for (Cookie cookie : cookieArr) {
      if ("refreshToken".equals(cookie.getName())) {
        refreshToken = cookie.getValue();
      }
    }
    return refreshToken;
  }
}
