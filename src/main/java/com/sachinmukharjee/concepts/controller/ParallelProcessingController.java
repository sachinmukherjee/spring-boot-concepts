package com.sachinmukharjee.concepts.controller;


import com.sachinmukharjee.concepts.dto.BackgroundTask;
import com.sachinmukharjee.concepts.dto.MDCWrappableTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("v1/parallelprocessing")
public class ParallelProcessingController {

    @Autowired
    @Qualifier("scheduledThreadPoolExecutor")
    private ScheduledExecutorService executorService;

    @GetMapping("/schedule")
    public ResponseEntity<Void> executeScheduler(){
        log.info("Inside ParallelProcessingController");
        BackgroundTask backgroundTask = new BackgroundTask("BackGroundTaskController");
            executorService.scheduleAtFixedRate(new MDCWrappableTask(backgroundTask),5,5, TimeUnit.SECONDS);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
