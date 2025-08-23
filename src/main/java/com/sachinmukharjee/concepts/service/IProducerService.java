package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.Message;

public interface IProducerService {

  void sendMessage(Message message);
}
