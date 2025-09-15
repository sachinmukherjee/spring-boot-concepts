package com.sachinmukharjee.concepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableFeignClients
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@EnableCaching
@EnableAsync
public class SpringBootConceptsApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootConceptsApplication.class, args);
  }
}
