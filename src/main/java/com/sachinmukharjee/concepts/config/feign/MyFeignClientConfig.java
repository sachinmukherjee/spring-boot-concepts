package com.sachinmukharjee.concepts.config.feign;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFeignClientConfig {

    @Bean
    public ErrorDecoder myCustomErrorDecoder(){
        return new CustomErrorDecoder();
    }
}
