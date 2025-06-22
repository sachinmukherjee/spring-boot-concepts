package com.sachinmukharjee.concepts.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthenicationToken extends AbstractAuthenticationToken {

  private final String token;

  public JwtAuthenicationToken(String token) {
    super(null);
    this.token = token;
    setAuthenticated(false);
  }

  public String getToken() {
    return token;
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return null;
  }
}
