package com.sachinmukharjee.concepts.service.client;

import com.sachinmukharjee.concepts.config.feign.MyFeignClientConfig;
import com.sachinmukharjee.concepts.dto.UuidResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "http-bin",configuration = MyFeignClientConfig.class)
public interface HttpBinAPi {


    @GetMapping("/uuid")
    UuidResponse getBookingId();
}
