package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.ProductSearchFilter;
import com.sachinmukharjee.concepts.dto.ProductSearchResponse;
import com.sachinmukharjee.concepts.dto.SalesResponse;

import java.util.List;

public interface ISuperStoreService {


    List<SalesResponse> getSalesSum();


    List<ProductSearchResponse> searchProducts(ProductSearchFilter productSearchFilter);
}
