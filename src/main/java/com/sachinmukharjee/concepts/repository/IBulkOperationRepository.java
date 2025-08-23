package com.sachinmukharjee.concepts.repository;

import com.sachinmukharjee.concepts.entity.BulkOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBulkOperationRepository extends JpaRepository<BulkOperation,Long> {}
