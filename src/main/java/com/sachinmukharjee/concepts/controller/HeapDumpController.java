package com.sachinmukharjee.concepts.controller;

import com.sachinmukharjee.concepts.repository.IStudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("v1/heapdump")
public class HeapDumpController {

    @Autowired
    private IStudentRepository studentRepository;

    @GetMapping("/queryCheck")
    public ResponseEntity<Void> validateQueryCaching() throws InterruptedException {
        log.info("HeapDumpController....");
        // BAD — different JPQL string each time
        for (int i = 0; i < 1000; i++) {
            studentRepository.findBad(); // Will create many HQLParser objects
        }

        // GOOD — same JPQL string, different params
        for (int i = 0; i < 1000; i++) {
            studentRepository.findGood("val" + i, "test");
        }

        System.out.println("Sleeping for heap dump...");
        Thread.sleep(5 * 60_000); // enough time to take a dump with jmap

        return ResponseEntity.ok(null);
    }
}
