package com.sachinmukharjee.concepts.controller;

import com.sachinmukharjee.concepts.dto.UserRegister;
import com.sachinmukharjee.concepts.service.IUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/user")
@AllArgsConstructor
public class UserController {

  private IUserDetailsService userDetailsService;
  private PasswordEncoder passwordEncoder;

  @PostMapping("/register")
  public ResponseEntity<Void> registerUser(@RequestBody UserRegister userRegister) {
    userRegister.setEncodedPassword(passwordEncoder.encode(userRegister.getPassword()));
    userDetailsService.save(userRegister);
    return new ResponseEntity<>(null, null, 204);
  }

  @GetMapping
  public ResponseEntity<String> getUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return new ResponseEntity<>(authentication.getName(), null, 200);
  }
}
