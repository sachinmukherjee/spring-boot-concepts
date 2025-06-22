package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.ProductRequest;
import com.sachinmukharjee.concepts.dto.ProductResponse;
import com.sachinmukharjee.concepts.dto.ProductSearchFilter;

import java.util.List;

public interface IProductService {

  List<ProductResponse> getAllProducts();

  void saveProduct(List<ProductRequest> productRequest);

  List<ProductResponse> getAllProducts(List<Long> productIds);

  List<ProductResponse> searchProducts(ProductSearchFilter productSearchFilter);
}
