package com.sachinmukharjee.concepts.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheService implements ICacheService {


    private RedisTemplate<String,Object> redisTemplate;


    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public boolean put(String key, Object value, long ttl) {
        return false;
    }

    @Override
    public boolean delete(String key) {
        return false;
    }
}
