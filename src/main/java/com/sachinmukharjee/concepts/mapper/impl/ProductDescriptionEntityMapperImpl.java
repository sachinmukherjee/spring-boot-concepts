package com.sachinmukharjee.concepts.mapper.impl;

import com.sachinmukharjee.concepts.dto.ProductDescriptionRequest;
import com.sachinmukharjee.concepts.dto.ProductDescriptionResponse;
import com.sachinmukharjee.concepts.entity.ProductDescriptionEntity;
import com.sachinmukharjee.concepts.mapper.IProductDescriptionEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductDescriptionEntityMapperImpl implements IProductDescriptionEntityMapper {

  @Override
  public ProductDescriptionResponse toProductDescriptionResponse(
      ProductDescriptionEntity productDescriptionEntity) {
    ProductDescriptionResponse productDescriptionResponse = new ProductDescriptionResponse();
    productDescriptionResponse.setId(productDescriptionEntity.getDescriptionId());
    productDescriptionResponse.setDescription(productDescriptionEntity.getDescription());
    productDescriptionResponse.setLanguageCode(productDescriptionEntity.getLanguageCode());
    return productDescriptionResponse;
  }

  @Override
  public ProductDescriptionEntity toProductDescriptionEntity(ProductDescriptionRequest productDescriptionRequest) {
    ProductDescriptionEntity productDescriptionEntity = new ProductDescriptionEntity();
    productDescriptionEntity.setDescription(productDescriptionRequest.getDescription());
    productDescriptionEntity.setLanguageCode(productDescriptionRequest.getLanguageCode());
    return productDescriptionEntity;
  }
}
