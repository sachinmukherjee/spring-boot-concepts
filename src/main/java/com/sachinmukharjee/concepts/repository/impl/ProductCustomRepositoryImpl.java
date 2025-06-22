package com.sachinmukharjee.concepts.repository.impl;

import com.sachinmukharjee.concepts.dto.ProductSearchFilter;
import com.sachinmukharjee.concepts.entity.ProductEntity;
import com.sachinmukharjee.concepts.repository.IProductCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductCustomRepositoryImpl implements IProductCustomRepository {

  @Autowired private EntityManager entityManager;

  @Override
  public List<ProductEntity> findAll(ProductSearchFilter productSearchFilter) {

    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<ProductEntity> cq = cb.createQuery(ProductEntity.class);
    Root<ProductEntity> root = cq.from(ProductEntity.class);

    //It adds 1 = 1 in where clause
    //Predicate predicate = cb.conjunction();

    //it adds 1 =! 1 in where clause
    Predicate predicate = cb.disjunction();

    if (productSearchFilter.getProductIds() != null
        && !productSearchFilter.getProductIds().isEmpty()) {
      predicate = cb.and(predicate, root.get("productId").in(productSearchFilter.getProductIds()));
    }

    if (productSearchFilter.getProductName() != null
        && !productSearchFilter.getProductName().isEmpty()) {
      predicate =
          cb.and(
              predicate,
              cb.like(root.get("productName"), "%" + productSearchFilter.getProductName() + "%"));
    }

    cq.where(predicate);

    TypedQuery<ProductEntity> query = entityManager.createQuery(cq);

    return query.getResultList();
  }
}
