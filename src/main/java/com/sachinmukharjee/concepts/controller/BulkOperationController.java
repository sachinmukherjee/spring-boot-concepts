package com.sachinmukharjee.concepts.controller;

import com.sachinmukharjee.concepts.service.IBulkOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/bulk")
public class BulkOperationController {

    @Autowired
    private IBulkOperationService bulkOperationService;

    @GetMapping(value = "/insert")
    public ResponseEntity<Boolean> batchInsert(@RequestParam(name = "batchSize") int batchSize){
        boolean result = bulkOperationService.saveBulkData(batchSize);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
