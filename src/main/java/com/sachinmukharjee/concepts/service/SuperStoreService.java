package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.ProductSearchFilter;
import com.sachinmukharjee.concepts.dto.ProductSearchResponse;
import com.sachinmukharjee.concepts.dto.SalesResponse;
import com.sachinmukharjee.concepts.repository.ISuperStoreRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SuperStoreService implements ISuperStoreService  {

    @Autowired
    private ISuperStoreRepository superStoreRepository;


    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(SuperStoreService.class);

    @Override
    @Transactional(readOnly = true)
    public List<SalesResponse> getSalesSum() {
        return superStoreRepository.getSalesSum();
    }

    @Override
    public List<ProductSearchResponse> searchProducts(ProductSearchFilter productSearchFilter) {
       String productName = productSearchFilter.getProductName();
        Query query = entityManager.createNamedQuery("SuperStore.searchProducts");
        query.setParameter("productName", productName);
        return query.getResultList();

    }


}
