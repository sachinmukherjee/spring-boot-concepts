package com.sachinmukharjee.concepts.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/passwordchecker")
public class PasswordCheckerController {

  @GetMapping("/check")
  public boolean checkPassword(@RequestParam String rawPassword,@RequestParam String hashedPassword) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    boolean isMatch = encoder.matches(rawPassword, hashedPassword);
    return isMatch;
  }
}
