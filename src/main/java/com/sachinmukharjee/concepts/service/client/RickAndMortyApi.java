package com.sachinmukharjee.concepts.service.client;

import com.sachinmukharjee.concepts.config.feign.MyFeignClientConfig;
import com.sachinmukharjee.concepts.dto.CharacterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "rick-and-morty",configuration = MyFeignClientConfig.class)
public interface RickAndMortyApi {

    @GetMapping("/character/")
    public CharacterResponse getCharacter(@RequestParam Integer page);
}
