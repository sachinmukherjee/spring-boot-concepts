package com.sachinmukharjee.concepts.config;

import com.sachinmukharjee.concepts.key.generator.CustomKeyGenerator;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {


    @Bean("customKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new CustomKeyGenerator();
    }
}
