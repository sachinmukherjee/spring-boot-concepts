package com.sachinmukharjee.concepts.repository;

import com.sachinmukharjee.concepts.dto.ProductSearchResponse;
import com.sachinmukharjee.concepts.dto.SalesResponse;
import com.sachinmukharjee.concepts.entity.SuperStore;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISuperStoreRepository extends JpaRepository<SuperStore, Integer> {

  //This is JPQL Query. Java Persistence Query Language
  @Query(
      "SELECT new com.sachinmukharjee.concepts.dto.SalesResponse(s.country,s.city,s.state,s.region,ROUND(SUM(s.sales),2)) from SuperStore s group by s.country,s.city,s.state,s.region")
  List<SalesResponse> getSalesSum();


  //List<ProductSearchResponse> searchProducts(@Param("productName") String productName);




}
