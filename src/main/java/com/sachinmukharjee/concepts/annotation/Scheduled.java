package com.sachinmukharjee.concepts.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Scheduled {

    long initialDelay() default 10;
    long period() default 10;
    TimeUnit unit() default TimeUnit.SECONDS;

}
