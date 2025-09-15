package com.sachinmukharjee.concepts.config;

import java.util.concurrent.*;

import com.sachinmukharjee.concepts.dto.MDCTaskDecorator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ThreadConfig {

  @Bean(name = "scheduledThreadPoolExecutor")
  public ScheduledExecutorService scheduledThreadPoolExecutor() {
    return Executors.newScheduledThreadPool(10);
  }

  @Bean(name = "limitedVirtualExecutor")
  public ThreadPoolTaskExecutor limitedVirtualExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

    // Setting pool sizes won't matter much with virtual threads,
    // but you can still cap queue size if you want
    executor.setCorePoolSize(0);
    executor.setMaxPoolSize(Integer.MAX_VALUE);
    executor.setQueueCapacity(Integer.MAX_VALUE);
    executor.setTaskDecorator(new MDCTaskDecorator());

    // Use virtual threads
    ThreadFactory virtualThreadFactory = Thread.ofVirtual().factory();
    executor.setThreadFactory(virtualThreadFactory);

    executor.setThreadNamePrefix("virtual-thread-");
    executor.initialize();
    return executor;
  }

  @Bean("virtualExecutor")
  public ExecutorService virtualExecutor() {
    return Executors.newVirtualThreadPerTaskExecutor();
  }
}
