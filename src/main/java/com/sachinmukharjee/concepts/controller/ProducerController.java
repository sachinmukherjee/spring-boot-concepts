package com.sachinmukharjee.concepts.controller;

import com.sachinmukharjee.concepts.dto.Message;
import com.sachinmukharjee.concepts.service.IProducerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/producer")
@AllArgsConstructor
public class ProducerController {

  private final IProducerService producerService;

  @PostMapping("/send")
  public ResponseEntity<Void> sendMessage(@RequestBody Message message) {
    producerService.sendMessage(message);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
