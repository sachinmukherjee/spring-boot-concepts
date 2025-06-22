package com.sachinmukharjee.concepts.authentication;

import com.sachinmukharjee.concepts.service.IUserDetailsService;
import com.sachinmukharjee.concepts.token.JwtAuthenicationToken;
import com.sachinmukharjee.concepts.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

  private final JwtUtils jwtUtils;
  private final IUserDetailsService userDetailsService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String token = ((JwtAuthenicationToken) authentication).getToken();

    String username = jwtUtils.validateAndExtractUsername(token);
    if (username == null) {
      throw new BadCredentialsException("Invalid JWT Token");
    }

    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
    return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return JwtAuthenicationToken.class.isAssignableFrom(authentication);
  }
}
