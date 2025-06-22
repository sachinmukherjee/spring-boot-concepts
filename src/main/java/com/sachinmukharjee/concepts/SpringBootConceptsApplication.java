package com.sachinmukharjee.concepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class SpringBootConceptsApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootConceptsApplication.class, args);
  }
}
