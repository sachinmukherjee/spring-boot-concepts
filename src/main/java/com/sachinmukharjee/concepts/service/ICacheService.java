package com.sachinmukharjee.concepts.service;

public interface ICacheService {

    Object get(String key);
    boolean put(String key, Object value,long ttl);
    boolean delete(String key);
}
