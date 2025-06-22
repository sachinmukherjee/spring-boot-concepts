package com.sachinmukharjee.concepts.repository;

import com.sachinmukharjee.concepts.dto.ProductSearchFilter;
import com.sachinmukharjee.concepts.entity.ProductEntity;

import java.util.List;

public interface IProductCustomRepository {

    List<ProductEntity> findAll(ProductSearchFilter productSearchFilter);
}
