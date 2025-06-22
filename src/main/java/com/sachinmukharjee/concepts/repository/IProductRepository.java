package com.sachinmukharjee.concepts.repository;

import com.sachinmukharjee.concepts.entity.ProductEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {


    //JPQL Query. N+1 Problem
    @Query("select p from ProductEntity p where p.productId in :productIds")
    List<ProductEntity> findByProductIds(List<Long> productIds);


    //JPQL Query. Using Fetch
    @Query("select p from ProductEntity p LEFT JOIN FETCH p.descriptions where p.productId in :productIds")
    List<ProductEntity> findByProductIdIn(List<Long> productIds);


    List<ProductEntity> findAll(Specification<ProductEntity> specification);
}
