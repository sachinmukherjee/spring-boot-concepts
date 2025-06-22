package com.sachinmukharjee.concepts.controller;

import com.sachinmukharjee.concepts.dto.ProductSearchFilter;
import com.sachinmukharjee.concepts.dto.ProductSearchResponse;
import com.sachinmukharjee.concepts.dto.Response;
import com.sachinmukharjee.concepts.dto.SalesResponse;
import com.sachinmukharjee.concepts.service.ISuperStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/superstore")
public class SuperStoreController extends AbstractBaseController {

  @Autowired private ISuperStoreService superStoreService;

  @GetMapping("/sales_sum")
  @PreAuthorize("hasRole('MANAGER')")
  public ResponseEntity<Response<List<SalesResponse>>> getSalesSum() {
    return createSuccessResponse(superStoreService.getSalesSum());
  }

  @GetMapping("/search")
  public ResponseEntity<List<ProductSearchResponse>> searchProduct(
      @RequestParam("productName") String productName) {
    ProductSearchFilter productSearchFilter =
        ProductSearchFilter.builder().productName(productName).build();
    return ResponseEntity.ok(superStoreService.searchProducts(productSearchFilter));
  }
}
