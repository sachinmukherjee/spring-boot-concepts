package com.sachinmukharjee.concepts.specification;

import com.sachinmukharjee.concepts.entity.ProductEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductSpecification {

  public static Specification<ProductEntity> productIdsIn(List<Long> productIds) {
    if (CollectionUtils.isEmpty(productIds)) return null;

    return (root, query, cb) -> root.get("productId").in(productIds);
  }

  public static Specification<ProductEntity> productNameLike(String productName) {
    if (productName == null) return null;

    return (root, query, cb) -> cb.like(root.get("productName"), "%" + productName + "%");
  }
}
