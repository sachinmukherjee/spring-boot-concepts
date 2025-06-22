package com.sachinmukharjee.concepts.mapper.impl;

import com.sachinmukharjee.concepts.dto.ProductDescriptionRequest;
import com.sachinmukharjee.concepts.dto.ProductDescriptionResponse;
import com.sachinmukharjee.concepts.dto.ProductRequest;
import com.sachinmukharjee.concepts.dto.ProductResponse;
import com.sachinmukharjee.concepts.entity.ProductDescriptionEntity;
import com.sachinmukharjee.concepts.entity.ProductEntity;
import com.sachinmukharjee.concepts.mapper.IProductDescriptionEntityMapper;
import com.sachinmukharjee.concepts.mapper.IProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class ProductEntityMapperImpl implements IProductEntityMapper {

  @Autowired private IProductDescriptionEntityMapper productDescriptionEntityMapper;

  @Override
  public ProductResponse toProductResponse(ProductEntity productEntity) {
    ProductResponse productResponse = new ProductResponse();
    Set<ProductDescriptionResponse> productDescriptionResponses = new LinkedHashSet<>();
    productResponse.setId(productEntity.getProductId());
    productResponse.setProductName(productEntity.getProductName());
    productResponse.setCategory(productEntity.getCategory());
    productResponse.setPrice(productEntity.getPrice());
    productResponse.setStockQuantity(productEntity.getStockQuantity());
    Optional.ofNullable(productEntity.getDescriptions())
        .orElse(Set.of())
        .forEach(
            description -> {
              ProductDescriptionResponse productDescriptionResponse =
                  productDescriptionEntityMapper.toProductDescriptionResponse(description);
              productDescriptionResponses.add(productDescriptionResponse);
            });
    productResponse.setDescription(productDescriptionResponses);
    return productResponse;
  }

  @Override
  public ProductEntity toProductEntity(ProductRequest productRequest) {
    ProductEntity productEntity = new ProductEntity();
    Set<ProductDescriptionEntity> productDescriptionEntities = new HashSet<>();
    productEntity.setProductName(productRequest.getProductName());
    productEntity.setCategory(productRequest.getCategory());
    productEntity.setPrice(productRequest.getPrice());
    productEntity.setStockQuantity(productRequest.getStockQuantity());

    Optional.ofNullable(productRequest.getDescription())
        .orElse(Set.of())
        .forEach(
            description -> {
              ProductDescriptionEntity productDescriptionEntity =
                  productDescriptionEntityMapper.toProductDescriptionEntity(description);
              productDescriptionEntities.add(productDescriptionEntity);
            });
    productEntity.setDescriptions(productDescriptionEntities);
    return productEntity;
  }
}
