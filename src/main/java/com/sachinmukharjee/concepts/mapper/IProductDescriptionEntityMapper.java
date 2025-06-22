package com.sachinmukharjee.concepts.mapper;

import com.sachinmukharjee.concepts.dto.ProductDescriptionRequest;
import com.sachinmukharjee.concepts.dto.ProductDescriptionResponse;
import com.sachinmukharjee.concepts.entity.ProductDescriptionEntity;

public interface IProductDescriptionEntityMapper {

  ProductDescriptionResponse toProductDescriptionResponse(
      ProductDescriptionEntity productDescriptionEntity);

  ProductDescriptionEntity toProductDescriptionEntity(ProductDescriptionRequest productDescriptionRequest);
}
