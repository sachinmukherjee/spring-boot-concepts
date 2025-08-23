package com.sachinmukharjee.concepts.controller;

import com.sachinmukharjee.concepts.dto.Response;
import com.sachinmukharjee.concepts.service.ICalculatorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping(value = "/v1/calculate")
@AllArgsConstructor
public class CacheController extends AbstractBaseController {

    private final ICalculatorService calculatorService;

    @GetMapping("fibonacci")
    public ResponseEntity<Response<Long>> calculateFibonacci(@RequestParam(required = true) Integer number){
        log.info("Got request to calculate fibonaaci");
        Long result = calculatorService.calculateFibonacci(number);
        return createSuccessResponse(result);
    }
}
