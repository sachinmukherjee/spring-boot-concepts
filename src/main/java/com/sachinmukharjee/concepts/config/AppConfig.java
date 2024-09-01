package com.sachinmukharjee.concepts.config;

import com.sachinmukharjee.concepts.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public EmployeeService createEmployeeService(){
       LOGGER.info("Create Employee Service Bean......");
        return new EmployeeService(1);
    }
}
