package com.sachinmukharjee.concepts.repository;

import com.sachinmukharjee.concepts.entity.HttpExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHttpExchangeRepository extends JpaRepository<HttpExchangeEntity,Long> {

}
