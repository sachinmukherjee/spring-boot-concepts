package com.sachinmukharjee.concepts.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@Slf4j
public class CalculatorService implements ICalculatorService {

  private ICacheService cacheService;

  @Override
  @Cacheable(value = "fibonaaci", keyGenerator = "customKeyGenerator", unless = "#result == 0")
  public long calculateFibonacci(int number) {
    log.info("Calculating Fibonacci for {}", number);
    if (number <= 1) return number;

    int a = 0, b = 1, result = 0;
    for (int i = 2; i <= number; i++) {
      result = a + b;
      a = b;
      b = result;
    }
    log.info("Fibonacci calculation done for the number {}", number);
    return result;
  }

  @Override
  public BigInteger calculateFactorial(int number) {
      if (number < 0) {
          throw new IllegalArgumentException("Factorial is not defined for negative numbers");
      }

      BigInteger result = BigInteger.ONE;
      for (int i = 2; i <= number; i++) {
          result = result.multiply(BigInteger.valueOf(i));
      }
      return result;
  }
}
