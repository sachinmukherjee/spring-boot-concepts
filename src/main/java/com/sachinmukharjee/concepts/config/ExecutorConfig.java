package com.sachinmukharjee.concepts.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorConfig {


    @Bean(name = "scheduledThreadPoolExecutor")
    public ScheduledExecutorService scheduledThreadPoolExecutor(){
        return Executors.newScheduledThreadPool(10);
    }
}
