package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.ProductRequest;
import com.sachinmukharjee.concepts.dto.ProductResponse;
import com.sachinmukharjee.concepts.dto.ProductSearchFilter;
import com.sachinmukharjee.concepts.entity.ProductEntity;
import com.sachinmukharjee.concepts.mapper.IProductEntityMapper;
import com.sachinmukharjee.concepts.repository.IProductCustomRepository;
import com.sachinmukharjee.concepts.repository.IProductRepository;
import com.sachinmukharjee.concepts.specification.ProductSpecification;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService implements IProductService {

  @Autowired private IProductRepository productRepository;

  @Autowired private IProductEntityMapper productMapper;

  @Autowired
  private IProductCustomRepository productCustomRepository;

  private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

  @Override
  @Transactional(readOnly = true)
  public List<ProductResponse> getAllProducts() {
    LOGGER.info("Get All Products");
    List<ProductEntity> productEntities = productRepository.findAll();
    return productEntities.stream().map(productMapper::toProductResponse).toList();
  }

  @Override
  @Transactional
  public void saveProduct(List<ProductRequest> productRequest) {
    LOGGER.info("Save Product");
    List<ProductEntity> productEntities =
        productRequest.stream().map(productMapper::toProductEntity).collect(Collectors.toList());
    productRepository.saveAll(productEntities);
  }

  @Override
  @Transactional
  public List<ProductResponse> getAllProducts(List<Long> productIds) {
    // List<ProductEntity> productEntities = productRepository.findByProductIds(productIds);
    List<ProductEntity> productEntities = productRepository.findByProductIdIn(productIds);
    return productEntities.stream().map(productMapper::toProductResponse).toList();
  }

  @Override
  @Transactional
  public List<ProductResponse> searchProducts(ProductSearchFilter productSearchFilter) {
    LOGGER.info("Search Products");

    //Using Specification
    /*
    Specification<ProductEntity> specification =
        Specification.where(ProductSpecification.productIdsIn(productSearchFilter.getProductIds()))
            .and(ProductSpecification.productNameLike(productSearchFilter.getProductName()));

    List<ProductEntity> productEntities = productRepository.findAll(specification);
    */
    //Using Criteria API
    List<ProductEntity> productEntities = productCustomRepository.findAll(productSearchFilter);

    return productEntities.stream().map(productMapper::toProductResponse).toList();
  }
}
