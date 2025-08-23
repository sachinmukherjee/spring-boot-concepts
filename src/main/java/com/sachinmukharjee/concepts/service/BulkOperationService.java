package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.entity.BulkOperation;
import com.sachinmukharjee.concepts.repository.IBulkOperationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class BulkOperationService implements IBulkOperationService {

  @Autowired private IBulkOperationRepository bulkOperationRepository;

  @Override
  @Transactional
  public boolean saveBulkData(int batchSize) {
    boolean isSuccess = false;
    List<BulkOperation> bulkOperationList = new ArrayList<>();
    IntStream.range(0, batchSize)
        .forEach(
            i -> {
              log.debug("Creating entity for index {}", i);
              BulkOperation bulkOperation = new BulkOperation();
              bulkOperation.setUuid(String.format("%s_%s", UUID.randomUUID().toString(), i));
              bulkOperationList.add(bulkOperation);
            });

    try {
      bulkOperationRepository.saveAll(bulkOperationList);
      isSuccess = true;
    } catch (Exception e) {
      log.error("Data Save Failed ", e);
    }
    return isSuccess;
  }
}
