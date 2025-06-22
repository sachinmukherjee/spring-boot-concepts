package com.sachinmukharjee.concepts.controller;

import com.sachinmukharjee.concepts.dto.ProductRequest;
import com.sachinmukharjee.concepts.dto.ProductResponse;
import com.sachinmukharjee.concepts.dto.ProductSearchContext;
import com.sachinmukharjee.concepts.dto.ProductSearchFilter;
import com.sachinmukharjee.concepts.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    private final static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        LOGGER.info("getAllProducts");
        List<ProductResponse> productResponses = productService.getAllProducts();
        return ResponseEntity.ok(productResponses);
    }

    @PostMapping
    public ResponseEntity<Void> saveProduct(@RequestBody List<ProductRequest> productRequest){
        LOGGER.info("saveProduct");
        try{
            productService.saveProduct(productRequest);
        }catch(Exception e){
            LOGGER.error("Failed to save product", e);
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getProductByIds")
    public ResponseEntity<List<ProductResponse>> getAllProductsByIds(@RequestParam List<Long> productIds){
        LOGGER.info("getAllProducts");
        List<ProductResponse> productResponses = productService.getAllProducts(productIds);
        return ResponseEntity.ok(productResponses);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> search(@RequestParam List<Long> productIds, @RequestParam String productName){
        LOGGER.info("Search Products");
        ProductSearchFilter productSearchFilter = ProductSearchFilter.builder().productIds(productIds).productName(productName).build();
        //ProductSearchContext productSearchContext = ProductSearchContext.builder().filter(productSearchFilter).build();
        List<ProductResponse> productResponses = productService.searchProducts(productSearchFilter);
        return ResponseEntity.ok(productResponses);
    }
}
