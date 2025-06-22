package com.sachinmukharjee.concepts.mapper;

import com.sachinmukharjee.concepts.dto.ProductRequest;
import com.sachinmukharjee.concepts.dto.ProductResponse;
import com.sachinmukharjee.concepts.entity.ProductEntity;

public interface IProductEntityMapper {

  ProductResponse toProductResponse(ProductEntity productEntity);

  ProductEntity toProductEntity(ProductRequest productRequest);
}
