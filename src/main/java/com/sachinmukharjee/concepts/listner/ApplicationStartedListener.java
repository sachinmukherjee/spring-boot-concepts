package com.sachinmukharjee.concepts.listner;

import com.sachinmukharjee.concepts.annotation.Scheduled;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.ScheduledExecutorService;

@Component
@Slf4j
public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent> {

  @Autowired private ApplicationContext applicationContext;

  @Autowired
  @Qualifier("scheduledThreadPoolExecutor")
  private ScheduledExecutorService executorService;

  @Override
  public void onApplicationEvent(ApplicationStartedEvent event) {
    log.info("Application Started.........");
    // Get all the beans
    String[] beans = applicationContext.getBeanDefinitionNames();
    for (String beanName : beans) {
      Object bean = applicationContext.getBean(beanName);
      Method[] methods = bean.getClass().getMethods();
      for (Method method : methods) {
        if (method.isAnnotationPresent(Scheduled.class)) {
          log.info("Bean Name {}, Method Name {}", beanName, method.getName());
          Scheduled scheduled = method.getAnnotation(Scheduled.class);
          executorService.scheduleAtFixedRate(
              () -> {
                try {
                  method.setAccessible(true);
                  method.invoke(bean);
                } catch (Exception e) {
                  e.printStackTrace();
                }
              },
              scheduled.initialDelay(),
              scheduled.period(),
              scheduled.unit());
        }
      }
    }
  }
}
